/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author lopmenal
 */
public class Jugador {
    Scanner sc = new Scanner(System.in);
    
    private String nick;
    private Tablero tablero1;
    private Tablero tablero2;
    

    public Jugador(String nick) {
        this.nick = nick;
        this.tablero1 = new Tablero();
        this.tablero2 = new Tablero();
    }

    public void colocarBarcos() {
        System.out.println(nick + "coloca tus barcos:");
        tablero1.colocarBarcos();
    }

    public void mostrarTablero1() {
        System.out.println("Tablero de " + nick + ":");
        tablero1.mostrarTablero();
    }

    public void mostrarTablero2() {
        System.out.println("Tablero del oponente " + nick + ":");
        tablero2.mostrarTableroOculto();
    }

    public void disparar(Jugador oponente) {
        System.out.println(nick + " es tu turno:");
        tablero2.disparar(oponente.tablero1);
        mostrarTablero1();
    }

    public String getNick() {
        return nick;
    }

    public Tablero getTablero1() {
        return tablero1;
    }

    public Tablero getTablero2() {
        return tablero2;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setTablero1(Tablero tablero1) {
        this.tablero1 = tablero1;
    }

    public void setTablero2(Tablero tablero2) {
        this.tablero2 = tablero2;
    }

}
