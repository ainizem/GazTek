package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoBullying extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pruebaActual = 0;
    private int puntuacion = 0;
    private JLabel preguntaLabel;
    private JButton opcion1, opcion2, opcion3, opcion4;
    private String[] preguntas = {
        "�Qu� har�as si ves a alguien siendo v�ctima de bullying?",
        "�C�mo puedes apoyar a un amigo que sufre bullying?",
        "�Qu� debes hacer si eres v�ctima de bullying?",
        "Si eres testigo de bullying, �c�mo reaccionas?",
        "El bullying se puede presentar en qu� formas?",
        "�C�mo se siente una persona v�ctima de bullying?",
        "�El bullying solo ocurre en la escuela?",
        "�Qu� tipo de bullying es el m�s da�ino?",
        "�Cu�l es la primera acci�n que debes tomar si alguien te amenaza?",
        "�C�mo puedes evitar el bullying en tu entorno?",
        "El bullying nunca es...",
        "�C�mo puedes ayudar a que se detenga el bullying?",
        "�Qu� debe hacer una persona que ve bullying pero no sabe qu� hacer?",
        "�El bullying puede tener consecuencias f�sicas y emocionales?",
        "�C�mo pueden los adultos ayudar a frenar el bullying?",
        "�Por qu� es importante hablar sobre el bullying?"
    };
    
    private String[][] opciones = {
        {"Ignorar", "Ayudar a la v�ctima", "Ponerme a re�r", "Unirme al agresor"},
        {"Escuchar y dar apoyo", "Ignorar", "Reirse", "Hacer lo mismo que el agresor"},
        {"Hablar con un adulto", "Afrontarlo directamente", "Pedir ayuda", "Esconderse"},
        {"Denunciarlo", "Permanecer callado", "Agredir al agresor", "Hacer como que no pasa nada"},
        {"F�sico, psicol�gico, cibern�tico", "Solo f�sico", "Solo psicol�gico", "Solo cibern�tico"},
        {"Confusi�n, tristeza, miedo", "Felicidad", "Satisfacci�n", "Indiferencia"},
        {"No", "S�", "En l�nea y fuera de la escuela", "Solo en la escuela"},
        {"El f�sico", "El psicol�gico", "El verbal", "El cibern�tico"},
        {"Hablar con un adulto", "Pedir ayuda a un amigo", "Afrontarlo solo", "No hacer nada"},
        {"Ser respetuoso y hablar", "Re�rse", "Unirse al agresor", "Hacer bullying tambi�n"},
        {"Aceptable", "Inaceptable", "Divertido", "Natural"},
        {"Hablar con un adulto", "Ignorar", "Hacer lo mismo", "Unirse al agresor"},
        {"Hablar con un amigo", "Contarlo a un adulto", "Callarse", "Pedir ayuda en l�nea"},
        {"S�", "No", "Solo emocionales", "Solo f�sicos"},
        {"Denunciarlo", "Ayudar a las v�ctimas", "Ignorar", "Re�rse"},
        {"Para hacer conciencia y actuar"}
    };

    public JuegoBullying() {
        setTitle("Juego sobre Bullying");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        
        preguntaLabel = new JLabel(preguntas[pruebaActual]);
        add(preguntaLabel);
        
        opcion1 = new JButton(opciones[pruebaActual][0]);
        opcion2 = new JButton(opciones[pruebaActual][1]);
        opcion3 = new JButton(opciones[pruebaActual][2]);
        opcion4 = new JButton(opciones[pruebaActual][3]);
        
        add(opcion1);
        add(opcion2);
        add(opcion3);
        add(opcion4);
        
        opcion1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta(0);
            }
        });
        opcion2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta(1);
            }
        });
        opcion3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta(2);
            }
        });
        opcion4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta(3);
            }
        });
        
        setVisible(true);
    }
    
    private void verificarRespuesta(int opcionElegida) {
        // Aqu� verificamos la respuesta correcta para cada prueba
        if (opcionElegida == 1) {
            puntuacion++;
        }
        
        pruebaActual++;
        
        if (pruebaActual < preguntas.length) {
            preguntaLabel.setText(preguntas[pruebaActual]);
            opcion1.setText(opciones[pruebaActual][0]);
            opcion2.setText(opciones[pruebaActual][1]);
            opcion3.setText(opciones[pruebaActual][2]);
            opcion4.setText(opciones[pruebaActual][3]);
        } else {
            JOptionPane.showMessageDialog(this, "Juego terminado. Puntuaci�n final: " + puntuacion);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new JuegoBullying();
    }
}
