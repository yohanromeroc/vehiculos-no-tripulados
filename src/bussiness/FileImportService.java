package bussiness;

import config.Config;
import entities.Route;
import entities.Passenger;
import exceptions.InvalidPassengerDocumentException;
import exceptions.InvalidPassengerEmailException;
import exceptions.InvalidPassengerNameException;
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

            // VALIDATES THE TRAVELER DOCUMENT
            if (!validatePassengerDocument(passengerDocument)) {
                throw new InvalidPassengerDocumentException("Passenger document format is invalid at line " + lineNumber);
            }

            // VALIDATES THE PASSENGER NAME
            if (!validatePassengerName(passengerName)) {
                throw new InvalidPassengerNameException("Passenger name format is invalid at line " + lineNumber);
            }

            // VALIDATES THE PASSENGER EMAIL
            if (!validatePassengerEmail(passengerEmail)) {
                throw new InvalidPassengerEmailException("Passenger email format is invalid at line " + lineNumber);
            }

            // VALIDATE THE MOVEMENTS
            if (!validateMovements(movements)) {
                throw new Exception("Some route movements are incorrect at line " + lineNumber);
            }

            Passenger passenger = new Passenger(Integer.parseInt(passengerDocument), passengerName, passengerEmail);
            Route route = new Route(passenger, movements);

            routes.add(route);
            line = reader.readLine();
        }

        return routes;
    }

    public static boolean validatePassengerDocument(String document) {
        boolean valid = false;

        if (document.length() >= 10 && document.length() <= 15 && document.matches("[0-9]*")) {
            valid = true;
        }

        return valid;
    }

    public static boolean validatePassengerName(String name) {
        boolean valid = false;

        if (name.length() <= 200 && name.matches("[\\wÑñ ]*")) {
            valid = true;
        }

        return valid;
    }

    public static boolean validatePassengerEmail(String email) {
        boolean valid = false;

        if (email.replaceAll(" ", "").isEmpty() || email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            valid = true;
        }

        return valid;
    }

    public static boolean validateMovements(String movements) {
        boolean valid = false;

        if (movements.matches("[FLR]*")) {
            valid = true;
        }

        return valid;
    }
}
