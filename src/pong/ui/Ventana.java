package pong.ui;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    private Pista panel;
    
    public Ventana() throws HeadlessException {
        this.panel = new Pista();
        EventoTeclado e = new EventoTeclado(panel);
        
        add(panel);
        addKeyListener(e);
        
        setLayout(null);
        setSize(panel.getWidth(), panel.getHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.yellow);
    }
}
