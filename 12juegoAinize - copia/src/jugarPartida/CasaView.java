package jugarPartida;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Toolkit;

public class CasaView extends JFrame {

    private JLabel lblDesenlace;
    private ImageIcon imageIcon;
    public StringBuilder contrasena = new StringBuilder(); // Almacena la contraseña introducida
    public final String CONTRASENA_CORRECTA = "250909";
    private JLabel lblFondoCasa;

    public CasaView() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximiza la ventana
        setLocation(0,0);  // Mueve la ventana a (100, 100)
        getContentPane().setLayout(null);

        JButton btnPatio2 = new JButton("");
        btnPatio2.setBounds(10, 260, 67, 64);
        getContentPane().add(btnPatio2);
        btnPatio2.setContentAreaFilled(false); // Fondo transparente
        btnPatio2.setBorderPainted(false); // Sin bordes
        btnPatio2.setFocusPainted(false); // Sin indicadores de enfoque
        btnPatio2.setOpaque(false);

        btnPatio2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Patio2View().setVisible(true);
                dispose();
            }
        });

        JLabel lblPatio2 = new JLabel("");
        lblPatio2.setBounds(10, 260, 67, 64);
        lblPatio2.setIcon(new ImageIcon("D:\\Ainize\\02Programacion\\12juegoAinize\\img\\flecha-izq.png"));
        getContentPane().add(lblPatio2);

        lblDesenlace = new JLabel("");
        lblDesenlace.setBounds(267, 166, 197, 23);
        lblDesenlace.setHorizontalAlignment(SwingConstants.CENTER);
        lblDesenlace.setForeground(Color.WHITE);
        getContentPane().add(lblDesenlace);
        lblDesenlace.setVisible(false);

       
        JButton btnCajon = new JButton("");
        btnCajon.setBounds(100, 558, 105, 75);
        getContentPane().add(btnCajon);
        btnCajon.setVisible(false);
        btnCajon.setContentAreaFilled(false); // Fondo transparente
        btnCajon.setBorderPainted(false); // Sin bordes
        btnCajon.setFocusPainted(false); // Sin indicadores de enfoque
        btnCajon.setOpaque(false);

        JButton btn1 = new JButton("");
        btn1.setBounds(267, 213, 45, 44);
        btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn1);
        btn1.setContentAreaFilled(false); // Fondo transparente
        btn1.setBorderPainted(false); // Sin bordes
        btn1.setOpaque(false);

        JButton btn2 = new JButton("");
        btn2.setBounds(347, 213, 45, 44);
        btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn2);
        btn2.setContentAreaFilled(false); // Fondo transparente
        btn2.setBorderPainted(false); // Sin bordes
        btn2.setOpaque(false);
        
        JButton btn3 = new JButton("");
        btn3.setBounds(426, 213, 45, 44);
        btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn3);
        btn3.setContentAreaFilled(false); // Fondo transparente
        btn3.setBorderPainted(false); // Sin bordes
        btn3.setOpaque(false);
        
        JButton btn4 = new JButton("");
        btn4.setBounds(267, 284, 45, 44);
        btn4.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn4);
        btn4.setContentAreaFilled(false); // Fondo transparente
        btn4.setBorderPainted(false); // Sin bordes
        btn4.setOpaque(false);

        JButton btn5 = new JButton("");
        btn5.setBounds(347, 284, 45, 44);
        btn5.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn5);
        btn5.setContentAreaFilled(false); // Fondo transparente
        btn5.setBorderPainted(false); // Sin bordes
        btn5.setOpaque(false);
        
        JButton btn6 = new JButton("");
        btn6.setBounds(426, 284, 45, 44);
        btn6.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn6);
        btn6.setContentAreaFilled(false); // Fondo transparente
        btn6.setBorderPainted(false); // Sin bordes
        btn6.setOpaque(false);
        
        JButton btn7 = new JButton("");
        btn7.setBounds(267, 355, 45, 44);
        btn7.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn7);
        btn7.setContentAreaFilled(false); // Fondo transparente
        btn7.setBorderPainted(false); // Sin bordes
        btn7.setOpaque(false);
        
        JButton btn8 = new JButton("");
        btn8.setBounds(347, 355, 45, 44);
        btn8.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn8);
        btn8.setContentAreaFilled(false); // Fondo transparente
        btn8.setBorderPainted(false); // Sin bordes
        btn8.setOpaque(false);
        
        JButton btn9 = new JButton("");
        btn9.setBounds(426, 357, 45, 44);
        btn9.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn9);
        btn9.setContentAreaFilled(false); // Fondo transparente
        btn9.setBorderPainted(false); // Sin bordes
        btn9.setOpaque(false);
        
        JButton btn0 = new JButton("");
        btn0.setBounds(347, 426, 45, 44);
        btn0.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(btn0);
        btn0.setContentAreaFilled(false); // Fondo transparente
        btn0.setBorderPainted(false); // Sin bordes
        btn0.setOpaque(false);
        
		JLabel lblMovil = new JLabel("");
		lblMovil.setBounds(194, 40, 405, 549);
		lblMovil.setIcon(new ImageIcon("img\\movilDesbloqueo.png"));
		getContentPane().add(lblMovil);
		lblMovil.setVisible(false);

        btnCajon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblMovil.setVisible(true);
                btn1.setVisible(true);
                btn2.setVisible(true);
                btn3.setVisible(true);
                btn4.setVisible(true);
                btn5.setVisible(true);
                btn6.setVisible(true);
                btn7.setVisible(true);
                btn8.setVisible(true);
                btn9.setVisible(true);
                btn0.setVisible(true);
            }
        });

        JLabel lblTarjetaGym = new JLabel("");
        lblTarjetaGym.setBounds(889, 0, 473, 288);
        lblTarjetaGym.setIcon(new ImageIcon(
                "img\\tarjetaGym (1) (1).png"));
        getContentPane().add(lblTarjetaGym);
        lblTarjetaGym.setVisible(false);

        JButton btnMochila = new JButton("");
        btnMochila.setBounds(698, 650, 67, 64);
        getContentPane().add(btnMochila);
        btnMochila.setContentAreaFilled(false); // Fondo transparente
        btnMochila.setBorderPainted(false); // Sin bordes
        btnMochila.setFocusPainted(false); // Sin indicadores de enfoque
        btnMochila.setOpaque(false);

        btnMochila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblTarjetaGym.setVisible(true);
                btnCajon.setVisible(true);
            }
        });

        setupPasswordButton(btn0, "0");
        setupPasswordButton(btn1, "1");
        setupPasswordButton(btn2, "2");
        setupPasswordButton(btn3, "3");
        setupPasswordButton(btn4, "4");
        setupPasswordButton(btn5, "5");
        setupPasswordButton(btn6, "6");
        setupPasswordButton(btn7, "7");
        setupPasswordButton(btn8, "8");
        setupPasswordButton(btn9, "9");

        // Crear el JLabel para la imagen de fondo
        lblFondoCasa = new JLabel("");
        lblFondoCasa.setBounds(0, 0, 676, 415);
        lblFondoCasa.setIcon(new ImageIcon("img\\habitacionJ.png"));
        getContentPane().add(lblFondoCasa);

        // Agregar un oyente para ajustar la imagen cuando cambie el tamaño de la ventana
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                lblFondoCasa.setBounds(0, 0, getWidth(), getHeight());
                Image scaledImage = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                lblFondoCasa.setIcon(new ImageIcon(scaledImage)); // Actualizar el icono del fondo
                lblFondoCasa.setBounds(0, 0, getWidth(), getHeight()); 
                
                
            }
        });
    }

    private void setupPasswordButton(JButton button, String value) {
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contrasena.append(value);
                checkPassword();
            }
        });
    }

    private void checkPassword() {
        if (contrasena.length() == 6) {
            lblDesenlace.setVisible(true); // Mostrar el desenlace
            if (contrasena.toString().equals(CONTRASENA_CORRECTA)) {
                lblDesenlace.setText("¡Contraseña correcta!");
            } else {
                lblDesenlace.setText("Contraseña incorrecta");
                contrasena.setLength(0);
                lblDesenlace.setText("Vuelve a intentarlo");// Restablece la entrada
            }
        }
    }
}
