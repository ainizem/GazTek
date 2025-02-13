package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecepcionView extends JFrame {
	private JLabel lblFondoRecepcion;
	private JButton btnPasillo, btnPasillo2, btnPatio2;
	private JLabel lblPasillo, lblPasillo2, lblPatio2;
	private ImageIcon imageIcon;

	public RecepcionView() {
		setTitle("Recepcion View");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setResizable(false);
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

		btnPasillo2 = new JButton("");
		btnPasillo2.setContentAreaFilled(false);
		btnPasillo2.setBorderPainted(false);
		btnPasillo2.setFocusPainted(false);
		btnPasillo2.setOpaque(false);
		add(btnPasillo2);

		lblPasillo2 = new JLabel(new ImageIcon("img\\flecha-izq.png"));
		add(lblPasillo2);

		btnPatio2 = new JButton("");
		btnPatio2.setContentAreaFilled(false);
		btnPatio2.setBorderPainted(false);
		btnPatio2.setFocusPainted(false);
		btnPatio2.setOpaque(false);
		add(btnPatio2);

		lblPatio2 = new JLabel(new ImageIcon("img\\flecha-der.png"));
		add(lblPatio2);

		imageIcon = new ImageIcon("img\\recepcionR.png");
		lblFondoRecepcion = new JLabel("");
		lblFondoRecepcion.setIcon(imageIcon);
		add(lblFondoRecepcion);

		btnPasillo.addActionListener(e -> switchWithFadeOut(new PasilloView()));

		btnPasillo2.addActionListener(e -> switchWithFadeOut(new Pasillo2View()));

		btnPatio2.addActionListener(e -> switchWithFadeOut(new Patio2View()));

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				int height = getHeight();

				Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				lblFondoRecepcion.setIcon(new ImageIcon(scaledImage));
				lblFondoRecepcion.setBounds(0, 0, width, height);

				btnPasillo.setBounds((int) (width * 0.45), (int) (height * 0.85), 89, 23);
				lblPasillo.setBounds((int) (width * 0.45), (int) (height * 0.85), 102, 37);

				btnPasillo2.setBounds((int) (width * 0.02), (int) (height * 0.47), 54, 130);
				lblPasillo2.setBounds((int) (width * 0.02), (int) (height * 0.47), 65, 136);

				btnPatio2.setBounds((int) (width * 0.78), (int) (height * 0.53), 75, 149);
				lblPatio2.setBounds((int) (width * 0.78), (int) (height * 0.53), 54, 119);
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
		SwingUtilities.invokeLater(() -> new RecepcionView().setVisible(true));
	}
}
