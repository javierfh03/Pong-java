package pong.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import pong.ui.VentanaInicio;
import pong.ui.VentanaJuego;

/**
 *
 * @author javier
 */
public class Opciones extends JPanel implements MouseListener {
    private ButtonGroup grupoPantalla, grupoVelocidad;
    private JRadioButton jRadioGrande, jRadioLenta, jRadioModerada, jRadioNormal,
            jRadioPeque, jRadioRapida;
    private JLabel jTamanio, jVelocidad, jIniciar;

    public Opciones() {
        inicializar();
        estilo();
        posicionar();
        
        add(jRadioGrande);
        add(jRadioNormal);
        add(jRadioPeque);
        add(jRadioRapida);
        add(jRadioModerada);
        add(jRadioLenta);
        add(jTamanio);
        add(jVelocidad);
        add(jIniciar);
        
        jRadioPeque.setSelected(true);
        jRadioModerada.setSelected(true);
        
        grupoPantalla.add(jRadioGrande);
        grupoPantalla.add(jRadioNormal);
        grupoPantalla.add(jRadioPeque);
        grupoVelocidad.add(jRadioRapida);
        grupoVelocidad.add(jRadioModerada);
        grupoVelocidad.add(jRadioLenta);
    }
    
    private void inicializar() {
        grupoPantalla = new ButtonGroup();
        grupoVelocidad = new ButtonGroup();
        jRadioGrande = new JRadioButton("1200 x 800");
        jRadioNormal = new JRadioButton("900 x 600");
        jRadioPeque = new JRadioButton("600 x 400");
        jRadioRapida = new JRadioButton("Rapida");
        jRadioModerada = new JRadioButton("Normal");
        jRadioLenta = new JRadioButton("Lenta");
        jTamanio = new JLabel("Tamaño pantalla");
        jVelocidad = new JLabel("Velocidad pelota");
        jIniciar = new JLabel ("Iniciar");
    }
    
    private void estilo() {
        setBackground(Color.BLACK);
        setSize(600, 400);
        setLayout(null);
        
        jRadioGrande.setForeground(new java.awt.Color(255, 255, 255));
        jRadioGrande.setBackground(Color.BLACK);

        jRadioNormal.setForeground(new java.awt.Color(255, 255, 255));
        jRadioNormal.setBackground(Color.BLACK);

        jRadioPeque.setForeground(new java.awt.Color(255, 255, 255));
        jRadioPeque.setBackground(Color.BLACK);

        jRadioRapida.setForeground(new java.awt.Color(255, 255, 255));
        jRadioRapida.setBackground(Color.BLACK);

        jRadioModerada.setForeground(new java.awt.Color(255, 255, 255));
        jRadioModerada.setBackground(Color.BLACK);

        jRadioLenta.setForeground(new java.awt.Color(255, 255, 255));
        jRadioLenta.setBackground(Color.BLACK);

        jTamanio.setFont(new java.awt.Font("Vintage", Font.BOLD, 14));
        jTamanio.setForeground(new java.awt.Color(255, 255, 255));

        jVelocidad.setFont(new java.awt.Font("Vintage", Font.BOLD, 14));
        jVelocidad.setForeground(new java.awt.Color(255, 255, 255));
        
        jIniciar.setFont(new Font("Vintage", Font.BOLD, 20));
        jIniciar.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    private void posicionar() {
        jVelocidad.setBounds(151, 183, 140, 17);
        jTamanio.setBounds(151, 100, 140, 17);
        jRadioGrande.setBounds(357, 135, 100, 19);
        jRadioLenta.setBounds(151, 218, 90, 19);
        jRadioModerada.setBounds(254, 218, 95, 19);
        jRadioRapida.setBounds(357, 218, 90, 19);
        jRadioPeque.setBounds(151, 135, 90, 19);
        jRadioNormal.setBounds(254, 135, 90, 19);
        jIniciar.setBounds((getWidth() - 100)/2, 250, 
                100, 100);
        jIniciar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        VentanaJuego vj;
        VentanaInicio vi = (VentanaInicio) this.getTopLevelAncestor();
        
        if (e.getSource().equals(jIniciar)) {
            if (jRadioNormal.isSelected()) {
                vj = new VentanaJuego(900, 600);
            } else if (jRadioGrande.isSelected()) {
                vj = new VentanaJuego(1200, 800);
            } else {
                vj = new VentanaJuego(600, 400);
            }
            
            if (jRadioModerada.isSelected()) {
                vj.establecerVelocidad(30);
            } else if (jRadioRapida.isSelected()) {
                vj.establecerVelocidad(20);
            } else {
                vj.establecerVelocidad(40);
            }
            
            vj.setVisible(true);
            vi.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(jIniciar)){
            jIniciar.setForeground(new Color(219, 219, 219));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(jIniciar)){
            jIniciar.setForeground(Color.WHITE);
        }
    }
}
