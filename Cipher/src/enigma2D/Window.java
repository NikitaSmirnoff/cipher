package enigma2D;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Arrays;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

import enigma.EnigmaI;

public class Window extends Canvas{
	
	public static final int LEFT = 0;
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	public static final int INCREMENT = 0;
	public static final int DECREMENT = 1;

	private static final long serialVersionUID = -7210508713407496964L;
	public static JFrame frame;
	public static Container contentPane;
	public static SpringLayout layout;
	public static JTextField inputField;
	public static JTextField outputField;
	public static JTextField plugboardAField;
	public static JTextField plugboardBField;
	public static JTextField plugboardCField;
	public static JTextField plugboardDField;
	public static JTextField plugboardEField;
	public static JTextField plugboardFField;
	public static JTextField plugboardGField;
	public static JTextField plugboardHField;
	public static JTextField plugboardIField;
	public static JTextField plugboardJField;
	public static JComboBox leftRotor;
	public static JComboBox middleRotor;
	public static JComboBox rightRotor;
	public static JComboBox reflector;
	public static BasicArrowButton leftPositionButtonEast;
	public static BasicArrowButton leftPositionButtonWest;
	public static BasicArrowButton middlePositionButtonEast;
	public static BasicArrowButton middlePositionButtonWest;
	public static BasicArrowButton rightPositionButtonEast;
	public static BasicArrowButton rightPositionButtonWest;
	public static JLabel leftPositionLabel;
	public static JLabel middlePositionLabel;
	public static JLabel rightPositionLabel;
	
	public static EnigmaI enigma;

	public Window(int width, int height, String title, Game game, EnigmaI enigma){
		this.enigma = enigma;
		
		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		
		layout = new SpringLayout();
		contentPane = frame.getContentPane();
		contentPane.setLayout(layout);
		contentPane.setBackground(new Color(247, 247, 247));
		
		JPanel panel = new JPanel();	//Enigma Window
		panel.setLayout(new GridLayout(1, 1));			
		panel.add(game);

		contentPane.add(panel);
		addLabels();
		addTextFields();
		addComboBoxes();
		addButtons();
		
		layout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, panel, 550, SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		
		frame.setVisible(true);
		game.start();
	}
	
	private static void addButtons(){
		leftPositionButtonEast = new BasicArrowButton(BasicArrowButton.EAST);
		leftPositionButtonWest = new BasicArrowButton(BasicArrowButton.WEST);
		middlePositionButtonEast = new BasicArrowButton(BasicArrowButton.EAST);
		middlePositionButtonWest = new BasicArrowButton(BasicArrowButton.WEST);
		rightPositionButtonEast = new BasicArrowButton(BasicArrowButton.EAST);
		rightPositionButtonWest = new BasicArrowButton(BasicArrowButton.WEST);
		
		contentPane.add(leftPositionButtonEast);
		leftPositionButtonEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action){
				enigma.getRotors(LEFT).incrementRotorSetting();
				leftPositionLabel.setText("[ " + enigma.getRotors(LEFT).getRotorSetting() + " ]");
				reset();
			}
		});
		contentPane.add(leftPositionButtonWest);
		leftPositionButtonWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action){
				enigma.getRotors(LEFT).decrementRotorSetting();
				leftPositionLabel.setText("[ " + enigma.getRotors(LEFT).getRotorSetting() + " ]");
				reset();
			}
		});
		contentPane.add(middlePositionButtonEast);
		middlePositionButtonEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action){
				enigma.getRotors(MIDDLE).incrementRotorSetting();
				middlePositionLabel.setText("[ " + enigma.getRotors(MIDDLE).getRotorSetting() + " ]");
				reset();
			}
		});
		contentPane.add(middlePositionButtonWest);
		middlePositionButtonWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action){
				enigma.getRotors(MIDDLE).decrementRotorSetting();
				middlePositionLabel.setText("[ " + enigma.getRotors(MIDDLE).getRotorSetting() + " ]");
				reset();
			}
		});
		contentPane.add(rightPositionButtonEast);
		rightPositionButtonEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action){
				enigma.getRotors(RIGHT).incrementRotorSetting();
				rightPositionLabel.setText("[ " + enigma.getRotors(RIGHT).getRotorSetting() + " ]");
				reset();
			}
		});
		contentPane.add(rightPositionButtonWest);
		rightPositionButtonWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action){
				enigma.getRotors(RIGHT).decrementRotorSetting();
				rightPositionLabel.setText("[ " + enigma.getRotors(RIGHT).getRotorSetting() + " ]");
				reset();
			}
		});
		
		layout.putConstraint(SpringLayout.NORTH, leftPositionButtonEast, -125, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, leftPositionButtonEast, GUI.LeftRotorX + 158, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, leftPositionButtonWest, -125, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, leftPositionButtonWest, GUI.LeftRotorX + 105, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, middlePositionButtonEast, -125, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, middlePositionButtonEast, GUI.MiddleRotorX + 158, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, middlePositionButtonWest, -125, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, middlePositionButtonWest, GUI.MiddleRotorX + 105, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, rightPositionButtonEast, -125, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, rightPositionButtonEast, GUI.RightRotorX + 158, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, rightPositionButtonWest, -125, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, rightPositionButtonWest, GUI.RightRotorX + 105, SpringLayout.WEST, frame.getContentPane());
		
	}
	
	private static void addComboBoxes(){
		String[] rotorRomanNumerals = {"   I ", "   II ", "   III ", "   IV ", "   V "};
		String[] reflectors = {"   UKW-A   ", "   UKW-B   ", "   UKW-C   "};
		leftRotor = new JComboBox(rotorRomanNumerals);
		middleRotor = new JComboBox(rotorRomanNumerals);
		rightRotor = new JComboBox(rotorRomanNumerals);
		reflector = new JComboBox(reflectors);
		
		contentPane.add(leftRotor);
		contentPane.add(middleRotor);
		contentPane.add(rightRotor);
		contentPane.add(reflector);
		
		layout.putConstraint(SpringLayout.NORTH, leftRotor, -130, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, leftRotor, GUI.LeftRotorX + 20, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, middleRotor, -130, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, middleRotor, GUI.MiddleRotorX + 20, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, rightRotor, -130, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, rightRotor, GUI.RightRotorX + 20, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, reflector, -130, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, reflector, GUI.ReflectorX + 20, SpringLayout.WEST, frame.getContentPane());
		
//		removeButton(leftRotor);
//		removeButton(middleRotor);
//		removeButton(rightRotor);
//		leftRotor.setBackground(new Color(247, 247, 247));
//		middleRotor.setBackground(new Color(247, 247, 247));
//		rightRotor.setBackground(new Color(247, 247, 247));
	}
	
	private static void addTextFields(){
		inputField = new JTextField("", 60);
		inputField.addKeyListener(new KeyAdapter() {

			  public void keyTyped(KeyEvent e) {
			    char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)) {
			      e.setKeyChar(Character.toUpperCase(keyChar));
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			  }
			  
		});
		outputField = new JTextField("", 60);
		outputField.setEditable(false);
		
		contentPane.add(inputField);
		contentPane.add(outputField);
		
		layout.putConstraint(SpringLayout.NORTH, inputField, -80, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, inputField, GUI.ReflectorX + 50, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, outputField, -50, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, outputField, GUI.ReflectorX + 50, SpringLayout.WEST, frame.getContentPane());
		
		plugboardAField = new JTextField(enigma.getPlugboard().getPlugs()[0], 2);
		plugboardBField = new JTextField(enigma.getPlugboard().getPlugs()[1], 2);
		plugboardCField = new JTextField(enigma.getPlugboard().getPlugs()[2], 2);
		plugboardDField = new JTextField(enigma.getPlugboard().getPlugs()[3], 2);
		plugboardEField = new JTextField(enigma.getPlugboard().getPlugs()[4], 2);
		plugboardFField = new JTextField(enigma.getPlugboard().getPlugs()[5], 2);
		plugboardGField = new JTextField(enigma.getPlugboard().getPlugs()[6], 2);
		plugboardHField = new JTextField(enigma.getPlugboard().getPlugs()[7], 2);
		plugboardIField = new JTextField(enigma.getPlugboard().getPlugs()[8], 2);
		plugboardJField = new JTextField(enigma.getPlugboard().getPlugs()[9], 2);
		
		JTextField[] plugboardFields = {plugboardAField, plugboardBField, plugboardCField, plugboardDField, plugboardEField,
				plugboardFField, plugboardGField, plugboardHField, plugboardIField, plugboardJField};
		
		for(int i = 0; i < plugboardFields.length; i++){
			
			contentPane.add(plugboardFields[i]);
			layout.putConstraint(SpringLayout.NORTH, plugboardFields[i], -135 + (i / 5 * 30), SpringLayout.SOUTH, frame.getContentPane());
			layout.putConstraint(SpringLayout.WEST, plugboardFields[i], GUI.PlugboardX - 20 + ((i % 5)* 28), SpringLayout.WEST, frame.getContentPane());
		}
		
		plugboardAField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardAField.getText().length() >= 2 ){
		            e.consume();
			    }
			}
		});
		plugboardBField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardBField.getText().length() >= 2 ){ 
		            e.consume();
			    }
			}	  
		});
		plugboardCField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardCField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		plugboardDField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardDField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		plugboardEField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardEField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		plugboardFField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardFField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		plugboardGField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardGField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		plugboardHField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardHField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		plugboardIField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardIField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		plugboardJField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
			    if(Character.isLowerCase(keyChar)){
			        e.setKeyChar(Character.toUpperCase(keyChar));
			        Window.reset();
			    }
			    if(!Character.isAlphabetic(keyChar)){
			    	e.setKeyChar('\u0000');
			    }
			    if(plugboardJField.getText().length() >= 2 ){
		            e.consume();
			    }
			}	  
		});
		
//		layout.putConstraint(SpringLayout.NORTH, plugboardAField, -130, SpringLayout.SOUTH, frame.getContentPane());
//		layout.putConstraint(SpringLayout.WEST, plugboardAField, GUI.PlugboardX, SpringLayout.WEST, frame.getContentPane());
	}
	
	private static void addLabels(){
		JLabel inputFieldLabel = new JLabel("Input: ");
		JLabel outputFieldLabel = new JLabel("Output: ");
		JLabel leftRotorLabel = new JLabel("Left Rotor");
		JLabel middleRotorLabel = new JLabel("Middle Rotor");
		JLabel rightRotorLabel = new JLabel("Right Rotor");
		JLabel leftSettingLabel = new JLabel("Setting");
		JLabel middleSettingLabel = new JLabel("Setting");
		JLabel rightSettingLabel = new JLabel("Setting");
		JLabel reflectorLabel = new JLabel("Reflector");
		JLabel plugboardLabel = new JLabel("Plugboard");
		
		contentPane.add(inputFieldLabel);
		contentPane.add(outputFieldLabel);
		contentPane.add(leftRotorLabel);
		contentPane.add(middleRotorLabel);
		contentPane.add(rightRotorLabel);
		contentPane.add(leftSettingLabel);
		contentPane.add(middleSettingLabel);
		contentPane.add(rightSettingLabel);
		contentPane.add(reflectorLabel);
		contentPane.add(plugboardLabel);
		
		layout.putConstraint(SpringLayout.NORTH, inputFieldLabel, -80, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, inputFieldLabel, GUI.ReflectorX, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, outputFieldLabel, -50, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, outputFieldLabel, GUI.ReflectorX - 1, SpringLayout.WEST, frame.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, leftRotorLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, leftRotorLabel, GUI.LeftRotorX + 18, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, middleRotorLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, middleRotorLabel, GUI.MiddleRotorX + 12, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, rightRotorLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, rightRotorLabel, GUI.RightRotorX + 15, SpringLayout.WEST, frame.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, leftSettingLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, leftSettingLabel, GUI.LeftRotorX + 120, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, middleSettingLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, middleSettingLabel, GUI.MiddleRotorX + 120, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, rightSettingLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, rightSettingLabel, GUI.RightRotorX + 120, SpringLayout.WEST, frame.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, reflectorLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, reflectorLabel, GUI.ReflectorX + 35, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, plugboardLabel, -160, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, plugboardLabel, GUI.PlugboardX + 20, SpringLayout.WEST, frame.getContentPane());
		
		leftPositionLabel = new JLabel("[ " + enigma.getRotors(LEFT).getRotorSetting() + " ]");
		middlePositionLabel = new JLabel("[ " + enigma.getRotors(MIDDLE).getRotorSetting() + " ]");
		rightPositionLabel = new JLabel("[ " + enigma.getRotors(RIGHT).getRotorSetting() + " ]");
		
		contentPane.add(leftPositionLabel);
		contentPane.add(middlePositionLabel);
		contentPane.add(rightPositionLabel);
		
		layout.putConstraint(SpringLayout.NORTH, leftPositionLabel, -126, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, leftPositionLabel, GUI.LeftRotorX + 130, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, middlePositionLabel, -126, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, middlePositionLabel, GUI.MiddleRotorX + 130, SpringLayout.WEST, frame.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, rightPositionLabel, -126, SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, rightPositionLabel, GUI.RightRotorX + 130, SpringLayout.WEST, frame.getContentPane());
	}
	
	private static void removeButton(Container container) {
	      Component[] components = container.getComponents();
	      for (Component component : components) {
	         if (component instanceof AbstractButton) {
	            container.remove(component);
	         }
	     }
	}
	
	static void reset(){
		if(inputField.getText().length() > 0){
			enigma.updateRotorSettings(INCREMENT);
		}
		inputField.setText("");
	}
}
