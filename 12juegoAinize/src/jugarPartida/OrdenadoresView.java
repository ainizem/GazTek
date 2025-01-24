package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class OrdenadoresView extends JFrame{
	public OrdenadoresView() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 1200, 620);
		
		JLabel lblPasillo = new JLabel("");
		lblPasillo.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblPasillo.setBounds(575, 514, 209, 45);
		getContentPane().add(lblPasillo);
		
		JButton btnPasillo = new JButton("");
		btnPasillo.setBounds(575, 514, 209, 45);
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
		
		
		JLabel lblFondoOrdenadores = new JLabel("");
		lblFondoOrdenadores.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\clase ordenadores (1).png"));
		lblFondoOrdenadores.setBounds(-36, 0, 1024, 570);
		getContentPane().add(lblFondoOrdenadores);
		
		
		
		
	}
	
	
	
	

}
