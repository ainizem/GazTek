package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pasillo2View extends JFrame {
	public Pasillo2View() {
		getContentPane().setLayout(null);
		setBounds(0, 0, 1366, 768);		
		
		JButton btnBiblio = new JButton("");
		btnBiblio.setBounds(401, 157, 33, 142);
		getContentPane().add(btnBiblio);
		btnBiblio.setContentAreaFilled(false); // Fondo transparente
		btnBiblio.setBorderPainted(false); // Sin bordes
		btnBiblio.setFocusPainted(false); // Sin indicadores de enfoque
		btnBiblio.setOpaque(false);
		
		btnBiblio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new BiblioView().setVisible(true);
				dispose();

			}
		});
		
		
		JButton btnGym = new JButton("");
		btnGym.setBounds(595, 157, 102, 75);
		getContentPane().add(btnGym);
		btnGym.setContentAreaFilled(false); // Fondo transparente
		btnGym.setBorderPainted(false); // Sin bordes
		btnGym.setFocusPainted(false); // Sin indicadores de enfoque
		btnGym.setOpaque(false);
		
		btnGym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new GymView().setVisible(true);
				dispose();

			}
		});
		
		
		JButton btnLab = new JButton("");
		btnLab.setBounds(853, 143, 33, 153);
		getContentPane().add(btnLab);
		btnLab.setContentAreaFilled(false); // Fondo transparente
		btnLab.setBorderPainted(false); // Sin bordes
		btnLab.setFocusPainted(false); // Sin indicadores de enfoque
		btnLab.setOpaque(false);
		
		btnLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new LabView().setVisible(true);
				dispose();

			}
		});
		
		
		JLabel lblLab = new JLabel("");
		lblLab.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-der.png"));
		lblLab.setBounds(848, 157, 51, 115);
		getContentPane().add(lblLab);
		
		JLabel lblGym = new JLabel("");
		lblGym.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flechote (1) (2).png"));
		lblGym.setBounds(616, 158, 62, 74);
		getContentPane().add(lblGym);
		
		JLabel lblBiblio = new JLabel("");
		lblBiblio.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-izq.png"));
		lblBiblio.setBounds(390, 177, 44, 103);
		getContentPane().add(lblBiblio);
		
		JButton btnRecepcion = new JButton("");
		btnRecepcion.setBounds(496, 495, 89, 43);
		getContentPane().add(btnRecepcion);
		btnRecepcion.setContentAreaFilled(false); // Fondo transparente
		btnRecepcion.setBorderPainted(false); // Sin bordes
		btnRecepcion.setFocusPainted(false); // Sin indicadores de enfoque
		btnRecepcion.setOpaque(false);
		
		btnRecepcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new RecepcionView().setVisible(true);
				dispose();

			}
		});
		
		JLabel lblRecepcion = new JLabel("");
		lblRecepcion.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblRecepcion.setBounds(506, 497, 95, 52);
		getContentPane().add(lblRecepcion);
		
		JLabel lblFondoPasillo2 = new JLabel("");
		lblFondoPasillo2.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\pasillo2 (4).png"));
		lblFondoPasillo2.setBounds(0, 0, 1300, 560);
		getContentPane().add(lblFondoPasillo2);
		
		
	}

	
	
	
	
	
}
 