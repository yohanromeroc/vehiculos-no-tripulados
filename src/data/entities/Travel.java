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
    private char[] movements;

    public Travel(Traveler traveler, char[] movements) {
        this.traveler = traveler;
        this.movements = movements;
    }
}
