package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JPanel {
	private String message = "El objetivo inmediato de los comunistas es el mismo que el de todos los dem�s partidos proletarios: constituci�n del proletariado como clase, derrocamiento del dominio de la burgues�a, conquista del poder pol�tico por parte del proletariado.";
	private String displayedMessage = "";
	private int messageIndex = 0;
	private Timer timer;
	private List<String> lines = new ArrayList<>();

	private final Color textBoxColor = new Color(255, 255, 255, 220);
	private final Color borderColor = new Color(0, 0, 0);
	private Font customFont;

	public Main() {
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.WHITE);
		loadCustomFont();
		startTextDisplay();
	}

	private void loadCustomFont() {
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("font/MinecraftStandard.otf");
			if (is == null) {
				throw new IOException("No se pudo encontrar la fuente en el classpath.");
			}
			customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(12f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			customFont = new Font("Arial", Font.PLAIN, 16);
		}
	}

	private void startTextDisplay() {
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (messageIndex < message.length()) {
					displayedMessage += message.charAt(messageIndex);
					messageIndex++;
					formatText();
					repaint();
				} else {
					timer.cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 45);
	}

	private void formatText() {
		lines.clear();
		FontMetrics fm = getFontMetrics(customFont);
		int maxWidth = getWidth() - 60;

		String[] words = displayedMessage.split(" ");
		StringBuilder currentLine = new StringBuilder();

		for (String word : words) {
			String testLine = currentLine.length() == 0 ? word : currentLine + " " + word;
			if (fm.stringWidth(testLine) > maxWidth) {
				lines.add(currentLine.toString());
				currentLine = new StringBuilder(word);
			} else {
				currentLine.append(currentLine.length() == 0 ? word : " " + word);
			}
		}
		lines.add(currentLine.toString());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(customFont);
		g.setColor(Color.BLACK);

		int boxHeight = 120;
		int boxWidth = getWidth() - 40;
		int boxX = 20;
		int boxY = getHeight() - boxHeight - 20;

		g.setColor(textBoxColor);
		g.fillRoundRect(boxX, boxY, boxWidth, boxHeight, 30, 30);

		g.setColor(borderColor);
		g.drawRoundRect(boxX, boxY, boxWidth, boxHeight, 30, 30);

		g.setColor(Color.BLACK);
		int textY = boxY + 40;
		for (String line : lines) {
			g.drawString(line, boxX + 20, textY);
			textY += 30;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Texto tipo Pok�mon");
		Main panel = new Main();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
