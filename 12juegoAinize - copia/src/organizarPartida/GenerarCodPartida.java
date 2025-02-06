package organizarPartida;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GenerarCodPartida extends JFrame {

	Random random = new Random();

	public long numeroAleatorio;
	private JTextField textField;

	public long Numeros() {
		
	    long numeroMaximo = 90000L;
	    long numeroBase = 1000L;
	    
	    numeroAleatorio = numeroBase + Math.abs(random.nextLong() % numeroMaximo);

	    return numeroAleatorio;

	}

	public GenerarCodPartida() {

		setTitle("Juego de ejemplo");
		setSize(800, 600);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField();
		getContentPane().add(textField, BorderLayout.WEST);
		textField.setColumns(10);

		JLabel lblNumero = new JLabel("Numero Aleatorio");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNumero.setBounds(273, 87, 236, 39);
		getContentPane().add(lblNumero);

		JButton btnGenerarNumero = new JButton("Generar numero");
		btnGenerarNumero.setBounds(315, 137, 144, 23);
		getContentPane().add(btnGenerarNumero);

		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.setBounds(315, 192, 144, 23);
		getContentPane().add(btnCopiar);
		setVisible(true);

		btnGenerarNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Numeros();

				lblNumero.setText(String.valueOf(numeroAleatorio));
				lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}

		});

		btnCopiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(String.valueOf(numeroAleatorio));
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			}
		});

	}
}











