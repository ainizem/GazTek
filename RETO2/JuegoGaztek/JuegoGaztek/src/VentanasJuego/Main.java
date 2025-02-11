package VentanasJuego;

import javax.swing.*;

import Conectar.Aleatorio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args) {
    	// Crear el JFrame
    	JFrame frame = new JFrame("Imagen en JLabel al 100%");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(800, 600);

        // Crear un JPanel para contener la imagen de fondo y los botones
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        frame.setContentPane(contentPanel);

        // Crear un JLabel con una imagen de fondo
        ImageIcon imageIcon = new ImageIcon("D:\\Benat\\RETO2\\1-7c7ee079.jpg"); // Ruta de tu imagen
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para los botones

        // Ajustar el layout para que los botones se adapten al tamaño de la ventana
        contentPanel.add(backgroundLabel, new GridBagConstraints());
        

        
        // Listener para ajustar el fondo al redimensionar la ventana
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                // Ajustar el tamaño del fondo
                backgroundLabel.setSize(frame.getSize());
                Image scaledImage = imageIcon.getImage().getScaledInstance(
                        frame.getWidth(),
                        frame.getHeight(),
                        Image.SCALE_SMOOTH
                );
                backgroundLabel.setIcon(new ImageIcon(scaledImage));
            }
        });
        frame.setVisible(true);
    }
}
