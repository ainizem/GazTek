package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GymView extends JFrame {
	public GymView() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 1200, 620);		
		
		JButton btnPasillo2 = new JButton("");
		btnPasillo2.setBounds(464, 524, 74, 46);
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
		lblPasillo2.setBounds(464, 524, 74, 46);
		getContentPane().add(lblPasillo2);
		
		JLabel lblFondoGym = new JLabel("");
		lblFondoGym.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\gimnasio (1).png"));
		lblFondoGym.setBounds(0, 0, 1092, 581);
		getContentPane().add(lblFondoGym);
	}

}
