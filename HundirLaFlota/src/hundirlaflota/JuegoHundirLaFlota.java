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

public class JuegoHundirLaFlota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        
        colocarBarcos(jugador1);
        colocarBarcos(jugador2);

        
        jugar(jugador1, jugador2);

    }

    private static void colocarBarcos(Jugador jugador) {
        System.out.println(jugador.getNick() + ", coloca tus barcos:");
        for (Barco barco : jugador.getFlota()) {
            jugador.colocarBarco(barco);
            jugador.mostrarTableroPropio();
        }
        System.out.println(jugador.getNick() + ", has colocado todos tus barcos.");
        System.out.println();
    }

    private static void jugar(Jugador jugador1, Jugador jugador2) {
        System.out.println("¡Comienza el juego!");
        while (true) {
            
            jugador1.disparar(jugador2);
            if (jugador2.getFlota().isEmpty()) {
                System.out.println(jugador1.getNick() + " ha ganado!");
                
            }

            
            jugador2.disparar(jugador1);
            if (jugador1.getFlota().isEmpty()) {
                System.out.println(jugador2.getNick() + " ha ganado!");
               
            }
        }
    }
}


