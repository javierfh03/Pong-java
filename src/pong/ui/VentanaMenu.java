package pong.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaMenu extends JFrame implements MouseListener{
    private JLabel jTitulo, jJuego, jSalir;

    public VentanaMenu() {
        inicializar();
        estilos();
        posicionar();
        
        add(jTitulo);
        add(jJuego);
        add(jSalir);
    }

    private void inicializar() {
        this.jTitulo = new JLabel("Pong", SwingConstants.CENTER);
        this.jJuego = new JLabel("Jugar", SwingConstants.CENTER);
        this.jSalir = new JLabel("Salir", SwingConstants.CENTER);
        
        jJuego.addMouseListener((MouseListener) this);
        jSalir.addMouseListener((MouseListener) this);
    }
    
    private void estilos() {
        setSize(600, 400);
        setBackground(Color.BLACK);
        setTitle("Pong");
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jTitulo.setFont(new Font("Vintage", Font.BOLD, 60));
        jJuego.setFont(new Font("Vintage", Font.BOLD, 25));
        jSalir.setFont(new Font("Vintage", Font.BOLD, 25));
        
        jTitulo.setForeground(Color.WHITE);
        jJuego.setForeground(Color.WHITE);
        jSalir.setForeground(Color.WHITE);
    }
    
    private void posicionar(){
        setLayout(null);
        
        jTitulo.setSize(200, 100);
        jTitulo.setLocation((getWidth() - jTitulo.getWidth())/2, 20);
        
        jJuego.setSize(200, 100);
        jJuego.setLocation((getWidth() - jTitulo.getWidth())/2, 140);
        
        jSalir.setSize(200, 100);
        jSalir.setLocation((getWidth() - jTitulo.getWidth())/2, 240);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(jJuego)){
            VentanaJuego v = new VentanaJuego();
            
            setVisible(false);
            v.setVisible(true);
        }else if (e.getSource().equals(jSalir)){
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(jJuego)){
            jJuego.setForeground(new Color(219, 219, 219));
        }else if (e.getSource().equals(jSalir)){
            jSalir.setForeground(new Color(219, 219, 219));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(jJuego)){
            jJuego.setForeground(Color.WHITE);
        }else if (e.getSource().equals(jSalir)){
            jSalir.setForeground(Color.WHITE);
        }
    }
}
