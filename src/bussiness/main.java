/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import config.Config;
import entities.Route;
import entities.Vehicle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yohan Romero
 */
public class main {

    /**
     *
     * @param args The arguments
     * @throws Exception
     */
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
            ArrayList<Route> routes = FileImportService.importRoutesFromFile(fileLocation, Config.IN_FILE_NAME);
            // EXECUTE ROUTES
            String log = VehicleExecutor.executeRoutes(routes);
            // EXPORT FILE
            FileExportService.exportLogToFile(fileLocation, Config.OUT_FILE_NAME, log);
        } catch (FileNotFoundException ex) {
            throw new Exception("An error has ocurred when reading the file " + Config.IN_FILE_NAME);
        } catch (IOException ex) {
            throw new Exception("File " + Config.IN_FILE_NAME + " not found");
        }
    }
}
