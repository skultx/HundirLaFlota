/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

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
        this.figura = generarFigura();
    }

    private String generarFigura() {
        StringBuilder figuraBuilder = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            figuraBuilder.append(nombre.charAt(0));
        }
        return figuraBuilder.toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setFigura(String figura) {
        this.figura = figura;
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
