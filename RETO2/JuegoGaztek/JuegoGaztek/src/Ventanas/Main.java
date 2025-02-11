package Ventanas;

import javax.swing.*;

import Conectar.Aleatorio;
import PrimerJuego.Juego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args) {
    	
    	try {
			Aleatorio ale = new Aleatorio();
			ale.setVisible(true);
			ale.setSize(800, 600);
			ale.setVisible(false);
			
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
    	
        // Crear el JFrame
    	JFrame frame = new JFrame("Imagen en JLabel al 100%");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        // Tamaño completo
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);

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

        // Crear botones
        JButton btnPlay = new JButton("Jugar");
        JButton btnExit = new JButton("Salir");
        JButton btnIniciarSesion = new JButton("Iniciar sesión");

        // Configurar los botones para que se adapten al tamaño
        btnPlay.setPreferredSize(new Dimension(150, 40));
        btnExit.setPreferredSize(new Dimension(150, 40));
        btnIniciarSesion.setPreferredSize(new Dimension(150, 40));

        // Crear un nuevo GridBagConstraints para cada componente
        GridBagConstraints gbcPlay = new GridBagConstraints();
        gbcPlay.gridx = 0; // Volver a la columna 0 para los botones de "Jugar" y "Salir"
        gbcPlay.gridy = 1; // Mover a la siguiente fila
        gbcPlay.insets = new Insets(10, 50, 10, 10); // Espacio entre los botones
        gbcPlay.anchor = GridBagConstraints.CENTER;
        backgroundLabel.add(btnPlay, gbcPlay);

        GridBagConstraints gbcExit = new GridBagConstraints();
        gbcExit.gridx = 0;
        gbcExit.gridy = 2;
        gbcExit.insets = new Insets(10, 50, 10, 10); // Espacio entre los botones
        gbcExit.anchor = GridBagConstraints.CENTER;
        backgroundLabel.add(btnExit, gbcExit);

        // Mostrar la ventana
        frame.setVisible(true);
       
        
  
        
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana principal
                EstadoJuego estadoJuego = new EstadoJuego(3600); // O lo que sea necesario
                Juego juegoVentana = new Juego(estadoJuego); // Pasa el estado del juego
                juegoVentana.setVisible(true); // Muestra la nueva ventana
            }
        });
        
        frame.setVisible(true);


        
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Esto cerrará la aplicación
            }
        });
        
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
    }
}
