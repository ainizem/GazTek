package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Patio2View extends JFrame{
	public Patio2View() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 775, 620);
		
		JLabel lblRecepcion = new JLabel("");
		lblRecepcion.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblRecepcion.setBounds(273, 384, 74, 56);
		getContentPane().add(lblRecepcion);
		
		JButton btnRecepcion = new JButton("");
		btnRecepcion.setBounds(273, 384, 74, 56);
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
		
		JLabel lblPatio1 = new JLabel("");
		lblPatio1.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-izq.png"));
		lblPatio1.setBounds(10, 232, 57, 56);
		getContentPane().add(lblPatio1);
		
		JButton btnPatio1 = new JButton("");
		btnPatio1.setBounds(10, 232, 57, 56);
		getContentPane().add(btnPatio1);
		btnPatio1.setContentAreaFilled(false); // Fondo transparente
		btnPatio1.setBorderPainted(false); // Sin bordes
		btnPatio1.setFocusPainted(false); // Sin indicadores de enfoque
		btnPatio1.setOpaque(false);
		
		btnPatio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PatioView().setVisible(true);
				dispose();

			}
		});

		JButton btnCasa = new JButton("");
		btnCasa.setBounds(585, 232, 89, 56);
		getContentPane().add(btnCasa);
		btnCasa.setContentAreaFilled(false); // Fondo transparente
		btnCasa.setBorderPainted(false); // Sin bordes
		btnCasa.setFocusPainted(false); // Sin indicadores de enfoque
		btnCasa.setOpaque(false);
		
		btnCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CasaView().setVisible(true);
				dispose();

			}
		});
		
		
		JLabel lblCasa = new JLabel("");
		lblCasa.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-der.png"));
		lblCasa.setBounds(617, 232, 57, 56);
		getContentPane().add(lblCasa);
		
		
		JLabel lblFondoPatio2 = new JLabel("");
		lblFondoPatio2.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\patio2 (1) (4).png"));
		lblFondoPatio2.setBounds(0, 0, 749, 570);
		getContentPane().add(lblFondoPatio2);
		
		
		
	}
}
