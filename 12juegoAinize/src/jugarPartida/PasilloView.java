package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PasilloView extends JFrame{
	public PasilloView() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 775, 788);
			
		JLabel lblPasillo = new JLabel("");
		lblPasillo.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juego\\img\\pasillo (1).png"));
		lblPasillo.setBounds(0, 0, 768, 762);
		getContentPane().add(lblPasillo);
	}
	
	
	
	
	

}
