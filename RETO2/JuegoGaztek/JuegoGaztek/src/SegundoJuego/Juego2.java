package SegundoJuego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import SegundoJuego.Juego2;
import Ventanas.EstadoJuego;
import Ventanas.Pruebas2;

public class Juego2 {
	private EstadoJuego estadoJuego;
	private JFrame frame;
    private List<JPanel> tutorialPanels;
    private int tutorialIndex = 0;
    private JLabel lblPuntos;
    private JLabel lblTemporizador;
    private Timer temporizador;
    private JButton btnSalir;
    private JLabel lblSalir;

    /**
     * @wbp.parser.entryPoint
     */
    public Juego2(EstadoJuego estadoJuego) {
    	this.estadoJuego = estadoJuego;
        frame = new JFrame("Juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        mostrarTutorial();
    }
    
    private void mostrarTutorial() {
        tutorialPanels = new ArrayList<>();
        
        String[] mensajes = {
            "Capitulo 2.",
            ""
        };
        
        for (String mensaje : mensajes) {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBackground(new Color(255, 255, 255, 200));
            
            JLabel label = new JLabel(mensaje, SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(label, BorderLayout.CENTER);
            
            panel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    avanzarTutorial();
                }
            });
            
            tutorialPanels.add(panel);
        }
        
        frame.setContentPane(tutorialPanels.get(0));
        frame.setVisible(true);
    }

    private void avanzarTutorial() {
        tutorialIndex++;
        if (tutorialIndex < tutorialPanels.size()) {
            frame.setContentPane(tutorialPanels.get(tutorialIndex));
            frame.revalidate();
            frame.repaint();
        } else {
            inicializarVentana();
            iniciarTemporizador();
        }
    }

    private void inicializarVentana() {
        JFrame frame = new JFrame("Juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);

        // Crear un JLayeredPane para manejar las capas
        JLayeredPane layeredPane = new JLayeredPane();
        frame.setContentPane(layeredPane);
        layeredPane.setLayout(null);

        // Imagen de fondo
        ImageIcon imageIcon = new ImageIcon("E:\\Clase\\RETO2\\Juego2\\biblio juego.png"); 
        
        Image imagenEscalada = imageIcon.getImage().getScaledInstance(1200, 748, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(imagenEscalada));
        backgroundLabel.setBounds(0, 0, 1233, 716);

        // Panel superior con puntos y temporizador
        JPanel panelSuperior = crearPanelSuperior();
        panelSuperior.setBounds(0, 0, 1200, 34);
        panelSuperior.setBackground(Color.DARK_GRAY);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(576, 503, 77, 39);
        layeredPane.add(btnNewButton);
        btnNewButton.addActionListener(e -> mostrarImagenEmergente());

       
        
        
        // Agregar los componentes de fondo y panel superior
        layeredPane.add(backgroundLabel, Integer.valueOf(1));  // Capa más baja (fondo)
        layeredPane.add(panelSuperior, Integer.valueOf(2));    // Encima del fondo

        // Crear el botón de "Salir" y su texto, pero inicialmente no visibles
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(989, 629, 89, 23);
        btnSalir.setVisible(false);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                Pruebas2 juegoVentana = new Pruebas2(estadoJuego); // Pasa el estado del juego
                juegoVentana.setVisible(true);
            }
        });
        layeredPane.add(btnSalir, Integer.valueOf(2));

        lblSalir = new JLabel("Salir");
        lblSalir.setBounds(1011, 633, 46, 14);
        lblSalir.setForeground(Color.WHITE);
        lblSalir.setVisible(false); // Inicialmente no visible
        layeredPane.add(lblSalir, Integer.valueOf(2));

        // Escuchar los cambios de tamaño de la ventana
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Escalar la imagen de fondo al tamaño de la ventana
                Image scaledImage = imageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                backgroundLabel.setIcon(new ImageIcon(scaledImage));
                backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
                

                // Ajustar el tamaño del panel superior
                panelSuperior.setBounds(0, 0, frame.getWidth(), 40);  // El panel superior mantiene el ancho de la ventana

                // Revalidar y repintar los componentes
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        frame.setVisible(true);
    }
    private void mostrarImagenEmergente() {
        // Crear el diálogo sin bordes
        JDialog dialogo = new JDialog(frame, true);
        dialogo.setUndecorated(true);
        dialogo.setSize(400, 400);
        dialogo.setLocationRelativeTo(frame); // Centrar en la ventana principal

        // Cargar la imagen
        ImageIcon imagenIcono = new ImageIcon("E:\\Clase\\RETO2\\Juego2\\libro juego bilingüe.png");
        Image imagenEscalada = imagenIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        JLabel lblImagen = new JLabel(new ImageIcon(imagenEscalada));

        // Crear un botón para cerrar
        JButton btnCerrar = new JButton("X");
        btnCerrar.setBounds(360, 10, 30, 30);
        btnCerrar.setBackground(Color.RED);
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.addActionListener(e -> dialogo.dispose());

        // Crear un panel transparente
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(lblImagen);
        panel.add(btnCerrar);
        
        lblImagen.setBounds(0, 0, 400, 400); // Ajustar la imagen en el panel

        dialogo.setContentPane(panel);
        dialogo.setVisible(true);
    }


    private JPanel crearPanelSuperior() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        lblPuntos = new JLabel("Puntos: " + estadoJuego.getPuntos());
        lblPuntos.setForeground(Color.WHITE);
        lblPuntos.setFont(new Font("Arial", Font.BOLD, 20));

        lblTemporizador = new JLabel("Tiempo: " + formatearTiempo(estadoJuego.getTiempoRestante()));
        lblTemporizador.setForeground(Color.WHITE);
        lblTemporizador.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(lblPuntos);
        panel.add(lblTemporizador);
        return panel;
    }

    private void iniciarTemporizador() {
        temporizador = new Timer(1000, new ActionListener() {
            private int contadorSegundos = 0;

            public void actionPerformed(ActionEvent e) {
                estadoJuego.decrementarTiempo(); // Solo se llama una vez
                contadorSegundos++;

                if (contadorSegundos % 5 == 0) { // Cada 5 segundos
                    estadoJuego.restarPuntos(5);
                    actualizarPuntos();
                }

                actualizarTemporizador();

                if (estadoJuego.getTiempoRestante() <= 0) {
                    temporizador.stop();
                    mostrarBotonSalir();  // Mostrar el botón de salir cuando el tiempo se acaba
                    JOptionPane.showMessageDialog(null, "¡Tiempo agotado!", "Fin de la cuenta atrás", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        temporizador.start();
    }

    private void mostrarBotonSalir() {
        btnSalir.setVisible(true);  // Hacer visible el botón "Salir"
        lblSalir.setVisible(true);  // Hacer visible el texto "Salir"
    }

    private void actualizarPuntos() {
        lblPuntos.setText("Puntos: " + estadoJuego.getPuntos());
    }

    private void actualizarTemporizador() {
        lblTemporizador.setText("Tiempo: " + formatearTiempo(estadoJuego.getTiempoRestante()));
    }

    private String formatearTiempo(int tiempo) {
        int horas = tiempo / 3600;
        int minutos = (tiempo % 3600) / 60;
        int segundos = tiempo % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    

    

        

    public static void main(String[] args) {
        EstadoJuego estadoJuego = new EstadoJuego(3600); // 1 hora en segundos
        SwingUtilities.invokeLater(() -> new Juego2(estadoJuego));
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}