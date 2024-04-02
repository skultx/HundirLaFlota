/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

/**
 *
 * @author lopmenal
 */
import java.util.Scanner;

public class HundirLaFlota {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        colocarBarcos(jugador1, sc);
        colocarBarcos(jugador2, sc);

        jugar(jugador1, jugador2, sc);

        sc.close(); // Cerrar el scanner al finalizar
    }

    private static void colocarBarcos(Jugador jugador1, Scanner sc) {
        System.out.println(jugador1.getNick() + ", coloca tus barcos:");
        jugador1.colocarBarcos(sc);
        System.out.println(); // Añadir una línea en blanco para una mejor legibilidad
    }

    private static void jugar(Jugador jugador1, Jugador jugador2, Scanner sc) {
        System.out.println("Empieza la guerra");
        boolean terminar = false;
        while (!terminar) {
            ejecutarTurno(jugador1, jugador2, sc);
            if (jugador2.getTablero1().flotaDestruida()) {
                mostrarResultado(jugador1);
                terminar = true;
            } else {
                ejecutarTurno(jugador2, jugador1, sc);
                if (jugador1.getTablero1().flotaDestruida()) {
                    mostrarResultado(jugador2);
                    terminar = true;
                }
            }
        }
    }

    private static void ejecutarTurno(Jugador atacante, Jugador defensor, Scanner sc) {
        System.out.println(atacante.getNick() + ", es tu turno:");
        System.out.println("Tu tablero:");
        atacante.mostrarTablero1();
        System.out.println("Tablero del oponente:");
        atacante.mostrarTablero2();
        atacante.disparar(defensor, sc);
    }

    private static void mostrarResultado(Jugador ganador) {
        System.out.println(ganador.getNick() + " ha ganado!");
    }
}
