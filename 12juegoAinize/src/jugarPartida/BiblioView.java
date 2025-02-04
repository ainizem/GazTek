package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BiblioView extends JFrame{
	public BiblioView() {
		getContentPane().setLayout(null);
		setBounds(0, 0, 1366, 768);
		
		JButton btnPasillo2 = new JButton("");
		btnPasillo2.setBounds(522, 521, 129, 35);
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
		
		
		JLabel lblPasillo2 = new JLabel("");
		lblPasillo2.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblPasillo2.setBounds(543, 521, 94, 35);
		getContentPane().add(lblPasillo2);
		
		JLabel lblFondoBiblio = new JLabel("");
		lblFondoBiblio.setIcon(new ImageIcon("C:\\Users\\ainiz\\OneDrive\\Escritorio\\Ainize\\programacion\\12juegoAinize\\img\\biblioteca.png"));
		lblFondoBiblio.setBounds(0, 0, 1340, 570);
		getContentPane().add(lblFondoBiblio);
	}
	
	

}
