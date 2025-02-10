package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AulaView extends JFrame {
    private JLabel lblFondoAula;
    private JButton btnPasillo1;
    private ImageIcon imageIcon;

    public AulaView() {
        setTitle("Aula View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setLayout(null);

        imageIcon = new ImageIcon("img\\claseR.jpg");

        btnPasillo1 = new JButton("");
        btnPasillo1.setContentAreaFilled(false);
        btnPasillo1.setBorderPainted(false);
        btnPasillo1.setFocusPainted(false);
        btnPasillo1.setOpaque(false);
        add(btnPasillo1);

        JLabel lblPasillo1 = new JLabel(new ImageIcon("img\\flecha-abajo.png"));
        add(lblPasillo1);

        lblFondoAula = new JLabel("");
        add(lblFondoAula);

        btnPasillo1.addActionListener(e -> switchWithFadeOut(new PasilloView()));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();
                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblFondoAula.setIcon(new ImageIcon(scaledImage));
                lblFondoAula.setBounds(0, 0, width, height);

                btnPasillo1.setBounds((int) (width * 0.35), height - 80, 89, 23);
                lblPasillo1.setBounds((int) (width * 0.35), height - 80, 91, 35);
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
        SwingUtilities.invokeLater(() -> new AulaView().setVisible(true));
    }
}
