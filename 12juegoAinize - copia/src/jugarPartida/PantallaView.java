package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PantallaView extends JFrame {
	private ImageIcon imageIcon;
	private JLabel lblTextosCruci = new JLabel("");

	public PantallaView() {
		setTitle("Pantalla View");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnAbrirCrucigrama = new JButton("");
		btnAbrirCrucigrama.setBounds(0, 0, 114, 127);
		getContentPane().add(btnAbrirCrucigrama);
		btnAbrirCrucigrama.setContentAreaFilled(false);
		btnAbrirCrucigrama.setBorderPainted(false);
		btnAbrirCrucigrama.setFocusPainted(false);
		btnAbrirCrucigrama.setOpaque(false);

		btnAbrirCrucigrama.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblTextosCruci.setVisible(true);
				new Crucigrama().setVisible(true);

			}
		});

		JLabel lblAbrirCrucigrama = new JLabel("");
		lblAbrirCrucigrama.setIcon(new ImageIcon("img\\logoCrucigrama (1).png"));
		lblAbrirCrucigrama.setBounds(0, 0, 120, 122);
		getContentPane().add(lblAbrirCrucigrama);

		lblTextosCruci.setIcon(new ImageIcon("img\\crucigarma (2).png"));
		lblTextosCruci.setBounds(906, 11, 411, 666);
		getContentPane().add(lblTextosCruci);
		lblTextosCruci.setVisible(false);

		JLabel lblFondoPantalla = new JLabel("");
		lblFondoPantalla.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondoPantalla.setBounds(0, 0, 1366, 714);
		getContentPane().add(lblFondoPantalla);
		imageIcon = new ImageIcon("img\\\\ordLogin.png");
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				int height = getHeight();

				Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				lblFondoPantalla.setIcon(new ImageIcon(scaledImage));
				lblFondoPantalla.setBounds(0, 0, width, height);
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
}
