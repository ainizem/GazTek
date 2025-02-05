package Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicio extends JFrame {

    public Inicio() {
        // ------------------ CONFIGURACIÓN DE LA VENTANA PRINCIPAL ---------------------
        setTitle("Imagen en JLabel al 100%");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);

        JPanel contentPanel = new JPanel(null);
        setContentPane(contentPanel);

        // -------------------- FONDO DE LA VENTANA -----------------------------------
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

        // ---------------------------- BOTÓN JUGAR -----------------------------------
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/NuevoBoton.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(170, 80, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        JButton btnPlay = new JButton("Jugar", iconoEscalado);
        btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnPlay.setBounds(820, 469, 170, 80);
        btnPlay.setHorizontalTextPosition(JButton.CENTER);
        btnPlay.setVerticalTextPosition(JButton.CENTER);
        btnPlay.setBorderPainted(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.setFocusPainted(false);
        btnPlay.setOpaque(false);

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Inicio.this, "¡Jugar presionado!");
            }
        });

        btnPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnPlay.setBounds(825, 459, 170, 80);
                btnPlay.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnPlay.setBounds(825, 469, 170, 80);
                btnPlay.setForeground(Color.BLACK);
            }
        });

        // ---------------------------- BOTÓN TUTORIAL ------------------------------
        JButton btnTutorial = new JButton("Tutorial", iconoEscalado);
        btnTutorial.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnTutorial.setBounds(825, 509, 170, 80);
        btnTutorial.setHorizontalTextPosition(JButton.CENTER);
        btnTutorial.setVerticalTextPosition(JButton.CENTER);
        btnTutorial.setBorderPainted(false);
        btnTutorial.setContentAreaFilled(false);
        btnTutorial.setFocusPainted(false);
        btnTutorial.setOpaque(false);
        
        btnTutorial.addActionListener(e -> switchWithFadeOut(new Prueba()));

        btnTutorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnTutorial.setBounds(825, 509, 190, 90);
                btnTutorial.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTutorial.setBounds(825, 509, 170, 80);
                btnTutorial.setForeground(Color.BLACK);
            }
        });

        // ---------------------------- BOTÓN SALIR -------------------------------
        ImageIcon iconOriginalExit = new ImageIcon(getClass().getResource("/imagenes/NuevoBoton.png"));
        Image imagenEscaladaExit = iconOriginalExit.getImage().getScaledInstance(170, 80, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaladoExit = new ImageIcon(imagenEscaladaExit);

        JButton btnExit = new JButton("Salir", iconoEscaladoExit);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnExit.setBounds(309, 338, 170, 80);
        btnExit.setHorizontalTextPosition(JButton.CENTER);
        btnExit.setVerticalTextPosition(JButton.CENTER);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusPainted(false);
        btnExit.setOpaque(false);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBounds(299, 328, 190, 90);
                btnExit.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBounds(309, 338, 170, 80);
                btnExit.setForeground(Color.BLACK);
            }
        });

        // ------------------------- AGREGAR COMPONENTES ---------------------------
        contentPanel.add(btnPlay);
        contentPanel.add(btnTutorial);
        contentPanel.add(btnExit);
        contentPanel.add(backgroundLabel);
        contentPanel.setOpaque(false);

        setVisible(true);
    }

    // Método para realizar la transición de fade out
    private void switchWithFadeOut(JFrame nextView) {
        nextView.setVisible(true);
        Timer timer = new Timer(20, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f;
                if (opacity <= 0) {
                    ((Timer) e.getSource()).stop();
                    dispose();  // Cierra la ventana actual
                } else {
                    setOpacity(opacity);  // Cambia la opacidad de la ventana actual
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new Inicio();
    }
}
