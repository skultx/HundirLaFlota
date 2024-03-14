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
import java.util.Scanner;

public class Tablero {
    Scanner sc = new Scanner(System.in);
    protected String[][] matriz;

    public Tablero() {
        matriz = new String[10][10];
        inicializarTablero();
    }

    // Inicializa el tablero con agua en todas las posiciones
    private void inicializarTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = "A";
            }
        }
    }

    // Muestra el tablero actual
    public void mostrarTablero() {
        System.out.println("Tablero:");
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Coloca un barco en el tablero
    public void colocarBarco(Barco barco, int fila, int columna, char orientacion) {
        int longitud = barco.getLongitud();
        int columnaIndex = columna.charAt(0) - 'A';
        
        if (orientacion == 'H') {
            // Verificar si el barco cabe en esta orientación
            if (columnaIndex + longitud > 10) {
                System.out.println("El barco no cabe en esta posición. Inténtalo de nuevo.");
                return;
            }
            // Verificar si la posición está ocupada por otro barco
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila - 1][columnaIndex + i].equals("A")) {
                    System.out.println("Posición ocupada por otro barco. Inténtalo de nuevo.");
                    return;
                }
            }
            // Colocar el barco en el tablero
            for (int i = 0; i < longitud; i++) {
                matriz[fila - 1][columnaIndex + i] = barco.getFigura().substring(i, i + 1);
            }
        } else if (orientacion == 'V') {
            // Verificar si el barco cabe en esta orientación
            if (fila + longitud > 11) {
                System.out.println("El barco no cabe en esta posición. Inténtalo de nuevo.");
                return;
            }
            // Verificar si la posición está ocupada por otro barco
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila - 1 + i][columnaIndex].equals("A")) {
                    System.out.println("Posición ocupada por otro barco. Inténtalo de nuevo.");
                    return;
                }
            }
            // Colocar el barco en el tablero
            for (int i = 0; i < longitud; i++) {
                matriz[fila - 1 + i][columnaIndex] = barco.getFigura().substring(i, i + 1);
            }
        } else {
            System.out.println("Orientación no válida. Inténtalo de nuevo.");
            return;
        }
    }

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.mostrarTablero();
        
        // Ejemplo de cómo colocar un barco
        Barco portaviones = new Barco("Portaviones", 5);
        tablero.colocarBarco(portaviones, 1, "A", 'H');
        
        tablero.mostrarTablero();
    }
}
