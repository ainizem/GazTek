package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CasaView extends JFrame {
    private JLabel lblFondoCasa, lblDesenlace, lblMovil, lblTarjetaGym;
    private JButton btnPatio2, btnMochila, btnCajon;
    private JButton[] btnNumeros = new JButton[10];
    private StringBuilder contrasena = new StringBuilder();
    private final String CONTRASENA_CORRECTA = "250909";
    private ImageIcon imageIcon;

    public CasaView() {
        setTitle("Casa View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnPatio2 = new JButton("");
        btnPatio2.setContentAreaFilled(false);
        btnPatio2.setBorderPainted(false);
        btnPatio2.setFocusPainted(false);
        btnPatio2.setOpaque(false);
        add(btnPatio2);

        lblDesenlace = new JLabel("");
        lblDesenlace.setHorizontalAlignment(SwingConstants.CENTER);
        lblDesenlace.setForeground(Color.WHITE);
        add(lblDesenlace);
        lblDesenlace.setVisible(false);

        lblMovil = new JLabel(new ImageIcon("img\\movilF-transformed (2).png"));
        add(lblMovil);
        lblMovil.setVisible(false);

        lblTarjetaGym = new JLabel(new ImageIcon("img\\tarjetaGym (1) (1).png"));
        add(lblTarjetaGym);
        lblTarjetaGym.setVisible(false);

        btnCajon = new JButton("");
        btnCajon.setContentAreaFilled(false);
        btnCajon.setBorderPainted(false);
        btnCajon.setFocusPainted(false);
        btnCajon.setOpaque(false);
        add(btnCajon);
        btnCajon.setVisible(false);

        btnMochila = new JButton("");
        btnMochila.setContentAreaFilled(false);
        btnMochila.setBorderPainted(false);
        btnMochila.setFocusPainted(false);
        btnMochila.setOpaque(false);
        add(btnMochila);

        for (int i = 0; i < 10; i++) {
            btnNumeros[i] = new JButton("");
            btnNumeros[i].setContentAreaFilled(false);
            btnNumeros[i].setBorderPainted(false);
            btnNumeros[i].setFocusPainted(false);
            btnNumeros[i].setOpaque(false);
            add(btnNumeros[i]);
            setupPasswordButton(btnNumeros[i], String.valueOf(i));
        }

        imageIcon = new ImageIcon("img\\habitacionR.png");
        lblFondoCasa = new JLabel("");
        lblFondoCasa.setIcon(imageIcon);
        add(lblFondoCasa);

        btnPatio2.addActionListener(e -> {
            new Patio2View().setVisible(true);
            dispose();
        });

        btnMochila.addActionListener(e -> {
            lblTarjetaGym.setVisible(true);
            btnCajon.setVisible(true);
        });

        btnCajon.addActionListener(e -> lblMovil.setVisible(true));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFondoCasa.setIcon(new ImageIcon(scaledImage));
                lblFondoCasa.setBounds(0, 0, width, height);

                btnPatio2.setBounds((int) (width * 0.05), (int) (height * 0.4), 67, 64);
                btnMochila.setBounds((int) (width * 0.6), (int) (height * 0.8), 67, 64);
                btnCajon.setBounds((int) (width * 0.15), (int) (height * 0.7), 54, 23);
                lblMovil.setBounds((int) (width * 0.3), (int) (height * 0.1), 284, 533);
                lblTarjetaGym.setBounds((int) (width * 0.7), 0, 473, 288);

                for (int i = 0; i < 10; i++) {
                    int row = i / 3;
                    int col = i % 3;
                    btnNumeros[i].setBounds((int) (width * 0.3) + col * 80, (int) (height * 0.4) + row * 60, 45, 44);
                }
            }
        });
    }

    private void setupPasswordButton(JButton button, String value) {
        button.addActionListener(e -> {
            contrasena.append(value);
            checkPassword();
        });
    }

    private void checkPassword() {
        if (contrasena.length() == 6) {
            lblDesenlace.setVisible(true);
            if (contrasena.toString().equals(CONTRASENA_CORRECTA)) {
                lblDesenlace.setText("¡Contraseña correcta!");
            } else {
                lblDesenlace.setText("Contraseña incorrecta");
                contrasena.setLength(0);
                lblDesenlace.setText("Vuelve a intentarlo");
            }
        }
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
        SwingUtilities.invokeLater(() -> new CasaView().setVisible(true));
    }
}
