/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

/**
 *
 * @author Gonzalo Delgado Crespo
 * Clase que almazena las matrices a modo de tablero del jugador 1 y 2
 * 
 */
public class Tablero {
    //Crear los tableros de juego
    private String [][] matriz;
    
    //creamos nuestro tablero y lo rellenamos
    public Tablero(){
        matriz = new String[10][10];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j]="-";
            }
        }
    }
    
    //Creamos el metodo para llenar la matriz
    public void mostrarTablero(String [][] matriz){
        System.out.println("Tablero: ");
        System.out.println("A B C D E F J H I J");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(i + " ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("-");
            }
        }
    }
}
