package pong.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pong.entities.Raqueta;

public class Ventana extends JFrame {
    
    private Raqueta jugador1, jugador2;
    private JPanel panel;

    public Ventana() throws HeadlessException {
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel = new JPanel();
        add(panel);
        
        jugador1 = new Raqueta(this, Raqueta.JUGADOR1);
        jugador2 = new Raqueta(this, Raqueta.JUGADOR2);
        
        EventoTeclado e = new EventoTeclado();
        e.setVentana(this);
        addKeyListener(e);
        
    }
    
    @Override
    public void paint(Graphics g) { 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        
        g.setColor(Color.WHITE);
        jugador1.dibujar(g);
        actualizar();
        jugador2.dibujar(g);
        actualizar();
    }
    
    public void actualizar(){
        jugador1.moverY();
        jugador2.moverY();
    }
}
