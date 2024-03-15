/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hundirlaflota;

/**
 *
 * @author lopmenal
 */



public class Jugador {
    private String nick;
    private Tablero tablero1;
    private Tablero tablero2;

    public Jugador(String nick) {
        this.nick = nick;
        this.tablero1 = new Tablero();
        this.tablero2 = new Tablero();
    }

    public void colocarBarcos() {
        tablero1.colocarBarcos();
    }

    public void mostrarTablero1() {
        tablero1.mostrarTablero();
    }

    public void mostrarTablero2() {
        tablero2.mostrarTableroOculto();
    }

    public void disparar(Jugador oponente) {
        tablero2.disparar(oponente.tablero1);
    }

    public String getNick() {
        return nick;
    }

    public Tablero getTablero1() {
        return tablero1;
    }
}
