package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GymView extends JFrame {
	private JLabel lblFondoGym;
	private JButton btnPasillo2;
	private JLabel lblPasillo2;
	private ImageIcon imageIcon;

	public GymView() {
		setTitle("Gym View");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		btnPasillo2 = new JButton("");
		btnPasillo2.setContentAreaFilled(false);
		btnPasillo2.setBorderPainted(false);
		btnPasillo2.setFocusPainted(false);
		btnPasillo2.setOpaque(false);
		add(btnPasillo2);

		lblPasillo2 = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
		add(lblPasillo2);

		imageIcon = new ImageIcon("img\\gimnasioR.jpg");
		lblFondoGym = new JLabel("");
		lblFondoGym.setIcon(imageIcon);
		add(lblFondoGym);

		btnPasillo2.addActionListener(e -> switchWithFadeOut(new Pasillo2View()));

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				int height = getHeight();

				Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				lblFondoGym.setIcon(new ImageIcon(scaledImage));
				lblFondoGym.setBounds(0, 0, width, height);

				btnPasillo2.setBounds((int) (width * 0.42), (int) (height * 0.85), 74, 46);
				lblPasillo2.setBounds((int) (width * 0.42), (int) (height * 0.85), 74, 46);
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
		SwingUtilities.invokeLater(() -> new GymView().setVisible(true));
	}
}
