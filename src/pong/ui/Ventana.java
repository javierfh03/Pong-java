package pong.ui;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    private final static int ALTURA = 100;
    private final static int ANCHURA = 400;
    
    public Ventana() throws HeadlessException {
        Pista panel = new Pista(ALTURA, ANCHURA);
        EventoTeclado ev = new EventoTeclado(panel);
        
        add(panel);
        addKeyListener(ev);
        
        setSize(ALTURA, ANCHURA);
        setUndecorated(true);
        setLayout(null);
        setSize(panel.getWidth(), panel.getHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.yellow);
    }
}
