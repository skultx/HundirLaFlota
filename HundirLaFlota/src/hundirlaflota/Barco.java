/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

import java.util.ArrayList;

/**
 *
 * @author delcrego
 */

public class Barco {

    private String nombre;
    private int longitud;
    private String figura;

    public Barco(String nombre, int longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.figura = obtenerFigura();
    }

    private String obtenerFigura() {
        switch (longitud) {
            case 5:
                this.figura = "P";
                break;
            case 3:
                this.figura = "B";
                break;
            case 2:
                this.figura = "S";
                break;
            case 1:
                this.figura = "L";
                break;
            default:
                this.figura = "";
                break;

        }
        return this.figura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getFigura() {
        return figura;
    }
}

