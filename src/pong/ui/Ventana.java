package pong.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana() throws HeadlessException {
        Pista p = new Pista();
        EventoTeclado e = new EventoTeclado(p);
        
        add(p);
        addKeyListener(e);
        
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
