package pong.entities;

import java.awt.Graphics;
import pong.ui.EventoTeclado;
import pong.ui.Pista;

public class Raqueta{
    private int x, y, jugador, anchura, altura;
    private Pista panel;
    public final static byte JUGADOR1 = 1;
    public final static byte JUGADOR2 = 2;

    public Raqueta(Pista panel, byte jugador) {
        this.jugador = jugador;      
        this.panel = panel;
        this.anchura = 10;
        this.altura = 60;
        
        if (jugador == JUGADOR1){
            x = 1;
        } else {
            x = panel.getWidth() - 11;
        }
        
        y = (panel.getHeight() / 2) - 30;
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
        if (y > 0){
            this.y = y - 10;
        }
    }
    
    private void moverAbajo(){
        if (y < (panel.getHeight() - altura)){
            this.y = y + 10;
        }
    }
    
    public void dibujar(Graphics g){
        g.fillRect(x, y, anchura, altura);
    }
}
