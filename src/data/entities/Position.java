/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entities;

/**
 *
 * @author Administrador
 */
public class Position {

    private int x;
    private int y;
    private char direction;

    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
