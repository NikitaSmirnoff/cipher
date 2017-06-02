package enigma2D;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Window extends Canvas{

	private static final long serialVersionUID = -7210508713407496964L;
	public static JTextField inputField;
	public static JTextField outputField;

	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		SpringLayout layout = new SpringLayout();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(layout);
		contentPane.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));			
		panel.add(game);

		contentPane.add(panel);
		
		inputField = new JTextField("", 60);
		inputField.addKeyListener(new KeyAdapter() {

			  public void keyTyped(KeyEvent e) {
			    char keyChar = e.getKeyChar();
			    if (Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			  }
			  
		});
		outputField = new JTextField("", 60);
//		outputField.setEditable(false);
		contentPane.add(inputField);
		contentPane.add(outputField);
		
		layout.putConstraint(SpringLayout.NORTH, inputField, -80, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, inputField, GUI.ReflectorX, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, outputField, -50, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, outputField, GUI.ReflectorX, SpringLayout.WEST, frame.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, panel, 620, SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());

		
		frame.setVisible(true);
		game.start();
	}
}
