package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LabView extends JFrame{
	public LabView() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 1200, 620);				
	
		JButton btnPasillo2 = new JButton("");
		btnPasillo2.setBounds(436, 523, 89, 23);
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
		lblPasillo2.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblPasillo2.setBounds(434, 523, 91, 35);
		getContentPane().add(lblPasillo2);	
		
		JLabel lblFondoLab = new JLabel("");
		lblFondoLab.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\laboratorio (1) (5).png"));
		lblFondoLab.setBounds(0, 0, 1205, 570);
		getContentPane().add(lblFondoLab);
		
	}
	
	

}
