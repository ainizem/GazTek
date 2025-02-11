package jugarPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crucigrama extends JFrame {
	private static final int SIZE = 9; // Tamaño del crucigrama
	private JTextField[][] grid; // Matriz de JTextFields
	private final String[][] SOLUTION = { 
			{ "", "", "", "", "", "I", "", "", ""  }, 
			{ "", "", "T", "", "", "N", "", "C", ""  },
			{ "", "", "O", "", "", "U", "", "O", ""  }, 
			{ "", "", "N", "", "", "T", "", "B", ""  }, 
			{ "E", "S", "T", "U", "P", "I", "D", "A", "" },
			{ "", "", "A", "", "", "L", "", "R", ""  },
			{ "", "", "", "", "", "", "", "D", ""  },
			{ "", "", "", "", "", "", "F", "E", "A"  },
			{ "", "", "", "", "", "", "", "", ""  } };

	public Crucigrama() {
		// Configuración del JFrame
		setTitle("Crucigrama: Tema Bullying");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);

		// Panel para el crucigrama
		JPanel crucigramaPanel = new JPanel(new GridLayout(SIZE, SIZE));
		grid = new JTextField[SIZE][SIZE];
		inicializarCrucigrama(crucigramaPanel);

		// Botón para verificar el crucigrama
		JButton verificarButton = new JButton("Verificar");
		
		verificarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verificarCrucigrama();
			}
		});
		

		// Agregar el panel y el botón al JFrame
		add(crucigramaPanel, BorderLayout.CENTER);
		add(verificarButton,BorderLayout.SOUTH);
		


		// Hacer visible la ventana
		setVisible(true);
	}

	private void inicializarCrucigrama(JPanel crucigramaPanel) {
		// Matriz que define qué celdas están activas (true) o inactivas (false)
		boolean[][] activeCells = {
				{ false, false, false, false, false, true, false, false,false  }, 
				{ false, false, true, false, false, true, false, true, false  },
				{ false, false, true, false, false, true, false, true, false  }, 
				{ false, false, true, false, false, true, false, true, false  }, 
				{ true, true, true, true, true, true, true, true, false  },
				{ false, false, true, false, false, true, false, true, false  },
				{ false, false, false, false, false, false, false, true, false  },
				{ false, false, false, false, false, false, true, true, true  },
				{ false, false, false, false, false, false, false, false, false  } };

		// Crear las celdas del crucigrama
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				JTextField cell = new JTextField();
				cell.setHorizontalAlignment(JTextField.CENTER);

				if (activeCells[i][j]) {
					// Celdas activas
					cell.setBackground(Color.WHITE);
					cell.setEditable(true);
				} else {
					// Celdas inactivas
					cell.setBackground(Color.BLACK);
					cell.setEditable(false);
				}

				// Agregar la celda al panel y a la matriz
				grid[i][j] = cell;
				crucigramaPanel.add(cell);
			}
		}
	}

	private void verificarCrucigrama() {
		boolean correcto = true;

		// Comparar cada celda con la solución
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (grid[i][j].isEditable()) {
					String valor = grid[i][j].getText().toUpperCase(); // Convertir a mayúscula
					if (!valor.equals(SOLUTION[i][j])) {
						correcto = false; // Si hay un error, no está correcto
						break;
					}
				}
			}
		}

		// Mostrar mensaje según el resultado
		if (correcto) {
			JOptionPane.showMessageDialog(this, "¡Has acertado! El crucigrama está correcto.");
		} else {
			JOptionPane.showMessageDialog(this, "Hay errores en el crucigrama. ¡Intenta de nuevo!");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Crucigrama::new);
	}
}
