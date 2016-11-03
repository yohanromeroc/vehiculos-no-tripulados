/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import config.Config;
import entities.Route;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        if (args.length != 10) {
            throw new Exception("Please specify the IN.txt files location. Only one argument is accepted.");
        } else {
            // READ THE ARGUMENT
            String fileLocation = args[0];
            processFiles(fileLocation);
        }
    }

    private static void processFiles(final String fileLocation) throws Exception {
        try {
            for (int i = 1; i <= 20; i++) {
                // IMPORT FILE
                final ArrayList<Route> routes = FileImportService.importRoutesFromFile(fileLocation, "in" + i + ".txt");
                // EXECUTE ROUTES
                Runnable runable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            VehicleExecutor.executeRoutes(routes, fileLocation);
                        } catch (Exception ex) {
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
            }
        } catch (FileNotFoundException ex) {
            throw new Exception("An error has ocurred when reading the file " + Config.IN_FILE_NAME);
        } catch (IOException ex) {
            throw new Exception("File " + Config.IN_FILE_NAME + " not found");
        }
    }
}
