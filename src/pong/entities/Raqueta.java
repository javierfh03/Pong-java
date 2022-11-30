package pong.entities;

import java.awt.Graphics;
import pong.ui.Ventana;

public class Raqueta {
    private int x, y, anchura, altura;
    public final static byte DERECHA = 0;
    public final static byte IZQUIERDA = 1;
    public final static byte BAJAR = 0;
    public final static byte SUBIR = 1;

    public Raqueta(Ventana ventana, int posicion) {
        this.anchura = 10;
        this.altura = 50;
        
        if (posicion == IZQUIERDA){
            x = 1;
        } else {
            x = ventana.getWidth() - 11;
        }
        
        y = (ventana.getHeight() / 2) - 10;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void moverY(byte x) {
        if (x == BAJAR){
            this.y = y + 10;
        } else{
            this.y = y - 10;
        }
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }
    
    public void dibujar(Graphics g){
        g.fillRect(getX(), getY(), getAnchura(), getAltura());
    }
    
}
