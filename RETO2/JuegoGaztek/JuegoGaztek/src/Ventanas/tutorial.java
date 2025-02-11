package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class tutorial {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Juego Adaptativo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(0, 0, 46, 14);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel(" ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(220, 137, 235, 89);
        frame.getContentPane().add(lblNewLabel_1);

	}
}
