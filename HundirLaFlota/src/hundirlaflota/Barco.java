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
    
    //Creamos nuestro arraylist para almacenar nuestros barcos
    protected ArrayList<Barco> flota = new ArrayList<>();

    //Atributos del barco
    protected String nombre;
    protected int longitud;
    protected String figura;
    
    //Constructor del barco
    public Barco(String nombre, int longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getFigura() {
        return figura;
    }

    //Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }
    
    //Asignamos una letra dependiendo de la longitud
    public void figura(){
        for (int i = 0; i < this.longitud; i++) {
            switch (this.longitud) {
                case 5:
                    this.figura="P";
                    break;
                case 3:
                    this.figura="B";
                    break;
                case 2:
                    this.figura="SS";
                    break;
                case 1:
                    this.figura="L";
                    break;
                default:
                    break;
            }
        }
        
    }
    
    //Añadimos los barcos
    public void añadirBarcos() {
        flota.add(new Barco("Portaviones", 5));
        flota.add(new Barco("Buque", 3));
        flota.add(new Barco("Submarino", 2));
        flota.add(new Barco("Lancha", 1));
        
    }
    
    
    @Override
    public String toString() {
        return "Barco{" + "flota=" + flota + ", nombre=" + nombre + ", longitud=" + longitud + ", figura=" + figura + '}';
    }
    
    

}
