package jugarPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pasillo2View extends JFrame {
    private JLabel lblFondoPasillo2;
    private JButton btnBiblio, btnGym, btnLab, btnRecepcion;
    private JLabel lblBiblio, lblGym, lblLab, lblRecepcion;
    private ImageIcon imageIcon;

    public Pasillo2View() {
        setTitle("Pasillo2 View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnBiblio = new JButton("");
        btnBiblio.setContentAreaFilled(false);
        btnBiblio.setBorderPainted(false);
        btnBiblio.setFocusPainted(false);
        btnBiblio.setOpaque(false);
        add(btnBiblio);

        btnGym = new JButton("");
        btnGym.setContentAreaFilled(false);
        btnGym.setBorderPainted(false);
        btnGym.setFocusPainted(false);
        btnGym.setOpaque(false);
        add(btnGym);

        btnLab = new JButton("");
        btnLab.setContentAreaFilled(false);
        btnLab.setBorderPainted(false);
        btnLab.setFocusPainted(false);
        btnLab.setOpaque(false);
        add(btnLab);

        btnRecepcion = new JButton("");
        btnRecepcion.setContentAreaFilled(false);
        btnRecepcion.setBorderPainted(false);
        btnRecepcion.setFocusPainted(false);
        btnRecepcion.setOpaque(false);
        add(btnRecepcion);

        lblBiblio = new JLabel(new ImageIcon("img\\flecha-izq.png"));
        add(lblBiblio);

        lblGym = new JLabel(new ImageIcon("img\\flechote (1) (2).png"));
        add(lblGym);

        lblLab = new JLabel(new ImageIcon("img\\flecha-der.png"));
        add(lblLab);

        lblRecepcion = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
        add(lblRecepcion);

        imageIcon = new ImageIcon("img\\pasillo2R.jpg");
        lblFondoPasillo2 = new JLabel("");
        lblFondoPasillo2.setIcon(imageIcon);
        add(lblFondoPasillo2);

        btnBiblio.addActionListener(e -> {
            new BiblioView().setVisible(true);
            dispose();
        });

        btnGym.addActionListener(e -> {
            new GymView().setVisible(true);
            dispose();
        });

        btnLab.addActionListener(e -> {
            new LabView().setVisible(true);
            dispose();
        });

        btnRecepcion.addActionListener(e -> {
            new RecepcionView().setVisible(true);
            dispose();
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFondoPasillo2.setIcon(new ImageIcon(scaledImage));
                lblFondoPasillo2.setBounds(0, 0, width, height);

                btnBiblio.setBounds((int) (width * 0.28), (int) (height * 0.2), 33, 172);
                btnGym.setBounds((int) (width * 0.42), (int) (height * 0.2), 102, 91);
                btnLab.setBounds((int) (width * 0.6), (int) (height * 0.18), 33, 188);
                btnRecepcion.setBounds((int) (width * 0.45), (int) (height * 0.85), 89, 43);

                lblBiblio.setBounds((int) (width * 0.26), (int) (height * 0.23), 56, 136);
                lblGym.setBounds((int) (width * 0.44), (int) (height * 0.23), 62, 74);
                lblLab.setBounds((int) (width * 0.58), (int) (height * 0.23), 49, 153);
                lblRecepcion.setBounds((int) (width * 0.46), (int) (height * 0.86), 95, 52);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pasillo2View().setVisible(true));
    }
}