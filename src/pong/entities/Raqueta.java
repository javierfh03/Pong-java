package pong.entities;

import java.awt.Graphics;
import pong.ui.EventoTeclado;
import pong.ui.Ventana;

public class Raqueta{
    private int x, y, jugador, anchura, altura;
    private Ventana ventana;
    public final static byte JUGADOR1 = 1;
    public final static byte JUGADOR2 = 2;

    public Raqueta(Ventana ventana, int jugador) {
        this.jugador = jugador;      
        this.ventana = ventana;
        this.anchura = 10;
        this.altura = 60;
        
        if (jugador == JUGADOR1){
            x = 1;
        } else {
            x = ventana.getWidth() - 11;
        }
        
        y = (ventana.getHeight() / 2) - 10;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }
    
    public void moverY() {
        if (jugador == JUGADOR1){
            if (EventoTeclado.w) {
                moverArriba();
            }
            if (EventoTeclado.s) {
                moverAbajo();
            }
        } else {
            if (EventoTeclado.up) {
                moverArriba();
            }
            if (EventoTeclado.down) {
                moverAbajo();
            }
        }
    }
    
    private void moverArriba(){
        if (y > altura - (altura - 30)){
            this.y = y - 10;
        }
    }
    
    private void moverAbajo(){
        if (y < (ventana.getHeight() - altura)){
            this.y = y + 10;
        }
    }
    
    public void dibujar(Graphics g){
        g.fillRect(x, y, anchura, altura);
    }
}
