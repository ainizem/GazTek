package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private final ArrayList<Point> startPoints = new ArrayList<>();
    private final ArrayList<Point> endPoints = new ArrayList<>();
    private final ArrayList<Color> cableColors = new ArrayList<>();
    private Point selectedPoint = null;
    private Color selectedColor = null;
    private final ArrayList<Line> connectedLines = new ArrayList<>();

    public Main() {
        // Configuración básica del JFrame
        setTitle("Unir cables");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Generar puntos de origen y destino
        generateCables();

        // Panel de dibujo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawConnectors(g);
                drawLines(g);
            }
        };
        panel.setBackground(Color.GRAY);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectConnector(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                connectCable(e.getPoint());
                repaint();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPoint != null) {
                    Graphics2D g2 = (Graphics2D) panel.getGraphics();
                    panel.repaint();
                    g2.setColor(selectedColor);
                    g2.setStroke(new BasicStroke(5)); // Grosor del cable temporal
                    g2.drawLine(selectedPoint.x, selectedPoint.y, e.getX(), e.getY());
                }
            }
        });

        getContentPane().add(panel);
    }

    private void generateCables() {
        int yOffset = 100;
        int gap = 50;

        // Crear 4 cables con colores y posiciones predefinidas
        for (int i = 0; i < 4; i++) {
            startPoints.add(new Point(100, yOffset + i * gap));
            endPoints.add(new Point(700, yOffset + i * gap));
        }

        cableColors.add(Color.RED);
        cableColors.add(Color.BLUE);
        cableColors.add(Color.GREEN);
        cableColors.add(Color.YELLOW);
    }

    private void drawConnectors(Graphics g) {
        // Dibujar conectores de origen
        for (int i = 0; i < startPoints.size(); i++) {
            g.setColor(cableColors.get(i));
            g.fillOval(startPoints.get(i).x - 10, startPoints.get(i).y - 10, 20, 20);
        }

        // Dibujar conectores de destino
        for (int i = 0; i < endPoints.size(); i++) {
            g.setColor(cableColors.get(i));
            g.fillOval(endPoints.get(i).x - 10, endPoints.get(i).y - 10, 20, 20);
        }
    }

    private void drawLines(Graphics g) {
        // Convertir a Graphics2D para usar más opciones de dibujo
        Graphics2D g2 = (Graphics2D) g;

        // Dibujar las líneas conectadas con un trazo más grueso
        for (Line line : connectedLines) {
            g2.setColor(line.color);
            g2.setStroke(new BasicStroke(5)); // Grosor de las líneas (5 píxeles)
            g2.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
        }
    }

    private void selectConnector(Point point) {
        // Verificar si se hizo clic en un conector de origen
        for (int i = 0; i < startPoints.size(); i++) {
            if (point.distance(startPoints.get(i)) <= 10) {
                selectedPoint = startPoints.get(i);
                selectedColor = cableColors.get(i);
                return;
            }
        }
    }

    private void connectCable(Point point) {
        // Verificar si se soltó el mouse en un conector de destino
        for (int i = 0; i < endPoints.size(); i++) {
            if (point.distance(endPoints.get(i)) <= 10 && selectedColor == cableColors.get(i)) {
                connectedLines.add(new Line(selectedPoint, endPoints.get(i), selectedColor));
                startPoints.remove(selectedPoint);
                endPoints.remove(i);
                cableColors.remove(i);
                break;
            }
        }
        selectedPoint = null;
        selectedColor = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main game = new Main();
            game.setVisible(true);
        });
    }

    // Clase auxiliar para representar líneas conectadas
    static class Line {
        Point start, end;
        Color color;

        Line(Point start, Point end, Color color) {
            this.start = start;
            this.end = end;
            this.color = color;
        }
    }
}