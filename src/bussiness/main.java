/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import bussiness.config.Config;
import bussiness.config.FileExportService;
import bussiness.config.FileImportService;
import data.entities.Travel;
import data.entities.Vehicle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class main {

    public static void main(String[] args) throws Exception {
        // VERIFY THE ARGUMENT
        if (args.length != 1) {
            throw new Exception("Please specify the " + Config.IN_FILE_NAME + " file location. Only one argument is accepted.");
        } else {
            // READ THE ARGUMENT
            String fileLocation = args[0];
            processFile(fileLocation);
        }
    }

    private static void processFile(String fileLocation) throws Exception {
        try {
            // IMPORT FILE
            ArrayList<Travel> travels = FileImportService.importTravelsFromFile(fileLocation, Config.IN_FILE_NAME);

            // VERIFY THE TRAVELS LIST SIZE
            if (travels.size() > Config.MAX_DAILY_TRAVELS) {
                throw new Exception("Travels size is not valid");
            }

            // EXECUTE THE TRAVELS
            Vehicle vehicle = new Vehicle(0, 0, 'N', travels);
            String log = vehicle.navigate();
            
            // EXPORT FILE
            FileExportService.exportLogToFile(fileLocation, Config.OUT_FILE_NAME, log);
            
            System.out.println(log);

        } catch (FileNotFoundException ex) {
            throw new Exception("An error has ocurred when reading the file " + Config.IN_FILE_NAME);
        } catch (IOException ex) {
            throw new Exception("File " + Config.IN_FILE_NAME + " not found");
        }
    }
}
