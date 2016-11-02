/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.entities;

import bussiness.config.Config;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Vehicle {

    private int positionX;
    private int positionY;
    private char direction;
    private int traveledDistance;
    private ArrayList<Travel> travels;

    public Vehicle(int positionX, int positionY, char direction, ArrayList<Travel> travels) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.travels = travels;
        this.traveledDistance = 0;
    }

    public String navigate() throws Exception {
        StringBuilder log = new StringBuilder();
        log.append("======= Reporte de Recorrido Vehículo X =============\r\n");

        for (Travel travel : travels) {
            int partialTraveledDistance = 0;

            String movements = travel.getMovements();
            for (int i = 0; i < movements.length(); i++) {
                char movement = movements.charAt(i);
                if (movement == 'F') {
                    if (direction == 'N') {
                        positionY++;
                    } else if (direction == 'S') {
                        positionY--;
                    } else if (direction == 'E') {
                        positionX++;
                    } else if (direction == 'W') {
                        positionX--;
                    }
                    // IT IS UNDERSTOOD THAT THE LIMIT AREA IS FORMED BY A SQUARE
                    if (Math.abs(positionX) > Config.MAX_STREET_RADIO || Math.abs(positionY) > Config.MAX_STREET_RADIO) {
                        throw new Exception("Vehicle out of range");
                    }
                    partialTraveledDistance += 100;
                } else if (movement == 'L') {
                    if (direction == 'N') {
                        direction = 'W';
                    } else if (direction == 'S') {
                        direction = 'E';
                    } else if (direction == 'E') {
                        direction = 'N';
                    } else if (direction == 'W') {
                        direction = 'S';
                    }
                } else if (movement == 'R') {
                    if (direction == 'N') {
                        direction = 'E';
                    } else if (direction == 'S') {
                        direction = 'W';
                    } else if (direction == 'E') {
                        direction = 'S';
                    } else if (direction == 'W') {
                        direction = 'N';
                    }
                }
            }
            log.append("(").append(positionX).append(",").append(positionY).append(") Dirección ");

            if (direction == 'N') {
                log.append("Norte");
            } else if (direction == 'S') {
                log.append("Sur");
            } else if (direction == 'W') {
                log.append("Occidente");
            } else if (direction == 'O') {
                log.append("Oriente");
            }

            log.append(", Distancia: ").append((double) partialTraveledDistance / (double) 1000).append(" kilómetros, ").append(travel.getTraveler().getDocument()).append(", ").append(travel.getTraveler().getName()).append("\r\n");
            traveledDistance += partialTraveledDistance;
        }

        log.append("Total recorridos: ").append((double) traveledDistance / (double) 1000).append(" Kilómetros.\r\n");
        return log.toString();
    }
}
