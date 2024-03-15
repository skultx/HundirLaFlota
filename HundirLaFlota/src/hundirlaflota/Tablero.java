/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;


import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Gonzalo Delgado Crespo
 * Clase que almazena las matrices a modo de tablero del jugador 1 y 2
 * 
 */

public class Tablero {
    private String[][] matriz;
    Scanner sc = new Scanner(System.in);
    protected ArrayList<Barco> flota = new ArrayList<>();
    
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
        ArrayList<Barco> flota = new ArrayList<>();
        flota.add(new Barco("Portaaviones", 5));
        flota.add(new Barco("Buque", 3));
        flota.add(new Barco("Submarino", 2));
        flota.add(new Barco("Lancha", 1));

        for (Barco barco : flota) {
            mostrarTablero();
            System.out.println("Coloca tu " + barco.getNombre() + " de longitud " + barco.getLongitud());

            int fila, columna, orientacion;
            do {
                System.out.print("Fila [1-10]: ");
                fila = sc.nextInt() - 1;
            } while (fila < 0 || fila > 9);

            do {
                System.out.print("Columna [A-J]: ");
                columna = sc.next().toUpperCase().charAt(0) - 'A';
            } while (columna < 0 || columna > 9);

            do {
                System.out.print("Orientación [0 para Horizontal 1 para Vertical]: ");
                orientacion = sc.nextInt();
            } while (orientacion != 0 && orientacion != 1);

            if (!orientacion(barco, fila, columna, orientacion)) {
                System.out.println("No se pudo colocar el barco ");
                colocarBarcos(); 
                
            }
        }
        System.out.println("Has colocado todos tus barcos.");
        System.out.println();
    }

    private boolean orientacion(Barco barco, int fila, int columna, int orientacion) {
        int longitud = barco.getLongitud();
        boolean salir=true;
        
        if (orientacion == 0) { 
            if (columna + longitud > 10) {
                salir=false;
            }
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila][columna + i].equals("A")) {
                    salir=false;
                }
            }
            for (int i = 0; i < longitud; i++) {
                matriz[fila][columna + i] = barco.getFigura();
            }
        } else { 
            if (fila + longitud > 10) {
                salir=false;
            }
            for (int i = 0; i < longitud; i++) {
                if (!matriz[fila + i][columna].equals("A")) {
                    salir=false;
                }
            }
            for (int i = 0; i < longitud; i++) {
                matriz[fila + i][columna] = barco.getFigura();
            }
        }
        return salir;
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
    Scanner sc = new Scanner(System.in);
    boolean salir = false;
    
    do {
        int fila, columna;
        do {
            System.out.print("Fila [1-10]: ");
            fila = sc.nextInt() - 1;
        } while (fila < 0 || fila > 9);

        do {
            System.out.print("Columna [A-J]: ");
            columna = sc.next().toUpperCase().charAt(0) - 'A';
        } while (columna < 0 || columna > 9);

        if (tablero.matriz[fila][columna].equals("A")) {
            System.out.println("Agua");
            tablero.matriz[fila][columna] = "O";
            salir = true;
        } else {
            System.out.println("Tocado");
            tablero.matriz[fila][columna] = "X";
        }
    } while (!salir);
}

    public boolean flotaDestruida() {
        boolean derrota=true;
        for (Barco barco : flota) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j].equals(barco.getFigura())) {
                        derrota=true;
                    }
                }
            }
        }
        return derrota;
    }
}



