/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author Gonzalo Delgado Crespo
 * Clase que almazena las matrices a modo de tablero del jugador 1 y 2
 * 
 */
public class Tablero {
    Scanner sc=new Scanner(System.in);
    
    //Crear los tableros de juego
    protected String [][] matriz =new String[10][10];
    private Barco barco;
    
    //Creamos nuestro tablero y lo rellenamos
    public Tablero(){
        matriz = new String[10][10];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j]="A";
            }
        }
    }
    
    //Creamos el metodo para llenar la matriz
    public void mostrarTablero(){
        System.out.println("Tablero: ");
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //creamos el metodo para meter los barcos en posicion
    public void colocarBarco() {

        Barco barco = new Barco("", 0);
        barco.añadirBarcos();

        for (Barco b : barco.flota) {
            System.out.println("Coloca tu " + b.getNombre() + " de " + b.getLongitud());
            System.out.println("filas[1,10]: ");
            int fila = sc.nextInt();

            sc.nextLine();

            System.out.println("columnas[A,J]: ");
            String columna = sc.nextLine().toUpperCase();

            //Validar los parametros
            if (fila < 1 || fila > 10 || columna.length() != 1 || columna.charAt(0) < 'A' || columna.charAt(0) > 'J') {
                System.out.println("Posición incorrecta. Inténtalo de nuevo.");
                colocarBarco();
            }

            // Pedir pos del barco
            System.out.println("H para horizontal V para vertical: ");
            char orientacion = sc.next().toUpperCase().charAt(0);
            
            // Colocar el barco
            switch (orientacion) {
                case 'H':
                    if (columna.charAt(0) + b.getLongitud() - 1 > 'J') {
                        System.out.println("El barco no cabe");
                        colocarBarco();
                    }   for (int i = 0; i < b.getLongitud(); i++) {
                        matriz[fila - 1][columna.charAt(0) - 'A' + i] = b.getFigura().substring(i, i + 1);
                    }   break;
                case 'V':
                    if (fila + b.getLongitud() - 1 > 10) {
                        System.out.println("El barco no cabe");
                        colocarBarco();
                    }   for (int i = 0; i < b.getLongitud(); i++) {
                        matriz[fila - 1 + i][columna.charAt(0) - 'A'] = b.getFigura().substring(i, i + 1);
                    }   break;
                default:
                    System.out.println("Error introduce H o V");
                    colocarBarco();
                    return;
            }
        }

    }
    public static void main(String[] args) {
        Tablero t = new Tablero();
        t.mostrarTablero();
        t.colocarBarco();
        t.mostrarTablero();
        
    }
        
}

