package jugarPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrdenadoresView extends JFrame {
    private JLabel lblFondoOrdenadores;
    private JButton btnPasillo;
    private JLabel lblPasillo;
    private ImageIcon imageIcon;

    public OrdenadoresView() {
        setTitle("Ordenadores View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnPasillo = new JButton("");
        btnPasillo.setContentAreaFilled(false);
        btnPasillo.setBorderPainted(false);
        btnPasillo.setFocusPainted(false);
        btnPasillo.setOpaque(false);
        add(btnPasillo);

        lblPasillo = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
        add(lblPasillo);

        imageIcon = new ImageIcon("img\\ordenadoresR.jpg");
        lblFondoOrdenadores = new JLabel("");
        lblFondoOrdenadores.setIcon(imageIcon);
        add(lblFondoOrdenadores);

        btnPasillo.addActionListener(e -> {
            new PasilloView().setVisible(true);
            dispose();
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFondoOrdenadores.setIcon(new ImageIcon(scaledImage));
                lblFondoOrdenadores.setBounds(0, 0, width, height);

                btnPasillo.setBounds((int) (width * 0.48), (int) (height * 0.85), 100, 45);
                lblPasillo.setBounds((int) (width * 0.48), (int) (height * 0.85), 94, 45);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrdenadoresView().setVisible(true));
    }
}
