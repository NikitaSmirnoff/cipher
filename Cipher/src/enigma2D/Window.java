package enigma2D;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Window extends Canvas{

	private static final long serialVersionUID = -7210508713407496964L;

	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		SpringLayout layout = new SpringLayout();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(layout);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));			
		panel.add(game);

		contentPane.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		
		TextField inputField = new TextField(110);
//		inputField.setBounds(100, 100, 100, 30);
		contentPane.add(inputField);
		layout.putConstraint(SpringLayout.NORTH, inputField, -80, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, inputField, GUI.ReflectorX, SpringLayout.WEST, frame.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, panel, 620, SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());



		
//		JButton button = new JButton("Test");
//		button.setBounds(50, 50, 100, 30);
//		panel.add(button);
		
		frame.setVisible(true);
		game.start();
	}
}
