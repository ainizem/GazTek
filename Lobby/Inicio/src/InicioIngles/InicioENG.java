package InicioIngles;

import javax.swing.*;

import Inicio.Inicio;
import Inicio.Opciones;
import Inicio.Prueba;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

// ------- Clase Principal ------
public class InicioENG extends JFrame {

    private Font customFont;

    // ------- Constructor ------
    public InicioENG() {
        // ------------------ Configuracion de la Ventana Principal ---------------------
        setTitle("Imagen en JLabel al 100%");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);

        JPanel contentPanel = new JPanel(null);
        setContentPane(contentPanel);

        // ------- Cargar Fuente Personalizada ------
        customFont = loadCustomFont("/Font/MinecraftStandard.otf", 12f);

        // -------------------- Fondo de la Ventana -----------------------------------
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/FondoInicio.png"));
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setBounds(0, 0, 1921, 1014);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                Image scaledImage = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                backgroundLabel.setIcon(new ImageIcon(scaledImage));
                backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
            }
        });

        // ---------------------------- Titulo -----------------------------------
        JLabel titulo = new JLabel("Welcome to my Application!", JLabel.CENTER);
        titulo.setFont(customFont);
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(110, 150, getWidth(), 150);

        // ---------------------------- Botones -----------------------------------
        JButton btnPlay = createButton("Play", 606, 358);
        btnPlay.addActionListener(e -> JOptionPane.showMessageDialog(InicioENG.this, "Play pressed!"));

        JButton btnTutorial = createButton("Tutorial", 606, 489);
        btnTutorial.addActionListener(e -> switchWithFadeOut(new PruebaENG()));

        JButton btnExit = createButton("Exit", 606, 634);
        btnExit.addActionListener(e -> System.exit(0));

        JButton btnOpciones = createButton("Options", 1152, 679);
        btnOpciones.addActionListener(e -> switchWithFadeOut(new OpcionesENG()));

        // ------------------------- Agregar Componentes ---------------------------
        contentPanel.add(titulo);
        contentPanel.add(btnOpciones);
        contentPanel.add(btnPlay);
        contentPanel.add(btnTutorial);
        contentPanel.add(btnExit);
        contentPanel.add(backgroundLabel);
        contentPanel.setOpaque(false);

        setVisible(true);
    }

    // ------- Metodo para Cargar Fuente Personalizada ------
    private Font loadCustomFont(String path, float size) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            if (is == null) {
                System.err.println("No se pudo cargar la fuente desde " + path);
                return new Font("Arial", Font.PLAIN, (int) size);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
            return font;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, (int) size);
        }
    }

    // ------- Metodo para Crear Botones ------
    private JButton createButton(String text, int x, int y) {
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/NuevoBoton.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(170, 80, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        JButton button = new JButton(text, iconoEscalado);
        button.setFont(customFont);
        button.setBounds(x, y, 170, 80);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBounds(x, y, 190, 90);
                button.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBounds(x, y, 170, 80);
                button.setForeground(Color.BLACK);
            }
        });

        return button;
    }

    // ------- Metodo para Transicion con FadeOut ------
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

    // ------- Metodo Principal (Main) ------
    public static void main(String[] args) {
        new InicioENG();
    }
}
