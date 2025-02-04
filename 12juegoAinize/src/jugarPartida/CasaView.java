package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CasaView extends JFrame {

	private JLabel lblDesenlace;
	public StringBuilder contrasena = new StringBuilder(); // Almacena la contraseña introducida
	public final String CONTRASENA_CORRECTA = "250909";

	public CasaView() {
		getContentPane().setLayout(null);
		setBounds(0, 0, 1366, 768);

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
		lblPatio2.setIcon(new ImageIcon(
				"C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-izq.png"));
		lblPatio2.setBounds(10, 260, 67, 64);
		getContentPane().add(lblPatio2);

		lblDesenlace = new JLabel("");
		lblDesenlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesenlace.setForeground(Color.WHITE);
		lblDesenlace.setBounds(295, 68, 197, 23);
		getContentPane().add(lblDesenlace);
		lblDesenlace.setVisible(false);

		JLabel lblMovil = new JLabel("");
		lblMovil.setIcon(new ImageIcon(
				"C:\\Users\\ainiz\\OneDrive\\Escritorio\\Ainize\\programacion\\12juegoAinize\\img\\tlfVacioo.png"));
		lblMovil.setBounds(103, 27, 481, 533);
		getContentPane().add(lblMovil);
		lblMovil.setVisible(false);

		JButton btnCajon = new JButton("");
		btnCajon.setBounds(187, 391, 54, 23);
		getContentPane().add(btnCajon);
		btnCajon.setVisible(false);
		btnCajon.setContentAreaFilled(false); // Fondo transparente
		btnCajon.setBorderPainted(false); // Sin bordes
		btnCajon.setFocusPainted(false); // Sin indicadores de enfoque
		btnCajon.setOpaque(false);

		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBounds(308, 173, 45, 44);
		getContentPane().add(btn1);
		btn1.setVisible(false);

		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setBounds(384, 173, 45, 44);
		getContentPane().add(btn2);
		btn2.setVisible(false);

		/*
		 * btn2.setContentAreaFilled(false); // Fondo transparente
		 * btn2.setBorderPainted(false); // Sin bordes btn2.setFocusPainted(false); //
		 * Sin indicadores de enfoque btn2.setOpaque(false);
		 */
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn3.setBounds(458, 173, 45, 44);
		getContentPane().add(btn3);
		btn3.setVisible(false);

		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn4.setBounds(308, 240, 45, 44);
		getContentPane().add(btn4);
		btn4.setVisible(false);

		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn5.setBounds(384, 240, 45, 44);
		getContentPane().add(btn5);
		btn5.setVisible(false);

		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn6.setBounds(458, 240, 45, 44);
		getContentPane().add(btn6);
		btn6.setVisible(false);

		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn7.setBounds(308, 302, 45, 44);
		getContentPane().add(btn7);
		btn7.setVisible(false);

		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn8.setBounds(384, 305, 45, 44);
		getContentPane().add(btn8);
		btn8.setVisible(false);

		JButton btn9 = new JButton("9");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn9.setBounds(458, 302, 45, 44);
		getContentPane().add(btn9);
		btn9.setVisible(false);

		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn0.setBounds(384, 370, 45, 44);
		getContentPane().add(btn0);
		btn0.setVisible(false);

		btnCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblMovil.setVisible(true);
				btn1.setVisible(true);
				btn2.setVisible(true);
				btn3.setVisible(true);
				btn4.setVisible(true);
				btn5.setVisible(true);
				btn6.setVisible(true);
				btn7.setVisible(true);
				btn8.setVisible(true);
				btn9.setVisible(true);
				btn0.setVisible(true);
			}
		});

		JLabel lblTarjetaGym = new JLabel("");
		lblTarjetaGym.setIcon(new ImageIcon(
				"C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\tarjetaGym (1) (1).png"));
		lblTarjetaGym.setBounds(889, 0, 473, 288);
		getContentPane().add(lblTarjetaGym);
		lblTarjetaGym.setVisible(false);

		JButton btnMochila = new JButton("");
		btnMochila.setBounds(698, 437, 67, 64);
		getContentPane().add(btnMochila);
		btnMochila.setContentAreaFilled(false); // Fondo transparente
		btnMochila.setBorderPainted(false); // Sin bordes
		btnMochila.setFocusPainted(false); // Sin indicadores de enfoque
		btnMochila.setOpaque(false);

		btnMochila.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				lblTarjetaGym.setVisible(true);
				btnCajon.setVisible(true);

			}
		});

		setupPasswordButton(btn0, "0");
		setupPasswordButton(btn1, "1");
		setupPasswordButton(btn2, "2");
		setupPasswordButton(btn3, "3");
		setupPasswordButton(btn4, "4");
		setupPasswordButton(btn5, "5");
		setupPasswordButton(btn6, "6");
		setupPasswordButton(btn7, "7");
		setupPasswordButton(btn8, "8");
		setupPasswordButton(btn9, "9");

		JLabel lblFondoCasa = new JLabel("");
		lblFondoCasa.setIcon(new ImageIcon(
				"C:\\Users\\ainiz\\OneDrive\\Escritorio\\Ainize\\programacion\\12juegoAinize\\img\\Dise\u00F1o sin t\u00EDtulo (1).png"));
		lblFondoCasa.setBounds(0, 0, 1300, 560);
		getContentPane().add(lblFondoCasa);

	}

	private void setupPasswordButton(JButton button, String value) {
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setOpaque(false);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contrasena.append(value);
				checkPassword();
			}
		});
	}

	private void checkPassword() {
		if (contrasena.length() == 6) {
			lblDesenlace.setVisible(true); // Mostrar el desenlace
			if (contrasena.toString().equals(CONTRASENA_CORRECTA)) {
				lblDesenlace.setText("¡Contraseña correcta!");
			} else {
				lblDesenlace.setText("Contraseña incorrecta");
				contrasena.setLength(0);
				lblDesenlace.setText("Vuelve a intentarlo");// Restablece la entrada
			}
		}
	}
}
