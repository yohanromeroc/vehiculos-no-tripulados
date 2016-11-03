/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Yohan Romero
 */
public class Passenger {

    private int document;
    private String name;
    private String email;

    /**
     *
     * @param document The document number of the passenger
     * @param name The name of the passenger
     * @param email The email of the passenger
     */
    public Passenger(int document, String name, String email) {
        this.document = document;
        this.name = name;
        this.email = email;
    }

    /**
     *
     * @return The document number of the passenger
     */
    public int getDocument() {
        return document;
    }

    /**
     *
     * @param document The document number of the passenger
     */
    public void setDocument(int document) {
        this.document = document;
    }

    /**
     *
     * @return The name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name of the passenger
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The email of the passenger
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email The email of the passenger
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
