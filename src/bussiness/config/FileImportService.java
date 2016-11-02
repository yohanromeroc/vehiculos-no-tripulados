/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.config;

import data.entities.Travel;
import data.entities.Traveler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class FileImportService {

    public static ArrayList<Travel> importTravelsFromFile(String fileLocation, String fileName) throws FileNotFoundException, IOException, Exception {
        ArrayList<Travel> travels = new ArrayList<Travel>();

        BufferedReader reader = new BufferedReader(new FileReader(fileLocation + File.separator + fileName));
        String line = reader.readLine();

        int lineNumber = 0;
        while (line != null) {
            lineNumber++;
            String[] lineFields = line.split(Config.FILE_FIELD_SEPARATOR);

            if (lineFields.length != 4) {
                throw new Exception("Error reading line " + lineNumber);
            }

            String travelerDocument = lineFields[0];
            String travelerName = lineFields[1];
            String travelerEmail = lineFields[2];
            String movements = lineFields[3];
            int travelerDocumentNumber;

            // VALIDATES THE TRAVELER DOCUMENT
            if (travelerDocument.length() <= 10 && travelerDocument.length() >= 15) {
                throw new Exception("Traveler document length is invalid in line " + lineNumber);
            }
            try {
                travelerDocumentNumber = Integer.parseInt(travelerDocument);
            } catch (Exception ex) {
                throw new Exception("Traveler document is not a number in line " + lineNumber);
            }

            // VALIDATES THE TRAVELER NAME
            if (travelerName.length() > 200) {
                throw new Exception("Traveler name length is invalid in line " + lineNumber);
            }
            System.out.println("Traveler name: " + travelerName.replaceAll(" ", ""));
            //if (!travelerName.replaceAll(" ", "").matches("[A-Z]")) {
            //    throw new Exception("Traveler name format is invalid in line " + lineNumber);
            //}

            // VALIDATES THE TRAVELER EMAIL
            if (!travelerEmail.replaceAll(" ", "").isEmpty() && !travelerEmail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                throw new Exception("Traveler email format is invalid in line " + lineNumber);
            }

            // VALIDATE THE MOVEMENTS
            if (movements.matches("[FLR]")) {
                throw new Exception("Some vehicle movements are incorrect");
            }

            Traveler traveler = new Traveler(travelerDocumentNumber, travelerName, travelerEmail);
            Travel travel = new Travel(traveler, movements);

            travels.add(travel);
            line = reader.readLine();
        }

        return travels;
    }
}
