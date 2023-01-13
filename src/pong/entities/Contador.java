package pong.entities;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Contador {
    private int x, y, jugador;
    private String numero;
    private final static int TAMANIO_LETRA = 40;
    
    public Contador(Dimension dimension, byte jugador) {
        this.jugador = jugador;
        
        if (jugador == Raqueta.JUGADOR1){
            x = dimension.width / 2 - 70;
        } else if (jugador == Raqueta.JUGADOR2) {
            x = dimension.width / 2 + 70;
        }
        
        y = 50;
        numero = 0 + "";
    }
    
    public void subirNumero(){
        int num = Integer.parseInt(numero);
        
        num++;
        numero = num + "";
    }
    
    public void dibujar(Graphics g){
        g.setFont(new Font("Arial", Font.PLAIN, TAMANIO_LETRA));
        
        
        if (jugador == Raqueta.JUGADOR1) {
            g.drawString(numero + "", x - getAnchoString(g), y);
        } else if (jugador == Raqueta.JUGADOR2) {
            g.drawString(numero + "", x, y);
        }
    }
    
    private int getAnchoString(Graphics g) {
        FontMetrics metrics = g.getFontMetrics();
        
        return metrics.stringWidth(numero);
    }
}
