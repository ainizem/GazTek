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
		btnBiblio.setBounds(420, 240, 33, 172);
		add(btnBiblio);

		btnGym = new JButton("");
		btnGym.setContentAreaFilled(false);
		btnGym.setBorderPainted(false);
		btnGym.setFocusPainted(false);
		btnGym.setOpaque(false);
		btnGym.setBounds(670, 240, 62, 74);
		add(btnGym);

		btnLab = new JButton("");
		btnLab.setContentAreaFilled(false);
		btnLab.setBorderPainted(false);
		btnLab.setFocusPainted(false);
		btnLab.setOpaque(false);
		btnLab.setBounds(900, 230, 49, 153);
		add(btnLab);

		btnRecepcion = new JButton("");
		btnRecepcion.setContentAreaFilled(false);
		btnRecepcion.setBorderPainted(false);
		btnRecepcion.setFocusPainted(false);
		btnRecepcion.setOpaque(false);
		btnRecepcion.setBounds(670, 640, 95, 52);

		add(btnRecepcion);

		lblBiblio = new JLabel(new ImageIcon("img\\flecha-izq.png"));
		lblBiblio.setBounds(420, 240, 33, 172);
		add(lblBiblio);

		lblGym = new JLabel(new ImageIcon("img\\flecha-arriba.png"));
		lblGym.setBounds(670, 240, 62, 74);

		add(lblGym);

		lblLab = new JLabel(new ImageIcon("img\\flecha-der.png"));
		lblLab.setBounds(900, 230, 49, 153);

		add(lblLab);

		lblRecepcion = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
		lblRecepcion.setBounds(670, 640, 95, 52);

		add(lblRecepcion);

		imageIcon = new ImageIcon("img\\pasillo2R.jpg");
		lblFondoPasillo2 = new JLabel("");
		lblFondoPasillo2.setIcon(imageIcon);
		add(lblFondoPasillo2);

		btnBiblio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new BiblioView().setVisible(true);
				dispose();

			}
		});

		btnGym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new GymView().setVisible(true);
				dispose();

			}
		});

		btnLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new LabView().setVisible(true);
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
				lblFondoPasillo2.setIcon(new ImageIcon(scaledImage));
				lblFondoPasillo2.setBounds(0, 0, width, height);

			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Pasillo2View().setVisible(true));
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