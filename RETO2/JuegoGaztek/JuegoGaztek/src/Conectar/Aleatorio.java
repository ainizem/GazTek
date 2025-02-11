package Conectar;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Aleatorio extends JFrame {

    private JTextField textField;
    private JLabel lblNumero;
    private JLabel lblSeleccion;
    private Random random = new Random();
    private long numeroAleatorio;

    // Declaraci�n de botones
    private JButton btnGenerarDificil;
    private JButton btnGenerarFacil;
    private JButton btnCopiar;
    private JButton btnSiguiente;
    private JButton btnVolverFacil;
    private JButton btnVolverDificil;

    public Aleatorio() throws ClassNotFoundException, SQLException {
        // Configuraci�n b�sica de la ventana
        setTitle("Generar c�digo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Para pantalla completa
        setLayout(new GridBagLayout());  // Usamos GridBagLayout para que los componentes se ajusten
        GridBagConstraints gbc = new GridBagConstraints();
        setResizable(true);

        // Inicializaci�n de componentes
        textField = new JTextField(10);
        lblNumero = new JLabel("N�mero Aleatorio", JLabel.CENTER);
        lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 24));

        lblSeleccion = new JLabel("");
        lblSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // Inicializaci�n de los botones
        btnGenerarDificil = new JButton("Generar Dificil");
        btnGenerarFacil = new JButton("Generar Facil");
        btnCopiar = new JButton("Copiar");
        btnSiguiente = new JButton("Siguiente");
        btnVolverFacil = new JButton("Volver");
        btnVolverDificil = new JButton("Volver");

        // Colocamos el texto del n�mero aleatorio y los botones en el layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblNumero, gbc);

        gbc.gridy = 1;
        add(lblSeleccion, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        add(btnGenerarDificil, gbc);

        gbc.gridx = 1;
        add(btnGenerarFacil, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnSiguiente, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnVolverFacil, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(btnVolverDificil, gbc);

        // Establecer visibilidad por defecto
        btnGenerarDificil.setVisible(true);
        btnGenerarFacil.setVisible(true);        
        btnSiguiente.setVisible(false);
        btnVolverFacil.setVisible(false);
        btnVolverDificil.setVisible(false);

        // Listeners para los botones
        btnGenerarDificil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Numeros();
                lblNumero.setText(String.valueOf(numeroAleatorio));
                lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 60));
                lblSeleccion.setText("C�digo para el modo: Dif�cil");
                
                StringSelection stringSelection = new StringSelection(String.valueOf(numeroAleatorio));
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "Tienes el numero en el ctrl+v");

                btnGenerarDificil.setVisible(false);
                btnGenerarFacil.setVisible(false);
                btnSiguiente.setVisible(true);
                btnVolverDificil.setVisible(true);
            }
        });

        btnGenerarFacil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Numeros();
                lblNumero.setText(String.valueOf(numeroAleatorio));
                lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 60));
                lblSeleccion.setText("C�digo para el modo: F�cil");
                
                StringSelection stringSelection = new StringSelection(String.valueOf(numeroAleatorio));
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "Tienes el numero en el ctrl+v");
                
                btnGenerarDificil.setVisible(false);
                btnGenerarFacil.setVisible(false);
                btnVolverFacil.setVisible(true);
                btnSiguiente.setVisible(true);
            }
        });

        btnCopiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(String.valueOf(numeroAleatorio));
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                
                
            }
        });

        btnVolverDificil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetUI();
            }
        });

        btnVolverFacil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetUI();
            }
        });

        // Hacemos visible la ventana
        pack();
        setVisible(true);
    }

    // M�todo para generar n�meros aleatorios
    public long Numeros() {
        long numeroMaximo = 900000L;
        long numeroBase = 100000L;
        numeroAleatorio = numeroBase + Math.abs(random.nextLong() % numeroMaximo);
        return numeroAleatorio;
    }

    // M�todo para restablecer la interfaz despu�s de una acci�n
    private void resetUI() {
        lblNumero.setText("N�mero Aleatorio");
        lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSeleccion.setText("");

        // Hacer visibles los botones de selecci�n
        btnGenerarDificil.setVisible(true);
        btnGenerarFacil.setVisible(true);
        btnCopiar.setVisible(false);
        btnSiguiente.setVisible(false);
        btnVolverFacil.setVisible(false);
        btnVolverDificil.setVisible(false);
    }

    public static void main(String[] args) {
        try {
            new Aleatorio();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
