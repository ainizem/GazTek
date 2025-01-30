package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RecepcionView extends JFrame{
	public RecepcionView() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 1200, 620);
		
		JButton btnPasillo = new JButton("");
		btnPasillo.setBounds(541, 533, 89, 23);
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
		lblPasillo.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblPasillo.setBounds(541, 533, 102, 37);
		getContentPane().add(lblPasillo);

	
		
		JButton btnPasillo2 = new JButton("");
		btnPasillo2.setBounds(25, 273, 54, 130);
		getContentPane().add(btnPasillo2);
		btnPasillo2.setContentAreaFilled(false); // Fondo transparente
		btnPasillo2.setBorderPainted(false); // Sin bordes
		btnPasillo2.setFocusPainted(false); // Sin indicadores de enfoque
		btnPasillo2.setOpaque(false);
		
		
		btnPasillo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Pasillo2View().setVisible(true);
				dispose();

			}
		});
		
		
		
		JLabel lblPasillo2 = new JLabel("New label");
		lblPasillo2.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-izq.png"));
		lblPasillo2.setBounds(25, 288, 65, 136);
		getContentPane().add(lblPasillo2);
			
		
		
		JButton btnPatio2 = new JButton("");
		btnPatio2.setBounds(930, 305, 75, 149);
		getContentPane().add(btnPatio2);
		btnPatio2.setContentAreaFilled(false); // Fondo transparente
		btnPatio2.setBorderPainted(false); // Sin bordes
		btnPatio2.setFocusPainted(false); // Sin indicadores de enfoque
		btnPatio2.setOpaque(false);
		
		btnPatio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Patio2View().setVisible(true);
				dispose();

			}
		});
		
		
		JLabel lblPatio2 = new JLabel("");
		lblPatio2.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-der.png"));
		lblPatio2.setBounds(951, 305, 54, 119);
		getContentPane().add(lblPatio2);
		
		
		JLabel lblFondoRecepcion = new JLabel("");
		lblFondoRecepcion.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\recepcion (1).png"));
		lblFondoRecepcion.setBounds(0, 0, 1174, 581);
		getContentPane().add(lblFondoRecepcion);
		
	}
	
	

}
