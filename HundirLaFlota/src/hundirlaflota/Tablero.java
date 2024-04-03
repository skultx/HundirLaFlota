/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gonzalo Delgado Crespo Clase que almazena las matrices a modo de
 * tablero del jugador 1 y 2
 *
 */
public class Tablero {
    Scanner sc = new Scanner(System.in);

    private String[][] matriz;
    private ArrayList<Barco> flota = new ArrayList<>();
    

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

    public void colocarBarcos() {
        flota.add(new Barco("Portaaviones", 5));
        flota.add(new Barco("Buque", 3));
        flota.add(new Barco("Submarino", 2));
        flota.add(new Barco("Lancha", 1));

        for (Barco barco : flota) {
            mostrarTablero();
            System.out.println("Coloca tu " + barco.getNombre() + " de longitud " + barco.getLongitud());

            int fila;
            int columna;
            int orientacion;
            boolean colocarCorrectamente = false;
            do {
                try {
                    System.out.print("Fila [1-10]: ");
                    fila = sc.nextInt() - 1;
                    if (fila < 0 || fila > 9) {
                        throw new InputMismatchException("Tienes que meter un valor entre 1 y 10");
                    }

                    System.out.print("Columna [A-J]: ");
                    columna = sc.next().toUpperCase().charAt(0) - 'A';

                    System.out.print("Orientación [0 para Horizontal, 1 para Vertical]: ");
                    orientacion = sc.nextInt();
                    if (orientacion != 0 && orientacion != 1) {
                        throw new InputMismatchException("Tienes que meter un valor entre 1 y 0");
                    }

                    if (!orientacion(barco, fila, columna, orientacion)) {
                        System.out.println("No se pudo colocar el barco");
                    } else {
                        colocarCorrectamente = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Introduce valores enteros");
                    sc.nextLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Introduce valores validos ");
                    sc.nextLine(); 
                }
            } while (!colocarCorrectamente);
        }
        System.out.println("Has colocado todos tus barcos.");
        System.out.println();
    }

    private boolean orientacion(Barco barco, int fila, int columna, int orientacion) {
        int longitud = barco.getLongitud();
        boolean puedeColocar = true;

        if (orientacion == 0) {
            if (columna + longitud > 10) {
                puedeColocar = false;
            }
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila][columna + i].equals("A")) {
                    puedeColocar = false;
                }
            }
            if (puedeColocar) {
                for (int i = 0; i < longitud; i++) {
                    matriz[fila][columna + i] = barco.getFigura();
                }
            }
        } else {
            if (fila + longitud > 10) {
                puedeColocar = false;
            }
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila + i][columna].equals("A")) {
                    puedeColocar = false;
                }
            }
            if (puedeColocar) {
                for (int i = 0; i < longitud; i++) {
                    matriz[fila + i][columna] = barco.getFigura();
                }
            }
        }
        return puedeColocar;
    }

    public void mostrarTablero() {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
    }

    public void mostrarTableroOculto() {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j].equals("X") || matriz[i][j].equals("O")) {
                    System.out.print(" " + matriz[i][j]);
                } else {
                    System.out.print(" A");
                }
            }
            System.out.println();
        }
    }

    public void disparar(Tablero tablero) {
        
        boolean disparoExitoso = false;
        do {
            int fila ;
            int columna;
            System.out.println("Introduce las coordenadas para disparar:");
            System.out.print("Fila [1-10]: ");
            fila = sc.nextInt() - 1;
            System.out.print("Columna [A-J]: ");
            columna = sc.next().toUpperCase().charAt(0) - 'A';
            if (fila < 0 || fila >= matriz.length) {
                System.out.println("Introduce un valor válido (1-10)."); 
            }

            if (tablero.matriz[fila][columna].equals("X") || tablero.matriz[fila][columna].equals("O")) {
                System.out.println("Ya has disparado en esta posición. Inténtalo de nuevo.");
            } else {
                System.out.println("Tocado");
                tablero.matriz[fila][columna] = "X";
                disparoExitoso = true;
            }
        } while (!disparoExitoso);
    }

    public boolean flotaDestruida() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (!matriz[i][j].equals("A") && !matriz[i][j].equals("X") && !matriz[i][j].equals("O")) {
                    return false;
                }
            }
        }
        return true; 
    }

}
