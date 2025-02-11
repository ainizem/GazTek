package jugarPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class PasilloView extends JFrame {
    private JLabel lblFondoPasillo;
    private JButton btnAula, btnOrdenadores, btnPatio, btnRecepcion;
    private JLabel lblAula, lblOrdenadores, lblPatio, lblRecepcion;
    private ImageIcon imageIcon;

    public PasilloView() {
        setTitle("Pasillo View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnAula = new JButton("");
        btnAula.setContentAreaFilled(false);
        btnAula.setBorderPainted(false);
        btnAula.setFocusPainted(false);
        btnAula.setOpaque(false);
        btnAula.setBounds(440,290, 30, 274);

        add(btnAula);

        lblAula = new JLabel(new ImageIcon("img\\flecha-izq.png"));
        lblAula.setBounds(440,290, 35, 274);

        add(lblAula);

        btnOrdenadores = new JButton("");
        btnOrdenadores.setContentAreaFilled(false);
        btnOrdenadores.setBorderPainted(false);
        btnOrdenadores.setFocusPainted(false);
        btnOrdenadores.setOpaque(false);
        btnOrdenadores.setBounds(820,290, 46, 193);

        add(btnOrdenadores);

        lblOrdenadores = new JLabel(new ImageIcon("img\\flecha-der.png"));
        lblOrdenadores.setBounds(820,340, 46, 193);

        add(lblOrdenadores);

        btnPatio = new JButton("");
        btnPatio.setContentAreaFilled(false);
        btnPatio.setBorderPainted(false);
        btnPatio.setFocusPainted(false);
        btnPatio.setOpaque(false);
        btnPatio.setBounds(630,350, 78, 38);

        add(btnPatio);

        lblPatio = new JLabel(new ImageIcon("img\\flecha-arriba.png"));
        lblPatio.setBounds(630,350, 78, 38);

        add(lblPatio);

        btnRecepcion = new JButton("");
        btnRecepcion.setContentAreaFilled(false);
        btnRecepcion.setBorderPainted(false);
        btnRecepcion.setFocusPainted(false);
        btnRecepcion.setOpaque(false);
        btnRecepcion.setBounds(630,670, 114, 44);

        add(btnRecepcion);

        lblRecepcion = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
        lblRecepcion.setBounds(630,670, 114, 44);

        add(lblRecepcion);

        imageIcon = new ImageIcon("img\\pasillo1R.png");
        lblFondoPasillo = new JLabel("");
        lblFondoPasillo.setIcon(imageIcon);
        add(lblFondoPasillo);

        btnAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new AulaView().setVisible(true);
				dispose();

			}
		});

        btnOrdenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new OrdenadoresView().setVisible(true);
				dispose();

			}
		});

        btnPatio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PatioView().setVisible(true);
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
                lblFondoPasillo.setIcon(new ImageIcon(scaledImage));
                lblFondoPasillo.setBounds(0, 0, width, height);

               
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasilloView().setVisible(true));
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