package pong.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import pong.entities.Raqueta;

public class Ventana extends JFrame implements KeyListener{
    private Raqueta jugador1, jugador2;
    private boolean repintar;

    public Ventana() throws HeadlessException {
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jugador1 = new Raqueta(this, Raqueta.IZQUIERDA);
        jugador2 = new Raqueta(this, Raqueta.DERECHA);
        repintar = false;
                
        addKeyListener(this);
    }
    
    @Override
    public void paint(Graphics g) { 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        
        g.setColor(Color.WHITE);
        jugador1.dibujar(g);
        jugador2.dibujar(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                jugador1.moverY(Raqueta.SUBIR);
                break;
            case KeyEvent.VK_S:
                jugador1.moverY(Raqueta.BAJAR);
                break;
            case KeyEvent.VK_UP:
                jugador2.moverY(Raqueta.SUBIR);
                break;
            case KeyEvent.VK_DOWN:
                jugador2.moverY(Raqueta.BAJAR);
                break;
        }
        
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
