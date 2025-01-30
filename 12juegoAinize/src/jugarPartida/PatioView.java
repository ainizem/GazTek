package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PatioView extends JFrame {
	public PatioView() {
		getContentPane().setLayout(null);
		//getContentPane().setLayout(null);
		setBounds(100, 100, 775, 620);
		
		JLabel lblPatio2 = new JLabel("");
		lblPatio2.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-der.png"));
		lblPatio2.setBounds(697, 157, 52, 92);
		getContentPane().add(lblPatio2);
		
		JButton btnPatio2 = new JButton("");
		btnPatio2.setBounds(697, 157, 52, 92);
		getContentPane().add(btnPatio2);
		
		btnPatio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Patio2View().setVisible(true);
				dispose();

			}
		});
		
		btnPatio2.setContentAreaFilled(false); // Fondo transparente
		btnPatio2.setBorderPainted(false); // Sin bordes
		btnPatio2.setFocusPainted(false); // Sin indicadores de enfoque
		btnPatio2.setOpaque(false);
		
		
		JButton btnPasillo = new JButton("");
		btnPasillo.setBounds(257, 298, 47, 32);
		getContentPane().add(btnPasillo);
		btnPasillo.setContentAreaFilled(false); // Fondo transparente
		btnPasillo.setBorderPainted(false); // Sin bordes
		btnPasillo.setFocusPainted(false); // Sin indicadores de enfoque
		btnPasillo.setOpaque(false);
		
		btnPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PasilloView().setVisible(true);
				dispose();

			}
		});
		
		
		
		
		JLabel lblPasillo = new JLabel("");
		lblPasillo.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flechote (1) (2).png"));
		lblPasillo.setBounds(258, 306, 46, 24);
		getContentPane().add(lblPasillo);
		
		JButton btnrecepcion = new JButton("");
		btnrecepcion.setBounds(394, 298, 38, 32);
		getContentPane().add(btnrecepcion);
		btnrecepcion.setContentAreaFilled(false); // Fondo transparente
		btnrecepcion.setBorderPainted(false); // Sin bordes
		btnrecepcion.setFocusPainted(false); // Sin indicadores de enfoque
		btnrecepcion.setOpaque(false);
		
		btnrecepcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new RecepcionView().setVisible(true);
				dispose();

			}
		});
		
		JLabel lblRecepcion = new JLabel("");
		lblRecepcion.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flechote (1) (2).png"));
		lblRecepcion.setBounds(394, 306, 46, 24);
		getContentPane().add(lblRecepcion);
		
	
		
		JLabel lblFondoPatio = new JLabel("");
		lblFondoPatio.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\patio (1) (2) (1).png"));
		lblFondoPatio.setBounds(0, -17, 749, 587);
		getContentPane().add(lblFondoPatio);
	}
	
	

}
