package jugarPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Patio2View extends JFrame {
    private JLabel lblFondoPatio2;
    private JButton btnRecepcion, btnPatio1, btnCasa;
    private JLabel lblRecepcion, lblPatio1, lblCasa;
    private ImageIcon imageIcon;

    public Patio2View() {
        setTitle("Patio2 View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnRecepcion = new JButton("");
        btnRecepcion.setContentAreaFilled(false);
        btnRecepcion.setBorderPainted(false);
        btnRecepcion.setFocusPainted(false);
        btnRecepcion.setOpaque(false);
        btnRecepcion.setBounds(670,650, 74, 56);

        add(btnRecepcion);

        lblRecepcion = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
        lblRecepcion.setBounds(670,650, 74, 56);

        add(lblRecepcion);

        btnPatio1 = new JButton("");
        btnPatio1.setContentAreaFilled(false);
        btnPatio1.setBorderPainted(false);
        btnPatio1.setFocusPainted(false);
        btnPatio1.setOpaque(false);
        add(btnPatio1);

        lblPatio1 = new JLabel(new ImageIcon("img\\flecha-izq.png"));
        add(lblPatio1);

        btnCasa = new JButton("");
        btnCasa.setContentAreaFilled(false);
        btnCasa.setBorderPainted(false);
        btnCasa.setFocusPainted(false);
        btnCasa.setOpaque(false);
        btnCasa.setBounds(1300,300, 57, 56);

        add(btnCasa);

        lblCasa = new JLabel(new ImageIcon("img\\flecha-der.png"));
        lblCasa.setBounds(1300,300, 57, 56);

        add(lblCasa);

        imageIcon = new ImageIcon("img\\patio2R.png");
        lblFondoPatio2 = new JLabel("");
        lblFondoPatio2.setIcon(imageIcon);
        add(lblFondoPatio2);

        btnRecepcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new RecepcionView().setVisible(true);
				dispose();

			}
		});

        btnPatio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PatioView().setVisible(true);
				dispose();

			}
		});

        btnCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CasaView().setVisible(true);
				dispose();

			}
		});

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFondoPatio2.setIcon(new ImageIcon(scaledImage));
                lblFondoPatio2.setBounds(0, 0, width, height);

                btnPatio1.setBounds((int) (width * 0.05), (int) (height * 0.4), 57, 56);
                lblPatio1.setBounds((int) (width * 0.05), (int) (height * 0.4), 57, 56);

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Patio2View().setVisible(true));
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
