package enigma2D;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends Canvas{

	private static final long serialVersionUID = -7210508713407496964L;

	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);						// Makes it so the panel isn't like a set grid, but more like a floor.
		frame.add(panel, BorderLayout.SOUTH);       // HELP
		
		TextField inputField = new TextField(20);
		inputField.setBounds(100, 100, 100, 30);
		panel.add(inputField);
		
		JButton button = new JButton("Encrypt");
		button.setBounds(50, 50, 100, 30);
		panel.add(button);
		
		frame.setVisible(true);
		game.start();
	}
}
