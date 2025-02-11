package PrimerJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Ventanas.EstadoJuego;
import Ventanas.Pruebas2;

public class Juego {
    private EstadoJuego estadoJuego;
    private JFrame frame;
    private List<JPanel> tutorialPanels;
    private int tutorialIndex = 0;
    private JLabel lblPuntos;
    private JLabel lblTemporizador;
    private Timer temporizador;
    private Set<JButton> botonesPresionados = new HashSet<>();
    private JButton[] botones; // Arreglo para manejar los botones
    private JButton btnSalir;
    private JButton btnAyuda;
    private JLabel lblSalir;
    private JLabel lblObjetosRestantes;
    private JPanel panelObjetosRestantes;
    private List<JLabel> listaObjetos;

    /**
     * @wbp.parser.entryPoint
     */
    public Juego(EstadoJuego estadoJuego) {
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
            "Capitulo 1.",
            "Debes encontrar tus objetos y cogerlos(Clickando encima).",
            "Cada objetos te dará puntos, pero recuerda que el tiempo es limitado.",
            "Cuando el tiempo se acabe, perderas el juego.",
            "<html>Encuentra los siguientes objetos: <br>El libro rojo <br> La agenda azul <br> Las gafas <br> Y tu estuche</html>",
            "Suerte."
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
            frame.dispose();
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
        ImageIcon imageIcon = new ImageIcon("E:\\Clase\\RETO2\\clase jueguillo.png"); 
        
        Image imagenEscalada = imageIcon.getImage().getScaledInstance(1200, 748, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(imagenEscalada));
        backgroundLabel.setBounds(0, 0, 1233, 716);

        // Panel superior con puntos y temporizador
        JPanel panelSuperior = crearPanelSuperior();
        panelSuperior.setBounds(0, 0, 1200, 34);
        panelSuperior.setBackground(Color.DARK_GRAY);
        
        btnAyuda = new JButton();
        btnAyuda.setBounds(244, 210, 50, 50);
        btnAyuda.setIcon(new ImageIcon("img\\bombilla.png")); // Asegúrate de usar una imagen en tu carpeta
        btnAyuda.setContentAreaFilled(false); // Hace que el botón sea más limpio
        btnAyuda.setBorderPainted(false); // Quita el borde
        btnAyuda.setVisible(true);
        layeredPane.add(btnAyuda, Integer.valueOf(2)); 
        
        ImageIcon icon = new ImageIcon("img\\bombilla.png");
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Error al cargar la imagen");
        }
        
        panelObjetosRestantes = new JPanel();
        panelObjetosRestantes.setLayout(new BoxLayout(panelObjetosRestantes, BoxLayout.Y_AXIS));
        panelObjetosRestantes.setBounds(20, 40, 200, 300);  // Ajusta la posición y el tamaño
        panelObjetosRestantes.setOpaque(false);  // Para que el fondo no cubra los elementos
        layeredPane.add(panelObjetosRestantes, Integer.valueOf(2));  // Añadir al layeredPane
        
        // Lista de objetos a encontrar
        listaObjetos = new ArrayList<>();
        String[] nombresObjetos = {"Libro Rojo", "Agenda Azul", "Estuche", "Gafas"};
        
        panelObjetosRestantes.setLayout(null); // Desactivar el layout automático

        int x = 100; // Posición inicial en X
        int y = 100; // Posición inicial en Y
        int width = 200; // Ancho del JLabel
        int height = 35; // Alto del JLabel
        int spacing = 45;
        
        for (String nombre : nombresObjetos) {
            JLabel objetoLabel = new JLabel(nombre);
            objetoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            objetoLabel.setForeground(Color.WHITE);  // Puedes cambiar el color para hacerlo visible
            
            objetoLabel.setBounds(x, y, width, height); // Posición y tamaño
            y += spacing;
            
            listaObjetos.add(objetoLabel);
            panelObjetosRestantes.add(objetoLabel);
        }

        // Revalidar para actualizar la interfaz
        panelObjetosRestantes.revalidate();
        panelObjetosRestantes.repaint();
       
        

        // Crear los botones
        botones = new JButton[4];
        int[][] posiciones = {
            {206, 622, 70, 86},
            {715, 304, 27, 34},
            {1018, 359, 41, 23},
            {1144, 510, 27, 23}
        };

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("Botón " + (i + 1));
            botones[i].setBounds(posiciones[i][0], posiciones[i][1], posiciones[i][2], posiciones[i][3]);
            botones[i].addActionListener(new BotonListener(botones[i], nombresObjetos[i])); // Agregar acción
            botones[i].setVisible(true);
            layeredPane.add(botones[i]);
        }
        
        lblObjetosRestantes.setText("Objetos restantes: " + botones.length);

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

                // Ajustar las posiciones de los botones en función del tamaño de la ventana
                for (int i = 0; i < botones.length; i++) {
                    int x = (int) (posiciones[i][0] * (frame.getWidth() / 1200.0)); // Escalar la posición X
                    int y = (int) (posiciones[i][1] * (frame.getHeight() / 800.0)); // Escalar la posición Y
                    int width = (int) (posiciones[i][2] * (frame.getWidth() / 1200.0)); // Escalar el ancho
                    int height = (int) (posiciones[i][3] * (frame.getHeight() / 800.0)); // Escalar la altura

                    botones[i].setBounds(x, y, width, height); // Establecer los nuevos valores
                }

                // Ajustar el tamaño del panel superior
                panelSuperior.setBounds(0, 0, frame.getWidth(), 40);  // El panel superior mantiene el ancho de la ventana

                // Revalidar y repintar los componentes
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        frame.setVisible(true);
    }

    private JPanel crearPanelSuperior() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 30, 5, 30); // Margen entre elementos
        gbc.anchor = GridBagConstraints.WEST; // Alineación izquierda
        
        
        lblPuntos = new JLabel("Puntos: " + estadoJuego.getPuntos());
        lblPuntos.setForeground(Color.WHITE);
        lblPuntos.setFont(new Font("Arial", Font.BOLD, 20));

        lblTemporizador = new JLabel("Tiempo: " + formatearTiempo(estadoJuego.getTiempoRestante()));
        lblTemporizador.setForeground(Color.WHITE);
        lblTemporizador.setFont(new Font("Arial", Font.BOLD, 20));
        
        lblObjetosRestantes = new JLabel("Objetos restantes: Cargando...");
        lblObjetosRestantes.setForeground(Color.WHITE);
        lblObjetosRestantes.setFont(new Font("Arial", Font.BOLD, 20));
        lblObjetosRestantes.setVisible(false);
        

     // Añadir lblPuntos a la izquierda
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblPuntos, gbc);

        // Añadir lblTemporizador en el centro
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lblTemporizador, gbc);

        // Añadir lblObjetosRestantes a la derecha
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lblObjetosRestantes, gbc);
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

    private void verificarJuegoFinalizado() {
        int restantes = botones.length - botonesPresionados.size();
        lblObjetosRestantes.setText("Objetos restantes: " + restantes); // Actualizar el mensaje en la pantalla

        if (restantes == 0) {
            mostrarBotonSalir();  
            JOptionPane.showMessageDialog(null, "¡Felicidades! Has encontrado todos los objetos.", "Juego completado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class BotonListener implements ActionListener {
        private JButton boton;
        private String nombreObjeto;

        public BotonListener(JButton boton, String nombreObjeto) {
            this.boton = boton;
            this.nombreObjeto = nombreObjeto;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!botonesPresionados.contains(boton)) {
                botonesPresionados.add(boton);
                estadoJuego.agregarPuntos(100);
                actualizarPuntos();
                boton.setEnabled(false); // Desactivar el botón

                // Encontramos el objeto, así que lo tachamos
                tacharObjeto(nombreObjeto);

                verificarJuegoFinalizado();
            }
        }
    }

    private void tacharObjeto(String nombreObjeto) {
        for (JLabel label : listaObjetos) {
            if (label.getText().equals(nombreObjeto)) {
                // Tachamos el objeto
                label.setText("<html><s>" + label.getText() + "</s></html>");  // HTML para tachar el texto
                label.setForeground(Color.GRAY);  // Opcional: Cambiar el color para dar la sensación de que ya fue encontrado
                break;
            }
        }
    }

   

    public static void main(String[] args) {
        EstadoJuego estadoJuego = new EstadoJuego(3600); // 1 hora en segundos
        SwingUtilities.invokeLater(() -> new Juego(estadoJuego));
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
