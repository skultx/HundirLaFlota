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
    private Tablero tableroPropio;
    private Tablero tableroOponente;
    private ArrayList<Barco> flota;
    Scanner sc=new Scanner(System.in);

    public Jugador(String nick) {
        this.nick = nick;
        this.tableroPropio = new Tablero();
        this.tableroOponente = new Tablero();
        this.flota = new ArrayList<>();
    }

    public void colocarBarco(Barco barco) {
        if (!tableroPropio.colocarBarco(barco, 0, nick, 0x0)) {
            System.out.println("No se pudo colocar el barco en la posición especificada. Inténtalo de nuevo.");
            colocarBarco(barco); // Intentar nuevamente hasta que se coloque correctamente
        }
    }

    public void mostrarTableroPropio() {
        System.out.println("Tablero propio de " + nick + ":");
        tableroPropio.mostrarTablero();
        System.out.println();
    }

    public void mostrarTableroOponente() {
        System.out.println("Tablero del oponente de " + nick + ":");
        tableroOponente.mostrarTablero();
        System.out.println();
    }

    public void disparar(Jugador oponente) {
        System.out.println(nick + ", es tu turno de disparar:");
        mostrarTableroOponente();

        int fila, columna;
        do {
            System.out.print("Ingrese la fila (1-10): ");
            fila = scanner.nextInt();
        } while (fila < 1 || fila > 10);

        do {
            System.out.print("Ingrese la columna (A-J): ");
            char colChar = scanner.next().toUpperCase().charAt(0);
            columna = colChar - 'A' + 1;
        } while (columna < 1 || columna > 10);

        if (oponente.tableroPropio.marcarDisparo(fila, columna)) {
            System.out.println("¡Tocado!");
            tableroOponente.marcarDisparoExitoso(fila, columna);
        } else {
            System.out.println("¡Agua!");
            tableroOponente.marcarDisparoFallido(fila, columna);
        }
    }

    public String getNick() {
        return nick;
    }

    public ArrayList<Barco> getFlota() {
        return flota;
    }
}