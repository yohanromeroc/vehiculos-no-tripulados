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

    public static String executeRoutes(ArrayList<Route> routes) throws Exception {
        // VERIFY THE ROUTES LIST SIZE
        if (routes.size() > Config.MAX_DAILY_ROUTES) {
            throw new Exception("Routes quantity is not valid");
        }

        // EXECUTE THE ROUTES
        Vehicle vehicle = new Vehicle(0, 0, 'N', routes);
        String log = vehicle.navigate();

        return log;
    }
}
