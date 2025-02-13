package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AulaView extends JFrame {

    private ImageIcon imageIcon; // Para la imagen de fondo
    private JLabel lblFondoAula; // Etiqueta para la imagen de fondo

    public AulaView() {
        getContentPane().setLayout(null);
        setBounds(100, 100, 1200, 620); // Tama�o inicial de la ventana

        // Maximizar la ventana con bordes visibles
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Cargar la imagen de fondo
        imageIcon = new ImageIcon("img\\claseR.jpg");

        // Bot�n Pasillo2
        JButton btnPasillo1 = new JButton("");
        btnPasillo1.setBounds(650, 650, 89, 35);
        getContentPane().add(btnPasillo1);
        btnPasillo1.setContentAreaFilled(false); // Fondo transparente
        btnPasillo1.setBorderPainted(false); // Sin bordes
        btnPasillo1.setFocusPainted(false); // Sin indicadores de enfoque
        btnPasillo1.setOpaque(false);

        btnPasillo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PasilloView().setVisible(true);
                dispose();
            }
        });
        

        // Etiqueta de la flecha hacia abajo
        JLabel lblPasillo1 = new JLabel("");
        lblPasillo1.setIcon(new ImageIcon("img\\flecha-abajo.png"));
        lblPasillo1.setBounds(650, 650, 89, 35);
        getContentPane().add(lblPasillo1);

        // Etiqueta de fondo (esto ser� actualizado con el redimensionado)
        lblFondoAula = new JLabel("");
        lblFondoAula.setBounds(0, 0, 1205, 570); // Tama�o inicial
        getContentPane().add(lblFondoAula);

        // A�adir el listener para redimensionar la imagen de fondo
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Redimensionar la imagen al tama�o de la ventana
                Image scaledImage = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                lblFondoAula.setIcon(new ImageIcon(scaledImage)); // Actualizar el icono del fondo
                lblFondoAula.setBounds(0, 0, getWidth(), getHeight()); // Ajustar el tama�o del fondo para cubrir toda la ventana

            }
        });
    }

    public static void main(String[] args) {
        new AulaView().setVisible(true);
    }
    private void switchWithFadeOut(JFrame nextView) {
        nextView.setVisible(true);
        Timer timer = new Timer(20, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f;
                if (opacity <= 0) {
                    ((Timer) e.getSource()).stop();
                    dispose();
                } else {
                    setOpacity(opacity);
                }
            }
        });
        timer.start();
    }
}
