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
        "¿Qué harías si ves a alguien siendo víctima de bullying?",
        "¿Cómo puedes apoyar a un amigo que sufre bullying?",
        "¿Qué debes hacer si eres víctima de bullying?",
        "Si eres testigo de bullying, ¿cómo reaccionas?",
        "El bullying se puede presentar en qué formas?",
        "¿Cómo se siente una persona víctima de bullying?",
        "¿El bullying solo ocurre en la escuela?",
        "¿Qué tipo de bullying es el más dañino?",
        "¿Cuál es la primera acción que debes tomar si alguien te amenaza?",
        "¿Cómo puedes evitar el bullying en tu entorno?",
        "El bullying nunca es...",
        "¿Cómo puedes ayudar a que se detenga el bullying?",
        "¿Qué debe hacer una persona que ve bullying pero no sabe qué hacer?",
        "¿El bullying puede tener consecuencias físicas y emocionales?",
        "¿Cómo pueden los adultos ayudar a frenar el bullying?",
        "¿Por qué es importante hablar sobre el bullying?"
    };
    
    private String[][] opciones = {
        {"Ignorar", "Ayudar a la víctima", "Ponerme a reír", "Unirme al agresor"},
        {"Escuchar y dar apoyo", "Ignorar", "Reirse", "Hacer lo mismo que el agresor"},
        {"Hablar con un adulto", "Afrontarlo directamente", "Pedir ayuda", "Esconderse"},
        {"Denunciarlo", "Permanecer callado", "Agredir al agresor", "Hacer como que no pasa nada"},
        {"Físico, psicológico, cibernético", "Solo físico", "Solo psicológico", "Solo cibernético"},
        {"Confusión, tristeza, miedo", "Felicidad", "Satisfacción", "Indiferencia"},
        {"No", "Sí", "En línea y fuera de la escuela", "Solo en la escuela"},
        {"El físico", "El psicológico", "El verbal", "El cibernético"},
        {"Hablar con un adulto", "Pedir ayuda a un amigo", "Afrontarlo solo", "No hacer nada"},
        {"Ser respetuoso y hablar", "Reírse", "Unirse al agresor", "Hacer bullying también"},
        {"Aceptable", "Inaceptable", "Divertido", "Natural"},
        {"Hablar con un adulto", "Ignorar", "Hacer lo mismo", "Unirse al agresor"},
        {"Hablar con un amigo", "Contarlo a un adulto", "Callarse", "Pedir ayuda en línea"},
        {"Sí", "No", "Solo emocionales", "Solo físicos"},
        {"Denunciarlo", "Ayudar a las víctimas", "Ignorar", "Reírse"},
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
        // Aquí verificamos la respuesta correcta para cada prueba
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
            JOptionPane.showMessageDialog(this, "Juego terminado. Puntuación final: " + puntuacion);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new JuegoBullying();
    }
}
