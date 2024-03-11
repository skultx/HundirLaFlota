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
    protected int[][] tablero;
    protected ArrayList<Barco> flota;

    public Jugador(String nick) {
        this.nick = nick;
        this.tablero = new int[10][10];
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
        
    }

    public void mostrarTablero() {
        
    }

    public void disparar(Jugador oponente, int fila, int columna) {
      
    }

    public boolean haPerdido() {
        
        
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public void setFlota(ArrayList<Barco> flota) {
        this.flota = flota;
    }

    public String getNick() {
        return nick;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public ArrayList<Barco> getFlota() {
        return flota;
    }
    
}

