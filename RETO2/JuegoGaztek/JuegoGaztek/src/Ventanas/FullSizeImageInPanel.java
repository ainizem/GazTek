package Ventanas;

import javax.swing.*;
import java.awt.*;

public class FullSizeImageInPanel {
    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Imagen en JLabel al 100%");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setLayout(null);

        // Crear un JLabel con una imagen de fondo
        ImageIcon imageIcon = new ImageIcon("D:\\Benat\\RETO2\\download.jpeg"); // Ruta de tu imagen
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setBounds(0, 0, 800, 600); // Tamaño inicial del fondo
        frame.getContentPane().add(backgroundLabel);

        // Ajustar el layout para que los botones se posicionen encima
        backgroundLabel.setLayout(null);

        // Crear botones
        JButton btnPlay = new JButton("Jugar");
        btnPlay.setBounds(325, 200, 150, 40);
        backgroundLabel.add(btnPlay);

        JButton btnExit = new JButton("Salir");
        btnExit.setBounds(325, 260, 150, 40);
        backgroundLabel.add(btnExit);
        
        JButton btnIniciarSesion = new JButton("Iniciar sesion");
        backgroundLabel.add(btnIniciarSesion);
        btnIniciarSesion.setBounds(423, 24, 150, 40);
        
        JButton btnCrearCuenta = new JButton("Crear cuenta");
        btnCrearCuenta.setBounds(609, 24, 150, 40);
        backgroundLabel.add(btnCrearCuenta);

        // Mostrar la ventana
        frame.setVisible(true);

        // Listener para ajustar el fondo al redimensionar la ventana
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                backgroundLabel.setSize(frame.getSize()); // Ajustar el tamaño del fondo
                Image scaledImage = imageIcon.getImage().getScaledInstance(
                        frame.getWidth(),
                        frame.getHeight(),
                        Image.SCALE_SMOOTH
                );
                backgroundLabel.setIcon(new ImageIcon(scaledImage));
            }
        });
    }
}
