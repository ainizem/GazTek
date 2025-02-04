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
		setBounds(0, 0, 1366, 768);
		
		JLabel lblPasillo = new JLabel("");
		lblPasillo.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblPasillo.setBounds(575, 514, 94, 45);
		getContentPane().add(lblPasillo);
		
		JButton btnPasillo = new JButton("");
		btnPasillo.setBounds(575, 514, 100, 45);
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
		lblFondoOrdenadores.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\clase ordenadores (1).png"));
		lblFondoOrdenadores.setBounds(0, 0, 1300, 560);
		getContentPane().add(lblFondoOrdenadores);
		
		
		
		
	}
	
	
	
	

}
