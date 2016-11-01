/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import data.entities.Travel;
import data.entities.Traveler;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class main {
    
    public void main(String[] args){
        ArrayList<Travel> travels = new ArrayList<Travel>();
        
        Traveler traveler = new Traveler(4785848,"JUAN MACHADO","juanMachado@psl.com.co");
        
        travels.add(new Travel(traveler, new ['']));
    }
}
