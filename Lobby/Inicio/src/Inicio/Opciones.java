package Inicio;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import InicioIngles.*;

public class Opciones extends JFrame {
	public Opciones() {

		setTitle("Opciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 774);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setResizable(false);

		JPanel contentPanel = new JPanel(null);
		setContentPane(contentPanel);

		// -------------------- FONDO DE LA VENTANA -----------------------------------
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/FondopOpciones.png"));
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

		// -------------------- FLECHA -----------------------------------
		ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/imagenes/Flechas/FlechaIzquierda.png"));
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon imagen2 = new ImageIcon(imagenEscalada);

		JButton btnFlecha = new JButton(imagen2);
		btnFlecha.setBounds(10, 701, 72, 50);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setFocusPainted(false);

		btnFlecha.addActionListener(e -> switchWithFadeOut(new Inicio()));
		
		// -------------------- OPCION ESPANOL -----------------------------------
		
		ImageIcon ImagenEspanol = new ImageIcon(getClass().getResource("/imagenes/Espanol.png"));
		Image imagen3 = ImagenEspanol.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH);  
		ImageIcon BanderaEsp = new ImageIcon(imagen3);  

		JButton banderaEsp = new JButton(BanderaEsp);
		banderaEsp.setBounds(536, 180, 350, 200);
		banderaEsp.setBorder(null);
		banderaEsp.setContentAreaFilled(false);
		banderaEsp.setFocusPainted(false);
		
		banderaEsp.addActionListener(e -> switchWithFadeOut(new Inicio()));
		
		banderaEsp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	banderaEsp.setMargin(new Insets(5, 5, 5, 5));
            	banderaEsp.setBorder(new LineBorder(Color.GREEN, 5));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	banderaEsp.setBorder(null);
            }
        });
		
		// -------------------- OPCION INGLES -----------------------------------
	
		ImageIcon ImagenIngles = new ImageIcon(getClass().getResource("/imagenes/Ingles.png"));
		Image imagen4 = ImagenIngles.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH);  
		ImageIcon BanderaENG = new ImageIcon(imagen4);  

		JButton banderaENG = new JButton(BanderaENG);
		banderaENG.setBounds(536, 425, 350, 200);
		banderaENG.setBorder(null);
		banderaENG.setContentAreaFilled(false);
		banderaENG.setFocusPainted(false);
		
		banderaENG.addActionListener(e -> switchWithFadeOut(new InicioENG()));
		
		banderaENG.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	banderaENG.setMargin(new Insets(5, 5, 5, 5));
            	banderaENG.setBorder(new LineBorder(Color.GREEN, 5));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	banderaENG.setBorder(null);
            }
        });
		
		// -------------------- SELECCION -----------------------------------
		
		ImageIcon imagenCartel = new ImageIcon(getClass().getResource("/imagenes/Tablero.png"));
		Image imagenTablero = imagenCartel.getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);  
		ImageIcon imagenTableroIcon = new ImageIcon(imagenTablero);  

		JButton tablero = new JButton(imagenTableroIcon);
		tablero.setBounds(501, 0, 1000, 1000); 
		tablero.setBorderPainted(false);
		tablero.setContentAreaFilled(false);
		tablero.setFocusPainted(false);
	
		// -------------------- VISIBLE -----------------------------------
		contentPanel.add(banderaENG);
		contentPanel.add(banderaEsp);
		contentPanel.add(btnFlecha);
		contentPanel.add(backgroundLabel);
		contentPanel.setOpaque(false);

		setVisible(true);
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

	// Corrected main method
	public static void main(String[] args) {
		new Opciones();
	}
}
