package jugarPartida;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.AccesoBD;
import model.ObjetoBD;
import model.ObjetoDTO;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class InventarioView extends JFrame {

	private JPanel contentPane;
	private JTable tablaInventario;
	private JLabel lblNewLabel_1;
	private JPanel panel;

	// private ArrayList<ObjetoDTO> objetos;

	public InventarioView() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		/*String[] columnas = { "Inventario" };
		ArrayList<ObjetoDTO> objetos = getObjetos();

		Object[][] datos = new Object[objetos.size()][columnas.length];

		for (int i = 0; i < objetos.size(); i++) {
			ObjetoDTO p = objetos.get(i);

			datos[i][0] = p.getNombre();

		}

		DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);

		tablaInventario = new JTable(modeloTabla);
		tablaInventario.setBorder(null);
		scrollPane.setViewportView(tablaInventario);
*/
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1340, 570);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnpasillo = new JButton("");
		btnpasillo.setIcon(null);

		btnpasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PasilloView().setVisible(true);
				dispose();

			}
		});
		btnpasillo.setBounds(503, 493, 72, 53);
		panel.add(btnpasillo);
		btnpasillo.setContentAreaFilled(false); // Fondo transparente
		btnpasillo.setBorderPainted(false); // Sin bordes
		btnpasillo.setFocusPainted(false); // Sin indicadores de enfoque
		btnpasillo.setOpaque(false);

		JLabel lblPasillo = new JLabel("");
		lblPasillo.setIcon(new ImageIcon("C:\\\\Users\\\\ainiz\\\\OneDrive\\\\Escritorio\\\\Ainize\\\\programacion\\12juegoAinize\\img\\flecha-abajo.png"));
		lblPasillo.setBounds(503, 493, 72, 53);
		panel.add(lblPasillo);
		
		JLabel lblFondoAula = new JLabel("");
		lblFondoAula.setIcon(new ImageIcon("C:\\Users\\ainiz\\OneDrive\\Escritorio\\Ainize\\programacion\\12juegoAinize\\img\\clase (2).png"));
		lblFondoAula.setBounds(10, 11, 1300, 560);
		panel.add(lblFondoAula);

//		tablaInventario.setOpaque(false);
	//	tablaInventario.setBackground(new Color(0, 0, 0, 0));

	}

	private ArrayList<ObjetoDTO> getObjetos() throws SQLException {
		ArrayList<ObjetoDTO> resultado = new ArrayList<ObjetoDTO>();
		ObjetoBD objetoBD = new ObjetoBD(AccesoBD.DRIVER_MYSQL, "inventariobd", "root", "");
		resultado = objetoBD.getObjetos();

		return resultado;
	}

	public void actionPerformed(ActionEvent e) {
	}
}

/*
 * // para añadir al arraylist public void agregarObjeto(ObjetoDTO objeto) {
 * objetos.add(objeto); System.out.println(objeto.getNombre() +
 * " ha sido agregado al inventario."); }
 * 
 * // para mostarr lo que hay en el arraylist public void mostrarInventario() {
 * if (objetos.isEmpty()) { System.out.println("Inventario vacío"); } else {
 * System.out.println("Inventario:");
 * 
 * for (ObjetoDTO objeto : objetos) {// recorremos el array de objetos para que
 * muestre todos los ke haya System.out.println(objeto.getNombre() + ":" +
 * objeto.getDescripcion());
 * 
 * } }
 * 
 * }
 * 
 * }
 */
