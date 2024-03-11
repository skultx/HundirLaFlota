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

    protected ArrayList<Barco> flota;

    protected String nombre;
    protected int longitud;
    protected String figura;

    public Barco() {
        flota = new ArrayList<>();
    }

    public Barco(String nombre, int longitud, String figura) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.figura = figura;
    }
    

    public void AñadirBarcos() {
        Barco flota1 = new Barco(nombre, longitud, figura);
        
        flota1.add("portaviones",5,"PPPPP");
    }

}
