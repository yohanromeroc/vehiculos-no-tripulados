/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entities;

/**
 *
 * @author Administrador
 */
public class Travel {

    private Traveler traveler;
    private String movements;

    public Travel(Traveler traveler, String movements) {
        this.traveler = traveler;
        this.movements = movements;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }
}
