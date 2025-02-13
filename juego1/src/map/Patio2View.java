package map;

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
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		btnRecepcion = new JButton("");
		btnRecepcion.setContentAreaFilled(false);
		btnRecepcion.setBorderPainted(false);
		btnRecepcion.setFocusPainted(false);
		btnRecepcion.setOpaque(false);
		add(btnRecepcion);

		lblRecepcion = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
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
		add(btnCasa);

		lblCasa = new JLabel(new ImageIcon("img\\flecha-der.png"));
		add(lblCasa);

		imageIcon = new ImageIcon("img\\patio2R.png");
		lblFondoPatio2 = new JLabel("");
		lblFondoPatio2.setIcon(imageIcon);
		add(lblFondoPatio2);

		btnRecepcion.addActionListener(e -> switchWithFadeOut(new RecepcionView()));

		btnPatio1.addActionListener(e -> switchWithFadeOut(new PatioView()));

		btnCasa.addActionListener(e -> switchWithFadeOut(new CasaView()));

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				int height = getHeight();

				Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				lblFondoPatio2.setIcon(new ImageIcon(scaledImage));
				lblFondoPatio2.setBounds(0, 0, width, height);

				btnRecepcion.setBounds((int) (width * 0.35), (int) (height * 0.65), 74, 56);
				lblRecepcion.setBounds((int) (width * 0.35), (int) (height * 0.65), 74, 56);

				btnPatio1.setBounds((int) (width * 0.05), (int) (height * 0.4), 57, 56);
				lblPatio1.setBounds((int) (width * 0.05), (int) (height * 0.4), 57, 56);

				btnCasa.setBounds((int) (width * 0.8), (int) (height * 0.4), 89, 56);
				lblCasa.setBounds((int) (width * 0.8), (int) (height * 0.4), 57, 56);
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
		SwingUtilities.invokeLater(() -> new Patio2View().setVisible(true));
	}
}
