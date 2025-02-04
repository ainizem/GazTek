package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PasilloView extends JFrame{
	public PasilloView() {
		getContentPane().setLayout(null);
		setBounds(0, 0, 1366, 768);
		JButton btnAula = new JButton("");
		btnAula.setBounds(420, 204, 26, 274);
		getContentPane().add(btnAula);
		btnAula.setContentAreaFilled(false); // Fondo transparente
		btnAula.setBorderPainted(false); // Sin bordes
		btnAula.setFocusPainted(false); // Sin indicadores de enfoque
		btnAula.setOpaque(false);
		btnAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new InventarioView().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();

			}
		});
		
		JButton btnOrdenadores = new JButton("");
		btnOrdenadores.setBounds(783, 205, 46, 220);
		getContentPane().add(btnOrdenadores);
		
		JLabel lblOrdenadores = new JLabel("");
		lblOrdenadores.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-der.png"));
		lblOrdenadores.setBounds(783, 232, 46, 193);
		getContentPane().add(lblOrdenadores);
		
		btnOrdenadores.setContentAreaFilled(false); // Fondo transparente
		btnOrdenadores.setBorderPainted(false); // Sin bordes
		btnOrdenadores.setFocusPainted(false); // Sin indicadores de enfoque
		btnOrdenadores.setOpaque(false);
		
		btnOrdenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new OrdenadoresView().setVisible(true);
				dispose();

			}
		});
		
		
			
		JLabel lblAula = new JLabel("");
		lblAula.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-izq.png"));
		lblAula.setBounds(395, 268, 51, 81);
		getContentPane().add(lblAula);
		
		
		JButton btnPatio = new JButton("");
		btnPatio.setBounds(595, 243, 89, 117);
		getContentPane().add(btnPatio);
		
		btnPatio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PatioView().setVisible(true);
				dispose();

			}
		});
		
		btnPatio.setContentAreaFilled(false); // Fondo transparente
		btnPatio.setBorderPainted(false); // Sin bordes
		btnPatio.setFocusPainted(false); // Sin indicadores de enfoque
		btnPatio.setOpaque(false);
		
		JLabel lblpatio = new JLabel("");
		lblpatio.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flechote (1).png"));
		lblpatio.setBounds(606, 272, 78, 38);
		getContentPane().add(lblpatio);
		
		
		JLabel lblRecepcion = new JLabel("");
		lblRecepcion.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblRecepcion.setBounds(591, 504, 114, 44);
		getContentPane().add(lblRecepcion);
		
		JButton btnRecepcion = new JButton("");
		btnRecepcion.setBounds(591, 504, 125, 44);
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
	
		JLabel lblFondoPasillo = new JLabel("");
		lblFondoPasillo.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\pasillo (1).png"));
		lblFondoPasillo.setBounds(0, 0, 1300, 560);
		getContentPane().add(lblFondoPasillo);
		
		
	}
}
