package jugarPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrdenadoresView extends JFrame {
	private JLabel lblFondoOrdenadores;
	private JButton btnPasillo;
	private JLabel lblPasillo;
	private ImageIcon imageIcon;
	private JLabel lblFlechaPant;

	public OrdenadoresView() {
		setTitle("Ordenadores View");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnPasillo = new JButton("");
		btnPasillo.setContentAreaFilled(false);
		btnPasillo.setBorderPainted(false);
		btnPasillo.setFocusPainted(false);
		btnPasillo.setOpaque(false);
		getContentPane().add(btnPasillo);

		lblPasillo = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
		getContentPane().add(lblPasillo);
		
		lblFlechaPant = new JLabel("");
		lblFlechaPant.setIcon(new ImageIcon("img\\EXCLAMACION.png"));
		lblFlechaPant.setBounds(317, 206, 97, 75);
		getContentPane().add(lblFlechaPant);
		lblFlechaPant.setVisible(false);
		
		lblFondoOrdenadores = new JLabel("");
		lblFondoOrdenadores.setIcon(new ImageIcon("img\\ordenadoresR.jpg"));
		getContentPane().add(lblFondoOrdenadores);

		JButton btnPantallaView = new JButton("");
		btnPantallaView.setBounds(317, 206, 89, 75);
		getContentPane().add(btnPantallaView);
		btnPantallaView.setContentAreaFilled(false);
		btnPantallaView.setBorderPainted(false);
		btnPantallaView.setFocusPainted(false);
		btnPantallaView.setOpaque(false);
		btnPantallaView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PantallaView().setVisible(true);
				dispose();				
			}
		});
		
		btnPasillo.addActionListener(e -> switchWithFadeOut(new PasilloView()));


		imageIcon = new ImageIcon("img\\ordenadoresR.jpg");

		btnPantallaView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPantallaView.setBounds(317, 206, 89, 75);

				lblFlechaPant.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPantallaView.setBounds(317, 206, 89, 75);
				lblFlechaPant.setVisible(false);

			}
		});

		
		
		btnPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PasilloView().setVisible(true);
				dispose();

			}
		});

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				int height = getHeight();

				Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				lblFondoOrdenadores.setIcon(new ImageIcon(scaledImage));
				lblFondoOrdenadores.setBounds(0, 0, width, height);

				btnPasillo.setBounds((int) (width * 0.48), (int) (height * 0.85), 100, 45);
				lblPasillo.setBounds((int) (width * 0.48), (int) (height * 0.85), 94, 45);
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new OrdenadoresView().setVisible(true));
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
