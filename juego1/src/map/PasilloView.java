package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasilloView extends JFrame {
    private JLabel lblFondoPasillo;
    private JButton btnAula, btnOrdenadores, btnPatio, btnRecepcion;
    private JLabel lblAula, lblOrdenadores, lblPatio, lblRecepcion;
    private ImageIcon imageIcon;

    public PasilloView() {
        setTitle("Pasillo View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnAula = new JButton("");
        btnAula.setContentAreaFilled(false);
        btnAula.setBorderPainted(false);
        btnAula.setFocusPainted(false);
        btnAula.setOpaque(false);
        add(btnAula);

        lblAula = new JLabel(new ImageIcon("img\\flecha-izq.png"));
        add(lblAula);

        btnOrdenadores = new JButton("");
        btnOrdenadores.setContentAreaFilled(false);
        btnOrdenadores.setBorderPainted(false);
        btnOrdenadores.setFocusPainted(false);
        btnOrdenadores.setOpaque(false);
        add(btnOrdenadores);

        lblOrdenadores = new JLabel(new ImageIcon("img\\flecha-der.png"));
        add(lblOrdenadores);

        btnPatio = new JButton("");
        btnPatio.setContentAreaFilled(false);
        btnPatio.setBorderPainted(false);
        btnPatio.setFocusPainted(false);
        btnPatio.setOpaque(false);
        add(btnPatio);

        lblPatio = new JLabel(new ImageIcon("img\\flechote (1).png"));
        add(lblPatio);

        btnRecepcion = new JButton("");
        btnRecepcion.setContentAreaFilled(false);
        btnRecepcion.setBorderPainted(false);
        btnRecepcion.setFocusPainted(false);
        btnRecepcion.setOpaque(false);
        add(btnRecepcion);

        lblRecepcion = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
        add(lblRecepcion);

        imageIcon = new ImageIcon("img\\pasillo1R.png");
        lblFondoPasillo = new JLabel("");
        lblFondoPasillo.setIcon(imageIcon);
        add(lblFondoPasillo);

        btnAula.addActionListener(e -> switchWithFadeOut(new AulaView()));

        btnOrdenadores.addActionListener(e -> switchWithFadeOut(new OrdenadoresView()));

        btnPatio.addActionListener(e -> switchWithFadeOut(new PatioView()));

        btnRecepcion.addActionListener(e -> switchWithFadeOut(new RecepcionView()));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFondoPasillo.setIcon(new ImageIcon(scaledImage));
                lblFondoPasillo.setBounds(0, 0, width, height);

                btnAula.setBounds((int) (width * 0.2), (int) (height * 0.3), 26, 274);
                lblAula.setBounds((int) (width * 0.19), (int) (height * 0.4), 51, 81);

                btnOrdenadores.setBounds((int) (width * 0.58), (int) (height * 0.25), 46, 220);
                lblOrdenadores.setBounds((int) (width * 0.58), (int) (height * 0.25), 46, 193);

                btnPatio.setBounds((int) (width * 0.43), (int) (height * 0.35), 89, 117);
                lblPatio.setBounds((int) (width * 0.43), (int) (height * 0.4), 78, 38);

                btnRecepcion.setBounds((int) (width * 0.43), (int) (height * 0.65), 114, 32);
                lblRecepcion.setBounds((int) (width * 0.43), (int) (height * 0.65), 114, 44);
            }
        });
    }
    private void switchWithFadeOut(JFrame nextView) {
        nextView.setVisible(true);
        Timer timer = new Timer(20, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f;
                if (opacity <= 0) {
                    ((Timer) e.getSource()).stop();
                    dispose();
                } else {
                    setOpacity(opacity);
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasilloView().setVisible(true));
    }
}