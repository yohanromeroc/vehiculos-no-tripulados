/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import config.Config;
import entities.Route;
import entities.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class VehicleExecutor {

    public static void executeRoutes(ArrayList<Route> routes, String fileLocation) throws Exception {
        // VERIFY THE ROUTES LIST SIZE
        if (routes.size() > Config.MAX_DAILY_ROUTES) {
            throw new Exception("Routes quantity is not valid");
        }

        // EXECUTE THE ROUTES
        Vehicle vehicle = new Vehicle(0, 0, 'N', routes);
        String log = vehicle.navigate();
        
        // EXPORT FILE
        FileExportService.exportLogToFile(fileLocation, Config.OUT_FILE_NAME, log);
    }
}
