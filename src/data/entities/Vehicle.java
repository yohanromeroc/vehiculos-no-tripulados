/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entities;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Vehicle {

    private Position position;
    private ArrayList<Travel> travels;

    public Vehicle() {
        position = new Position(0, 0, 'N');
        travels = new ArrayList<Travel>();
    }

    public void addTravel(Travel travel) {
        if (travels.size() < 3) {
            travels.add(travel);
        } else {
            // Excepcion
        }
    }
}
