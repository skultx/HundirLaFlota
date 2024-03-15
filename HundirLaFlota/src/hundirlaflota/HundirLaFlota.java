/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

/**
 *
 * @author delcrego
 */
import java.util.Scanner;


public class HundirLaFlota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        colocarBarcos(jugador1);
        colocarBarcos(jugador2);

        jugar(jugador1, jugador2);

    }

    private static void colocarBarcos(Jugador jugador) {
        System.out.println(jugador.getNick() + " coloca tus barcos:");
        jugador.colocarBarcos();
    }

    private static void jugar(Jugador jugador1, Jugador jugador2) {
        System.out.println("A jugar");
        boolean terminar=true;
        while (terminar) {
            
            System.out.println(jugador1.getNick() + "te toca:");
            jugador1.mostrarTablero1();
            
            
            
            System.out.println("Tablero del oponente:");
            jugador1.mostrarTablero2();
            jugador1.disparar(jugador2);
            if (jugador2.getTablero1().flotaDestruida()) {
                System.out.println(jugador1.getNick() + " ha ganado!");
                terminar=false;
            }

            
            System.out.println(jugador2.getNick() + "te toca:");
            jugador2.mostrarTablero1();
            
            System.out.println("Tablero del oponente:");
            jugador2.mostrarTablero2();
            jugador2.disparar(jugador1);
            if (jugador1.getTablero1().flotaDestruida()) {
                System.out.println(jugador2.getNick() + " win");
                terminar=false;
            }
        }
        
    }
    
}

