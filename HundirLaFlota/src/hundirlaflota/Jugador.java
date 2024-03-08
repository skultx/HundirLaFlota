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

public class Jugador {
    protected String nick;
    protected char[][] tablero;
    protected ArrayList<Barco> flota;

    public Jugador(String nick) {
        this.nick = nick;
        this.tablero = new char[10][10];
        inicializarTablero();
        this.flota = new ArrayList<>();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = 'A'; // 'A' representa agua
            }
        }
    }

    public void colocarBarco(Barco barco, int fila, int columna, boolean esVertical) {
        // Implementa la lógica para colocar el barco en el tablero
        // Verifica si la posición está ocupada, si el barco es demasiado grande, etc.
        // Actualiza el tablero con la figura del barco en las posiciones correspondientes
    }

    public void mostrarTablero() {
        // Muestra el tablero por pantalla
        // Puedes imprimirlo de la manera que prefieras
    }

    public void disparar(Jugador oponente, int fila, int columna) {
        // Implementa la lógica para disparar al oponente
        // Actualiza el tablero del oponente según el resultado del disparo
        // Si acierta, marca con 'O', si falla, marca con 'X'
    }

    public boolean haPerdido() {
        // Verifica si todos los barcos del jugador han sido hundidos
        // Devuelve true si ha perdido, false en caso contrario
        
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public void setFlota(ArrayList<Barco> flota) {
        this.flota = flota;
    }

    public String getNick() {
        return nick;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public ArrayList<Barco> getFlota() {
        return flota;
    }
    
}

