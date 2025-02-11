package jugarPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatioView extends JFrame {
    private JLabel lblFondoPatio;
    private JButton btnPatio2, btnPasillo, btnRecepcion;
    private JLabel lblPatio2, lblPasillo, lblRecepcion;
    private ImageIcon imageIcon;

    public PatioView() {
        setTitle("Patio View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnPatio2 = new JButton("");
        btnPatio2.setContentAreaFilled(false);
        btnPatio2.setBorderPainted(false);
        btnPatio2.setFocusPainted(false);
        btnPatio2.setOpaque(false);
        btnPatio2.setBounds(1300,250, 52, 92);
        add(btnPatio2);

        lblPatio2 = new JLabel(new ImageIcon("img\\flecha-der.png"));
        lblPatio2.setBounds(1300,250, 52, 92);

        add(lblPatio2);

        btnPasillo = new JButton("");
        btnPasillo.setContentAreaFilled(false);
        btnPasillo.setBorderPainted(false);
        btnPasillo.setFocusPainted(false);
        btnPasillo.setOpaque(false);
        btnPasillo.setBounds(470,420, 46, 34);
        add(btnPasillo);

        lblPasillo = new JLabel(new ImageIcon("img\\flecha-arriba.png"));
        lblPasillo.setBounds(470,420, 46, 34);

        add(lblPasillo);

        btnRecepcion = new JButton("");
        btnRecepcion.setContentAreaFilled(false);
        btnRecepcion.setBorderPainted(false);
        btnRecepcion.setFocusPainted(false);
        btnRecepcion.setOpaque(false);
        btnRecepcion.setBounds(700,420, 46, 34);

        add(btnRecepcion);

        lblRecepcion = new JLabel(new ImageIcon("img\\flecha-arriba.png"));
        lblRecepcion.setBounds(700,420, 46, 34);

        add(lblRecepcion);

        imageIcon = new ImageIcon("img\\patio1R.jpg");
        lblFondoPatio = new JLabel("");
        lblFondoPatio.setIcon(imageIcon);
        add(lblFondoPatio);

        btnPatio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Patio2View().setVisible(true);
				dispose();

			}
		});

        btnPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PasilloView().setVisible(true);
				dispose();

			}
		});

        btnRecepcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new RecepcionView().setVisible(true);
				dispose();

			}
		});

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFondoPatio.setIcon(new ImageIcon(scaledImage));
                lblFondoPatio.setBounds(0, 0, width, height);

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatioView().setVisible(true));
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
}
