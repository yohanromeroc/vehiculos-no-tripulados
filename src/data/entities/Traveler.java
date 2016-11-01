/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entities;

/**
 *
 * @author Administrador
 */
public class Traveler {

    private int document;
    private String name;
    private String email;

    public Traveler(int document, String name, String email) {
        this.document = document;
        this.name = name;
        this.email = email;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
