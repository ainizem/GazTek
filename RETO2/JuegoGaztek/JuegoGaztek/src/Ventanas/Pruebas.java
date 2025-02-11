package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pruebas {
    private EstadoJuego estadoJuego; // Instancia de EstadoJuego
    private JLabel lblPuntos; // Etiqueta para mostrar los puntos
    private JLabel lblTemporizador; // Etiqueta para mostrar el temporizador
    private Timer temporizador; // Temporizador para actualizar cada cierto tiempo
    private CardLayout cardLayout; // Layout para manejar la navegación entre paneles
    private JPanel mainPanel; // Panel principal que contendrá los diferentes paneles

    public Pruebas(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego; // Inicializar el estado del juego
        inicializarVentana();
    }

    private void inicializarVentana() {
        JFrame frame = new JFrame("Juego Adaptativo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);  // Centrar ventana en pantalla

        // Inicializar el CardLayout y el panel principal
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Crear panel para ganar puntos
        JPanel panelGanarPuntos = crearPanelGanarPuntos();
        mainPanel.add(panelGanarPuntos, "GanarPuntos");

        // Crear panel para mostrar el estado del juego
        JPanel panelEstadoJuego = crearPanelEstadoJuego();
        mainPanel.add(panelEstadoJuego, "EstadoJuego");

        // Crear un panel superior para el estado del juego
        JPanel panelSuperior = crearPanelSuperior();
        
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Iniciar el temporizador
        iniciarTemporizador();

        frame.setVisible(true);
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

    private JPanel crearPanelGanarPuntos() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Cargar la imagen de fondo
        ImageIcon imageIcon = new ImageIcon("D:\\Benat\\RETO2\\download.jpeg");
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.setVerticalAlignment(SwingConstants.CENTER);
        actualizarImagenFondo(panel.getSize(), imageIcon, backgroundLabel);

        panel.add(backgroundLabel, BorderLayout.CENTER);

        // Panel de botones con tamaño personalizado
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20)); // Espaciado entre botones

        JButton btnPunto1 = new JButton("Gana 1 punto");
        btnPunto1.setPreferredSize(new Dimension(200, 80)); // Tamaño personalizado

        JButton btnPunto5 = new JButton("Gana 5 puntos");
        btnPunto5.setPreferredSize(new Dimension(200, 80)); // Tamaño personalizado

        panelBotones.add(btnPunto1);
        panelBotones.add(btnPunto5);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Acción para el botón 1
        btnPunto1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                estadoJuego.agregarPuntos(1);
                actualizarPuntos();
            }
        });

        // Acción para el botón 2
        btnPunto5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                estadoJuego.agregarPuntos(5);
                actualizarPuntos();
            }
        });

        return panel;
    }

    private JPanel crearPanelEstadoJuego() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Mostrar puntos y temporizador
        JLabel lblEstado = new JLabel("Estado del Juego", SwingConstants.CENTER);
        lblEstado.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lblEstado, BorderLayout.NORTH);

        // Botón para volver a ganar puntos
        JButton btnVolver = new JButton("Volver a Ganar Puntos");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "GanarPuntos");
            }
        });
        panel.add(btnVolver, BorderLayout.SOUTH);

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
    	                JOptionPane.showMessageDialog(null, "¡Tiempo agotado!", "Fin de la cuenta atrás", JOptionPane.INFORMATION_MESSAGE);
    	            }
    	        }
    	    });
    	    temporizador.start();
    }

    private void actualizarImagenFondo(Dimension size, ImageIcon imageIcon, JLabel backgroundLabel) {
        Image scaledImage = imageIcon.getImage().getScaledInstance(
                size.width - 20,  // Ajuste de márgenes
                size.height - 120, // Considerando espacio para botones y barra superior
                Image.SCALE_SMOOTH
        );
        backgroundLabel.setIcon(new ImageIcon(scaledImage));
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
        SwingUtilities.invokeLater(() -> new Pruebas(estadoJuego));
    }
}