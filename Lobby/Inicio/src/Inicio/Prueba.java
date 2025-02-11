package Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

public class Prueba extends JFrame {

    private JLabel label;
    private String[] textos = {
            "En todos los niveles habran un cronometro",
            "Cada 5 segundos se perdera 1 punto",
            "Al final de la partida saldra una tabla con los que tengan mas puntos",
            "Antes de cada minijuego habra una explicacion de como se juega",
            "Fin del tutorial!",
            "Presiona la flecha de abajo a la izquierda"
    };
    private int indiceTextoActual = 0;
    private Font customFont;

    public Prueba() {

        // ---------------- Cargar Fuente Personalizada ----------------
        customFont = loadCustomFont("/Font/MinecraftStandard.otf", 24f);

        // ---------------- Configuracion de la Ventana ----------------
        setTitle("Texto Animado con Clic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);

        JPanel contentPanel = new JPanel(null);
        setContentPane(contentPanel);

        // ---------------- Imagen de Fondo ----------------
        ImageIcon imageIcon = new ImageIcon(Inicio.class.getResource("/imagenes/FondoInicio.png"));
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

        // ---------------- Imagen Flecha ----------------
        ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/imagenes/Flechas/FlechaIzquierda.png"));
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imagen2 = new ImageIcon(imagenEscalada);

        JButton btnFlecha = new JButton(imagen2);
        btnFlecha.setBounds(10, getHeight() - 80, 72, 58);
        btnFlecha.setBorderPainted(false);
        btnFlecha.setContentAreaFilled(false);
        btnFlecha.setFocusPainted(false);

        // ---------------- Accion Boton Flecha ----------------
        btnFlecha.addActionListener(e -> switchWithFadeOut(new Inicio()));

        // ---------------- Fondo Blanco Detrás del Texto (SIN TRANSPARENCIA) ----------------
        JPanel textBackgroundPanel = new JPanel();
        textBackgroundPanel.setBackground(Color.WHITE); // Fondo completamente blanco (sin transparencia)
        textBackgroundPanel.setBounds(0, 0, getWidth(), getHeight()); // Asegúrate de que ocupe todo el espacio

        // ---------------- Texto Superpuesto ----------------
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(customFont);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK); // Texto en color negro
        label.setBounds(0, 0, getWidth(), getHeight()); // Asegúrate de que el texto ocupe todo el espacio

        // ---------------- Agregar Componentes ----------------
        contentPanel.add(backgroundLabel);
        contentPanel.add(textBackgroundPanel); // Fondo blanco
        contentPanel.add(label);
        contentPanel.add(btnFlecha);

        contentPanel.setComponentZOrder(label, 0); // El texto debe estar sobre el fondo blanco
        contentPanel.setComponentZOrder(btnFlecha, 1);
        contentPanel.setComponentZOrder(backgroundLabel, 2);
        contentPanel.setComponentZOrder(textBackgroundPanel, 3); // El fondo blanco debe estar sobre la imagen de fondo

        // ---------------- Ajustar Componentes al Cambio de Tamano ----------------
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image scaledImage = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                backgroundLabel.setIcon(new ImageIcon(scaledImage));
                backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

                label.setBounds(0, 0, getWidth(), getHeight());
                btnFlecha.setBounds(10, getHeight() - 80, 72, 58);
                textBackgroundPanel.setBounds(0, 0, getWidth(), getHeight());

                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        // ---------------- Deteccion de Clic ----------------
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                siguienteTexto();
            }
        });

        setVisible(true);

        // Mostrar el primer texto con rapidez
        mostrarTexto(textos[indiceTextoActual], 10);  // Asegurando la velocidad rápida del primer texto
    }

    // ---------------- Metodo para Cargar Fuente Personalizada ----------------
    private Font loadCustomFont(String path, float size) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            if (is == null) {
                System.err.println("No se pudo cargar la fuente desde " + path);
                return new Font("Arial", Font.PLAIN, (int) size);
            }
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, (int) size);
        }
    }

    // ---------------- Metodo para Mostrar Texto Animado ----------------
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

    // ---------------- Metodo para Avanzar Texto ----------------
    public void siguienteTexto() {
        if (indiceTextoActual < textos.length - 1) {
            indiceTextoActual++;
            mostrarTexto(textos[indiceTextoActual], 10); // Asegurando que la velocidad del siguiente texto sea la misma
        } else {
            label.setText("No hay mas textos.");
        }
    }

    // ---------------- Metodo para Transicion con FadeOut ----------------
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