package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pruebas2 {
    private EstadoJuego estadoJuego;
    private JLabel lblPuntos;
    private JLabel lblTemporizador;
    private Timer temporizador;
    private JLabel backgroundLabel; 
    private ImageIcon imageIcon; 

    /**
     * @wbp.parser.entryPoint
     */
    public Pruebas2(EstadoJuego estadoJuego) {
    	
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
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());

        // Cargar la imagen de fondo
        imageIcon = new ImageIcon("D:\\Benat\\RETO2\\download.jpeg");
        backgroundLabel = new JLabel();
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.setVerticalAlignment(SwingConstants.CENTER);
        actualizarImagenFondo(frame.getSize());

        frame.getContentPane().add(backgroundLabel, BorderLayout.CENTER);

        // Panel superior para los puntos y el temporizador
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.DARK_GRAY);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));

        lblPuntos = new JLabel("Puntos: " + estadoJuego.getPuntos());
        lblPuntos.setForeground(Color.WHITE);
        lblPuntos.setFont(new Font("Arial", Font.BOLD, 20));

        lblTemporizador = new JLabel("Tiempo: " + formatearTiempo(estadoJuego.getTiempoRestante()));
        lblTemporizador.setForeground(Color.WHITE);
        lblTemporizador.setFont(new Font("Arial", Font.BOLD, 20));

        panelSuperior.add(lblPuntos);
        panelSuperior.add(lblTemporizador);

        frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        JButton btnPunto1 = new JButton("Gana 1 punto");
        btnPunto1.setForeground(Color.BLACK);
        btnPunto1.setBackground(Color.WHITE);
        btnPunto1.setPreferredSize(new Dimension(200, 80));

        JButton btnPunto5 = new JButton("Gana 5 puntos");
        btnPunto5.setBackground(Color.WHITE);
        btnPunto5.setPreferredSize(new Dimension(200, 80));

        panelBotones.add(btnPunto1);
        panelBotones.add(btnPunto5);
        frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);

        // Acción para el botón 1
        btnPunto1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                estadoJuego.agregarPuntos(1);
                abrirSiguientePagina(frame);
            }
        });

        // Acción para el botón 2
        btnPunto5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                estadoJuego.agregarPuntos(5);
                abrirSiguientePagina(frame);
            }
        });

        // Temporizador
       // temporizador = new Timer(1000, new ActionListener() {
       //       estadoJuego.decrementarTiempo();
         //     if (estadoJuego.getTiempoRestante() <= 0) {
           //         temporizador.stop();
             //       JOptionPane.showMessageDialog(frame, "¡Tiempo agotado!", "Fin de la cuenta atrás", JOptionPane.INFORMATION_MESSAGE);
               // }
            //}
       // });
        
     // Temporizador que actualiza el tiempo y resta puntos cada 5 segundos
        temporizador = new Timer(1000, new ActionListener() {
            private int contadorSegundos = 0;

            public void actionPerformed(ActionEvent e) {
                estadoJuego.decrementarTiempo();
                contadorSegundos++;

                if (contadorSegundos % 5 == 0) { // Cada 5 segundos
                    estadoJuego.restarPuntos(5);
                    actualizarPuntos();
                }

                actualizarTemporizador();

                if (estadoJuego.getTiempoRestante() <= 0) {
                    temporizador.stop();
                    JOptionPane.showMessageDialog(frame, "¡Tiempo agotado!", "Fin de la cuenta atrás", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        temporizador.start();

        // Listener para ajustar el fondo al redimensionar la ventana
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                actualizarImagenFondo(frame.getSize());
            }
        });

        frame.setVisible(true);
    }

    private void abrirSiguientePagina(JFrame frame) {
        frame.dispose(); // Cerrar la ventana actual
        temporizador.stop(); // Detiene el temporizador antes de cerrar la ventana
        new Pruebas(estadoJuego);
    }

    private void actualizarImagenFondo(Dimension size) {
        Image scaledImage = imageIcon.getImage().getScaledInstance(
                size.width,
                size.height,
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
        SwingUtilities.invokeLater(() -> new Pruebas2(estadoJuego));
    }
    

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}