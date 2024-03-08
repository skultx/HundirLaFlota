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
    String [][] tablero1;
    String [][] tablero2;
    
    //Metodo principal
    public static void main(String[] args) {
        //Definimos nuestras matrices
        String [][] tablero1=new String[10][10];
        String [][] tablero2=new String[10][10];
        
        tablero2(llenarMatriz)
        
    }
    
    //Creamos el metodo para llenar la matriz
    public String[][] llenarMatriz(String [][] tablero1, String [][] tablero2){
        for (int i = 0; i < tablero1.length; i++) {
            for (int j = 0; j < tablero1[0].length; j++) {
                System.out.println("-");
            }
        }
        for (int i = 0; i < tablero2.length; i++) {
            for (int j = 0; j < tablero2[0].length; j++) {
                System.out.println("-");
            }
        }
        
        
        return tablero1;
    }
}
