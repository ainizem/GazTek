package Ventanas;

import javax.swing.*;
import java.awt.*;

public class SiguientePagina {
    public SiguientePagina(EstadoJuego estadoJuego) {
        JFrame frame = new JFrame("Siguiente Página");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());

        // Panel para mostrar los puntos y el tiempo restante
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel lblPuntos = new JLabel("Puntos: " + estadoJuego.getPuntos());
        JLabel lblTemporizador = new JLabel("Tiempo: " + formatearTiempo(estadoJuego.getTiempoRestante()));

        panel.add(lblPuntos);
        panel.add(lblTemporizador);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private String formatearTiempo(int tiempo) {
        int horas = tiempo / 3600;
        int minutos = (tiempo % 3600) / 60;
        int segundos = tiempo % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}