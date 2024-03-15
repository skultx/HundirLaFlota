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

    private void inicializarTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = "A";
            }
        }
    }

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

    public void colocarBarco(Barco barco, int fila, String columna, int orientacion) {
        int longitud = barco.getLongitud();
        int columnaIndex = columna.charAt(0) - 'A';
        
        if (orientacion == 'H') {
            if (columnaIndex + longitud > 10) {
                System.out.println("El barco no cabe en esta posición. Inténtalo de nuevo.");
                return;
            }
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila - 1][columnaIndex + i].equals("A")) {
                    System.out.println("Posición ocupada por otro barco. Inténtalo de nuevo.");
                    return;
                }
            }
            for (int i = 0; i < longitud; i++) {
                matriz[fila - 1][columnaIndex + i] = barco.getFigura().substring(i, i + 1);
            }
        } else if (orientacion == 'V') {
            if (fila + longitud > 11) {
                System.out.println("El barco no cabe en esta posición. Inténtalo de nuevo.");
                return;
            }
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila - 1 + i][columnaIndex].equals("A")) {
                    System.out.println("Posición ocupada por otro barco. Inténtalo de nuevo.");
                    return;
                }
            }
            for (int i = 0; i < longitud; i++) {
                matriz[fila - 1 + i][columnaIndex] = barco.getFigura().substring(i, i + 1);
            }
        } else {
            System.out.println("Orientación no válida. Inténtalo de nuevo.");
            return;
        }
    }

    public void marcarDisparoExitoso(int fila, int columna) {
        if (matriz[fila - 1][columna - 'A'].equals("A")) {
            matriz[fila - 1][columna - 'A'] = "X";
        }
    }

    public void marcarDisparoFallido(int fila, int columna) {
        if (matriz[fila - 1][columna - 'A'].equals("A")) {
            matriz[fila - 1][columna - 'A'] = "O";
        }
    }
}

