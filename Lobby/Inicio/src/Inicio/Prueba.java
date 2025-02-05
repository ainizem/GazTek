package Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Prueba extends JFrame {

    private JLabel label;
    private String[] textos = {
            "En todos los niveles habrán un cronometro",
            "Cada 5 segundos se perderá 1 punto",
            "Al final de la partida saldrá una tabla con los que tengan mas puntos",
            "Antes de cada minijuego habrá una explicación de como se juega",
            "¡Fin del tutorial!",
            "Presiona la flecha de abajo a la izquierda"
    };
    private int indiceTextoActual = 0;

    public Prueba() {

        // ----------------------- CONFIGURACIÓN DE LA VENTANA ------------------------
        setTitle("Texto Animado con Clic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setResizable(false);

        JPanel contentPanel = new JPanel(null);
        setContentPane(contentPanel);

        // --------------------------- IMAGEN DE FONDO -------------------------------
        ImageIcon imageIcon = new ImageIcon(Inicio.class.getResource("/imagenes/FondoInicio.png"));
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

        // --------------------------- IMAGEN FLECHA ----------------------------------
        ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/imagenes/Flechas/FlechaIzquierda.png"));
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imagen2 = new ImageIcon(imagenEscalada);

        JButton btnFlecha = new JButton(imagen2);
        btnFlecha.setBounds(10, getHeight() - 80, 72, 58);
        btnFlecha.setBorderPainted(false);
        btnFlecha.setContentAreaFilled(false);
        btnFlecha.setFocusPainted(false);

        // ------------------------- ACCIÓN BOTÓN FLECHA ----------------------------
        btnFlecha.addActionListener(e -> switchWithFadeOut(new Inicio()));

        // ------------------------- TEXTO SUPERPUESTO ------------------------------
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setBounds(0, 0, getWidth(), getHeight());

        // ------------------------ AGREGAR COMPONENTES ---------------------------
        contentPanel.add(backgroundLabel);
        contentPanel.add(label);
        contentPanel.add(btnFlecha);

        contentPanel.setComponentZOrder(label, 0);
        contentPanel.setComponentZOrder(btnFlecha, 1);
        contentPanel.setComponentZOrder(backgroundLabel, 2);

        // ------------------------ AJUSTAR COMPONENTES AL CAMBIO DE TAMAÑO ----------
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                Image scaledImage = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                backgroundLabel.setIcon(new ImageIcon(scaledImage));
                backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

                label.setBounds(0, 0, getWidth(), getHeight());
                btnFlecha.setBounds(10, getHeight() - 80, 72, 58); 

                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        // ---------------------- DETECCIÓN DE CLIC -------------------------------
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                siguienteTexto();
            }
        });

        setVisible(true);

        mostrarTexto(textos[indiceTextoActual], 100);
    }

    public void mostrarTexto(String texto, int delay) {
        new Thread(() -> {
            for (int i = 0; i <= texto.length(); i++) {
                String textoParcial = texto.substring(0, i);
                label.setText(textoParcial);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void siguienteTexto() {
        if (indiceTextoActual < textos.length - 1) {
            indiceTextoActual++;
            mostrarTexto(textos[indiceTextoActual], 10);
        } else {
            label.setText("No hay más textos.");
        }
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
