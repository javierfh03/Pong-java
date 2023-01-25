package pong.ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pong.vistas.Menu;
import pong.vistas.Opciones;

/**
 * Esta ventana muestra el menú y las opciones del juego.
 * 
 * @author javier
 */
public class VentanaInicio extends JFrame {
    
    private JPanel menu, opciones;
    private CardLayout carta;

    public VentanaInicio() {
        inicializar();
        estilos();
        
        add(menu);
        add(opciones);
    }

    private void inicializar() {
        this.menu = new Menu();
        this.opciones = new Opciones();
    }
    
    private void estilos() {
        setSize(600, 400);
        setTitle("Pong");
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(carta = new CardLayout());
    }
    
    public void siguiente(){
        carta.next(getContentPane());
    }
}
