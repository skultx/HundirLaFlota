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
    protected String nombre;
    protected int longitud;
    protected String figura;

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
