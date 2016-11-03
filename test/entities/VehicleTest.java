/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Passenger;
import entities.Vehicle;
import entities.Route;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yohan Romero
 */
public class VehicleTest {

    public VehicleTest() {
    }

    /**
     * Test of navigate method, of class Vehicle.
     */
    @Test
    public void testNavigate() throws Exception {
        System.out.println("navigate");

        ArrayList<Route> routes = new ArrayList<Route>();
        routes.add(new Route(new Passenger(4785848, " JUAN MACHADO", "juanMachado@psl.com.co"), "FFFFLFFR"));
        routes.add(new Route(new Passenger(43258987, " MARIA DELGADO", " "), "RRFLFR"));
        routes.add(new Route(new Passenger(789587, " PEDRO HEREDIA", "pedro@google.com"), "FFLFDFR"));

        Vehicle instance = new Vehicle(0, 0, 'N', routes);
        String expResult = "======= Reporte de Recorrido Vehículo X =============\r\n"
                + "(-2,4) Dirección Norte, Distancia: 0.6 kilómetros, 4785848,  JUAN MACHADO\r\n"
                + "(-1,3) Dirección Sur, Distancia: 0.2 kilómetros, 43258987,  MARIA DELGADO\r\n"
                + "(1,1) Dirección Sur, Distancia: 0.4 kilómetros, 789587,  PEDRO HEREDIA\r\n"
                + "Total recorridos: 1.2 Kilómetros.\r\n";
        String result = instance.navigate();
        assertEquals(expResult, result);
    }
}