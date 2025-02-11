package InicioIngles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaENG extends JFrame {

    private JLabel label;
    private String[] textos = {
        "There will be a timer at all levels",
        "Every 5 seconds, you will lose 1 point",
        "At the end of the game, a leaderboard will appear with the highest scorers",
        "Before each mini-game, there will be an explanation of how to play",
        "End of the tutorial!",
        "Press the arrow at the bottom left"
    };

    private int indiceTextoActual = 0;

    public PruebaENG() {
        // ----------------------- CONFIGURACIÓN DE LA VENTANA ------------------------
        setTitle("Tutorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setResizable(false);

        JPanel contentPanel = new JPanel(null);
        setContentPane(contentPanel);

        // --------------------------- IMAGEN DE FONDO -------------------------------
        ImageIcon imageIcon = new ImageIcon(InicioENG.class.getResource("/imagenes/FondoInicio.png"));
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
        btnFlecha.addActionListener(e -> switchWithFadeOut(new InicioENG()));

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
        setVisible(true);

        mostrarTexto(textos[indiceTextoActual], 70); // Velocidad de la letra
    }

    public void mostrarTexto(String texto, int delay) {
        new Thread(() -> {
            // Mostrar texto letra por letra
            for (int i = 0; i <= texto.length(); i++) {
                String textoParcial = texto.substring(0, i);
                label.setText("<html>" + textoParcial.replaceAll("(?<=\\S)(?=\\p{P})", "$0&nbsp;") + "</html>");
                try {
                    Thread.sleep(delay); // Tiempo entre letras (menos de 2 segundos por texto)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Espera 5 segundos después de mostrar el texto completo
            try {
                Thread.sleep(1000); // Esperar 5 segundos antes de pasar al siguiente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            siguienteTexto(); // Pasar al siguiente texto
        }).start();
    }

    public void siguienteTexto() {
        if (indiceTextoActual < textos.length - 1) {
            indiceTextoActual++;
            mostrarTexto(textos[indiceTextoActual], 50); // Velocidad de la letra
        } else {
            label.setText("No more texts.");
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
    
    public static void main(String[] args) {
    	new PruebaENG();
    }
}
