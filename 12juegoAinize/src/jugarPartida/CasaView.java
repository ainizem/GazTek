package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CasaView extends JFrame {
	public CasaView() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 1200, 620);

		JButton btnPatio2 = new JButton("");
		btnPatio2.setBounds(10, 260, 67, 64);
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
		lblPatio2.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-izq.png"));
		lblPatio2.setBounds(10, 260, 67, 64);
		getContentPane().add(lblPatio2);

		JLabel lblMovil = new JLabel("");
		lblMovil.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\movilF-transformed (2).png"));
		lblMovil.setBounds(251, 11, 284, 533);
		getContentPane().add(lblMovil);
		lblMovil.setVisible(false);

		JButton btnCajon = new JButton("");
		btnCajon.setBounds(113, 395, 54, 23);
		getContentPane().add(btnCajon);

		btnCajon.setContentAreaFilled(false); // Fondo transparente
		btnCajon.setBorderPainted(false); // Sin bordes
		btnCajon.setFocusPainted(false); // Sin indicadores de enfoque
		btnCajon.setOpaque(false);

		btnCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			 lblMovil.setVisible(true);			

			}
		});

		JButton btn1 = new JButton("");
		btn1.setBounds(308, 173, 45, 44);
		getContentPane().add(btn1);
		btn1.setContentAreaFilled(false); // Fondo transparente
		btn1.setBorderPainted(false); // Sin bordes
		btn1.setFocusPainted(false); // Sin indicadores de enfoque
		btn1.setOpaque(false);

		JButton btn2 = new JButton("");
		btn2.setBounds(384, 173, 45, 44);
		getContentPane().add(btn2);
		btn2.setContentAreaFilled(false); // Fondo transparente
		btn2.setBorderPainted(false); // Sin bordes
		btn2.setFocusPainted(false); // Sin indicadores de enfoque
		btn2.setOpaque(false);
		
		JButton btn3 = new JButton("");
		btn3.setBounds(458, 173, 45, 44);
		getContentPane().add(btn3);
		btn3.setContentAreaFilled(false); // Fondo transparente
		btn3.setBorderPainted(false); // Sin bordes
		btn3.setFocusPainted(false); // Sin indicadores de enfoque
		btn3.setOpaque(false);

		JButton btn4 = new JButton("");
		btn4.setBounds(308, 240, 45, 44);
		getContentPane().add(btn4);
		btn4.setContentAreaFilled(false); // Fondo transparente
		btn4.setBorderPainted(false); // Sin bordes
		btn4.setFocusPainted(false); // Sin indicadores de enfoque
		btn4.setOpaque(false);

		JButton btn5 = new JButton("");
		btn5.setBounds(384, 240, 45, 44);
		getContentPane().add(btn5);
		btn5.setContentAreaFilled(false); // Fondo transparente
		btn5.setBorderPainted(false); // Sin bordes
		btn5.setFocusPainted(false); // Sin indicadores de enfoque
		btn5.setOpaque(false);

		JButton btn6 = new JButton("");
		btn6.setBounds(458, 240, 45, 44);
		getContentPane().add(btn6);
		btn6.setContentAreaFilled(false); // Fondo transparente
		btn6.setBorderPainted(false); // Sin bordes
		btn6.setFocusPainted(false); // Sin indicadores de enfoque
		btn6.setOpaque(false);

		JButton btn7 = new JButton("");
		btn7.setBounds(308, 302, 45, 44);
		getContentPane().add(btn7);
		btn7.setContentAreaFilled(false); // Fondo transparente
		btn7.setBorderPainted(false); // Sin bordes
		btn7.setFocusPainted(false); // Sin indicadores de enfoque
		btn7.setOpaque(false);

		JButton btn8 = new JButton("");
		btn8.setBounds(384, 305, 45, 44);
		getContentPane().add(btn8);
		btn8.setContentAreaFilled(false); // Fondo transparente
		btn8.setBorderPainted(false); // Sin bordes
		btn8.setFocusPainted(false); // Sin indicadores de enfoque
		btn8.setOpaque(false);

		JButton btn9 = new JButton("");
		btn9.setBounds(458, 302, 45, 44);
		getContentPane().add(btn9);
		btn9.setContentAreaFilled(false); // Fondo transparente
		btn9.setBorderPainted(false); // Sin bordes
		btn9.setFocusPainted(false); // Sin indicadores de enfoque
		btn9.setOpaque(false);

		JButton btn0 = new JButton("");
		btn0.setBounds(384, 370, 45, 44);
		getContentPane().add(btn0);
		btn0.setContentAreaFilled(false); // Fondo transparente
		btn0.setBorderPainted(false); // Sin bordes
		btn0.setFocusPainted(false); // Sin indicadores de enfoque
		btn0.setOpaque(false);
	
		JButton btnMochila = new JButton("");
		btnMochila.setBounds(425, 429, 67, 64);
		getContentPane().add(btnMochila);
		btnMochila.setContentAreaFilled(false); // Fondo transparente
		btnMochila.setBorderPainted(false); // Sin bordes
		btnMochila.setFocusPainted(false); // Sin indicadores de enfoque
		btnMochila.setOpaque(false);
		
		JLabel lblFondoCasa = new JLabel("");
		lblFondoCasa.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\habitacion.png"));
		lblFondoCasa.setBounds(0, 0, 892, 557);
		getContentPane().add(lblFondoCasa);
		
	

	}
}
