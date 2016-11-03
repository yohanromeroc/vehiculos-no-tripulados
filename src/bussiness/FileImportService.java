package bussiness;

import config.Config;
import entities.Route;
import entities.Passenger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is for file import purposes
 *
 * @author Yohan Romero
 */
public class FileImportService {

    /**
     *
     * @param fileLocation Is the path to the folder thah contains the file to
     * be imported
     * @param fileName Is the name of the file to be imported
     * @return A list of routes
     * @throws FileNotFoundException When the specified file not exists
     * @throws IOException When an error reading the file
     * @throws Exception When the contents of the file is not the expected
     */
    public static ArrayList<Route> importRoutesFromFile(String fileLocation, String fileName) throws FileNotFoundException, IOException, Exception {
        ArrayList<Route> routes = new ArrayList<Route>();

        BufferedReader reader = new BufferedReader(new FileReader(fileLocation + File.separator + fileName));
        String line = reader.readLine();

        int lineNumber = 0;
        while (line != null) {
            lineNumber++;
            String[] lineFields = line.split(Config.FILE_FIELD_SEPARATOR);

            if (lineFields.length != 4) {
                throw new Exception("Error reading line " + lineNumber);
            }

            String passengerDocument = lineFields[0];
            String passengerName = lineFields[1];
            String passengerEmail = lineFields[2];
            String movements = lineFields[3];
            int passengerDocumentNumber;

            // VALIDATES THE TRAVELER DOCUMENT
            if (passengerDocument.length() <= 10 && passengerDocument.length() >= 15) {
                throw new Exception("Passenger document length is invalid in line " + lineNumber);
            }
            try {
                passengerDocumentNumber = Integer.parseInt(passengerDocument);
            } catch (Exception ex) {
                throw new Exception("Passenger document is not a number in line " + lineNumber);
            }

            // VALIDATES THE TRAVELER NAME
            if (passengerName.length() > 200) {
                throw new Exception("Passenger name length is invalid in line " + lineNumber);
            }
            System.out.println("Passenger name: " + passengerName.replaceAll(" ", ""));
            //if (!travelerName.replaceAll(" ", "").matches("\\w")) { // This does not work
            //    throw new Exception("Traveler name format is invalid in line " + lineNumber);
            //}

            // VALIDATES THE TRAVELER EMAIL
            if (!passengerEmail.replaceAll(" ", "").isEmpty() && !passengerEmail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                throw new Exception("Passenger email format is invalid in line " + lineNumber);
            }

            // VALIDATE THE MOVEMENTS
            if (movements.matches("[FLR]")) {
                throw new Exception("Some route movements are incorrect");
            }

            Passenger passenger = new Passenger(passengerDocumentNumber, passengerName, passengerEmail);
            Route route = new Route(passenger, movements);

            routes.add(route);
            line = reader.readLine();
        }

        return routes;
    }
}
