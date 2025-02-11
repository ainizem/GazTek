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

public class BiblioView extends JFrame {

    private ImageIcon imageIcon; // Para la imagen de fondo
    private JLabel lblFondoBiblio; // Etiqueta para la imagen de fondo

    public BiblioView() {
        getContentPane().setLayout(null);
        setBounds(100, 100, 1200, 620); // Tamaño inicial de la ventana

        // Maximizar la ventana con bordes visibles
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Cargar la imagen de fondo
        imageIcon = new ImageIcon("img\\biblioR.jpg");

        // Botón Pasillo2
        JButton btnPasillo2 = new JButton("");
        btnPasillo2.setBounds(623, 660, 94, 35);

        getContentPane().add(btnPasillo2);
        btnPasillo2.setContentAreaFilled(false); // Fondo transparente
        btnPasillo2.setBorderPainted(false); // Sin bordes
        btnPasillo2.setFocusPainted(false); // Sin indicadores de enfoque
        btnPasillo2.setOpaque(false);

        btnPasillo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Pasillo2View().setVisible(true);
                dispose();
            }
        });
        

        // Etiqueta de la flecha hacia abajo
        JLabel lblPasillo2 = new JLabel("");
        lblPasillo2.setIcon(new ImageIcon("img\\flecha-abajo.png"));
        lblPasillo2.setBounds(623, 660, 94, 35);
        getContentPane().add(lblPasillo2);

        // Etiqueta de fondo (esto será actualizado con el redimensionado)
        lblFondoBiblio = new JLabel("");
        lblFondoBiblio.setBounds(0, 0, 1202, 570); // Tamaño inicial
        getContentPane().add(lblFondoBiblio);

        // Añadir el listener para redimensionar la imagen de fondo
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Redimensionar la imagen al tamaño de la ventana
                Image scaledImage = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                lblFondoBiblio.setIcon(new ImageIcon(scaledImage)); // Actualizar el icono del fondo
                lblFondoBiblio.setBounds(0, 0, getWidth(), getHeight()); // Ajustar el tamaño del fondo para cubrir toda la ventana

                // Redibujar la ventana
                revalidate();
                repaint();
            }
        });
    }

    public static void main(String[] args) {
        new BiblioView().setVisible(true);
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
