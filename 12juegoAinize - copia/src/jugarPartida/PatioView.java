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
        add(btnPatio2);

        lblPatio2 = new JLabel(new ImageIcon("img\\flecha-der.png"));
        add(lblPatio2);

        btnPasillo = new JButton("");
        btnPasillo.setContentAreaFilled(false);
        btnPasillo.setBorderPainted(false);
        btnPasillo.setFocusPainted(false);
        btnPasillo.setOpaque(false);
        add(btnPasillo);

        lblPasillo = new JLabel(new ImageIcon("img\\flechote (1) (2).png"));
        add(lblPasillo);

        btnRecepcion = new JButton("");
        btnRecepcion.setContentAreaFilled(false);
        btnRecepcion.setBorderPainted(false);
        btnRecepcion.setFocusPainted(false);
        btnRecepcion.setOpaque(false);
        add(btnRecepcion);

        lblRecepcion = new JLabel(new ImageIcon("img\\flechote (1) (2).png"));
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

                btnPatio2.setBounds((int) (width * 0.9), (int) (height * 0.3), 52, 92);
                lblPatio2.setBounds((int) (width * 0.9), (int) (height * 0.3), 52, 92);
                
                btnPasillo.setBounds((int) (width * 0.33), (int) (height * 0.5), 47, 32);
                lblPasillo.setBounds((int) (width * 0.33), (int) (height * 0.5), 46, 24);
                
                btnRecepcion.setBounds((int) (width * 0.5), (int) (height * 0.5), 38, 32);
                lblRecepcion.setBounds((int) (width * 0.5), (int) (height * 0.5), 46, 24);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatioView().setVisible(true));
    }
}
