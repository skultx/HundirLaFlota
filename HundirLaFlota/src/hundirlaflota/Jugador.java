/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

/**
 *
 * @author lopmenal
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    private String nick;
    private Tablero tablero1;
    private Tablero tablero2;
    private ArrayList<Barco> flota;

    public Jugador(String nick) {
        this.nick = nick;
        this.tablero1 = new Tablero();
        this.tablero2 = new Tablero();
        this.flota = new ArrayList<>();
    }

    private void inicializarTablero() {
        tablero1 = new Tablero();
        tablero2 = new Tablero();
    }

    public void colocarBarco(Barco barco, int fila, int columna, char orientacion) {
        if (tablero1.colocarBarco(barco, fila, columna, orientacion)) {
            System.out.println("Barco " + barco.getNombre() + " colocado en " + fila + ", " + columna);
        } else {
            System.out.println("No se pudo colocar el barco en la posición especificada.");
        }
    }

    public void mostrarTablero() {
        System.out.println("Tablero del jugador " + nick + ":");
        tablero1.mostrarTablero();
    }

    public void disparar(Jugador oponente, Scanner scanner) {
        System.out.println(nick + ", es tu turno de disparar:");
        oponente.mostrarTablero();
        System.out.print("Ingrese la fila [1-10]: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese la columna [A-J]: ");
        String columnaStr = scanner.next().toUpperCase();
        int columna = columnaStr.charAt(0) - 'A' + 1; // Convertir la letra a índice de columna (1-10)

        if (oponente.tablero1.disparar(fila, columna)) {
            System.out.println("¡Tocado!");
            oponente.responderDisparo(fila, columna, true);
        } else {
            System.out.println("¡Agua!");
            oponente.responderDisparo(fila, columna, false);
        }
    }

    public void responderDisparo(int fila, int columna, boolean acertado) {
        if (acertado) {
            System.out.println("¡Tocado!");
            tablero1.marcarDisparoExitoso(fila, columna);
        } else {
            System.out.println("¡Agua!");
            tablero1.marcarDisparoFallido(fila, columna);
        }
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setFlota(ArrayList<Barco> flota) {
        this.flota = flota;
    }

    public String getNick() {
        return nick;
    }

    public ArrayList<Barco> getFlota() {
        return flota;
    }
}

