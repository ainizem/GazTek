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
	private final Action action = new SwingAction();

	// private ArrayList<ObjetoDTO> objetos;

	public InventarioView() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(601, 0, 83, 421);
		contentPane.add(scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		String[] columnas = { "Inventario", "Imagen"};
		ArrayList<ObjetoDTO> objetos = getObjetos();

		Object[][] datos = new Object[objetos.size()][columnas.length][];

		for (int i = 0; i < objetos.size(); i++) {
			ObjetoDTO p = objetos.get(i);

			datos[i][0] = p.getNombre();
		
		}

		DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);

		tablaInventario = new JTable(modeloTabla);
		tablaInventario.setBorder(null);
		scrollPane.setViewportView(tablaInventario);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 684, 421);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 600, 458);
		panel.add(lblFondo);
		lblFondo.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juego\\img\\clase.png"));
		
		JButton btnpasillo = new JButton("");
		

		btnpasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  new PasilloView().setVisible(true); 
				dispose();
				
			}
		});
		btnpasillo.setAction(action);
		btnpasillo.setBounds(228, 11, 136, 92);
		panel.add(btnpasillo);
		btnpasillo.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juego\\img\\flechote (1).png"));
		
		
		tablaInventario.setOpaque(false);
		tablaInventario.setBackground(new Color(0, 0, 0, 0));
		
		lblNewLabel_1 = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel_1);
	


	}

	private ArrayList<ObjetoDTO> getObjetos() throws SQLException {
		ArrayList<ObjetoDTO> resultado = new ArrayList<ObjetoDTO>();
		ObjetoBD objetoBD = new ObjetoBD(AccesoBD.DRIVER_MYSQL, "inventariobd", "root", "");
		resultado = objetoBD.getObjetos();

		return resultado;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
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
