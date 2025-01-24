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
		setBounds(100, 100, 1200, 620);		
		
		JButton btnBiblio = new JButton("");
		btnBiblio.setBounds(340, 127, 33, 172);
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
		btnGym.setBounds(499, 127, 102, 91);
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
		btnLab.setBounds(723, 111, 33, 188);
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
		lblLab.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-der.png"));
		lblLab.setBounds(707, 127, 49, 153);
		getContentPane().add(lblLab);
		
		JLabel lblGym = new JLabel("");
		lblGym.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flechote (1) (2).png"));
		lblGym.setBounds(523, 144, 62, 74);
		getContentPane().add(lblGym);
		
		JLabel lblBiblio = new JLabel("");
		lblBiblio.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-izq.png"));
		lblBiblio.setBounds(317, 144, 56, 136);
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
		lblRecepcion.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblRecepcion.setBounds(506, 497, 95, 52);
		getContentPane().add(lblRecepcion);
		
		JLabel lblFondoPasillo2 = new JLabel("");
		lblFondoPasillo2.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\pasillo2 (4).png"));
		lblFondoPasillo2.setBounds(0, 0, 1100, 581);
		getContentPane().add(lblFondoPasillo2);
		
		
	}

	
	
	
	
	
}
