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
        Scanner scanner = new Scanner(System.in);
        
        // Crear jugadores
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        
        // Colocar barcos de cada jugador
        colocarBarcos(jugador1, scanner);
        colocarBarcos(jugador2, scanner);
        
        // Comenzar el juego
        jugar(jugador1, jugador2, scanner);
        
        scanner.close();
    }
    
    // Método para que cada jugador coloque sus barcos en el tablero
    private static void colocarBarcos(Jugador jugador, Scanner scanner) {
        System.out.println(jugador.getNick() + ", coloca tus barcos:");
        for (Barco barco : jugador.getFlota()) {
            int fila, longitud;
            String columna;
            char orientacion;

            // Solicitar al jugador las coordenadas y orientación del barco
            System.out.println("Coloca tu " + barco.getNombre() + " de longitud " + barco.getLongitud());
            System.out.print("Fila (1-10): ");
            fila = scanner.nextInt();
            System.out.print("Columna (A-J): ");
            columna = scanner.next().toUpperCase();
            System.out.print("Orientación (H/V): ");
            orientacion = scanner.next().toUpperCase().charAt(0);

            // Colocar el barco en el tablero del jugador
            jugador.colocarBarco(barco, fila, columna);
        }
        System.out.println(jugador.getNick() + ", has colocado todos tus barcos.");
        System.out.println("Tu tablero:");
        jugador.mostrarTableroPropio();
        System.out.println();
    }
    
    // Método para iniciar el juego
    private static void jugar(Jugador jugador1, Jugador jugador2, Scanner scanner) {
        System.out.println("¡Comienza el juego!");
        while (true) {
            // Turno del jugador 1
            System.out.println(jugador1.getNick() + ", es tu turno:");
            jugador1.disparar(jugador2, scanner);
            if (jugador2.getFlota().isEmpty()) {
                System.out.println(jugador1.getNick() + " ha ganado!");
                break;
            }

            // Turno del jugador 2
            System.out.println(jugador2.getNick() + ", es tu turno:");
            jugador2.disparar(jugador1, scanner);
            if (jugador1.getFlota().isEmpty()) {
                System.out.println(jugador2.getNick() + " ha ganado!");
                break;
            }
        }
    }
}

