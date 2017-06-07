package enigma2D;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.image.BufferStrategy;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.SpringLayout;

import enigma.EnigmaI;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 6691247796639148462L;
	
	public static final int LEFT = 0;
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	public static final int REFLECTOR = 3;
	public static final int PLUGBOARD = 4;
	public static final int INCREMENT = 0;
	public static final int DECREMENT = 1;
	
	public static final int WIDTH = 1024, HEIGHT = WIDTH / 12 * 9;
	
	static String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private GUI gui;
	private HUD hud;
	
	private Random r;

	public static String input;
	public static String output;
	public static EnigmaI enigma;
	
	public static void main(String[] args) {
		new Game();
	}
	
//	@Override
//	public Dimension getPreferredSize(){
//		return new Dimension(1024, 600);
//	}
	
	public Game(){
		ColorTheme.changeColorTheme(0);
		handler = new Handler(); // Initialize Handler
		this.addKeyListener(new KeyInput(handler)); // Tell the game to start listening for keys
		
		String[] plugs = {"", "", "", "", "", "", "", "", "", ""};
		enigma = new EnigmaI(plugs, 1, "A", 2, "A", 3, "A", "B");
		
		new Window(WIDTH, HEIGHT, "Engima", this, enigma); // Create the window with WIDTH and HEIGHT and call it Enigma
		
		input = Window.inputField.getText();
		output = "";
		
		enigma.encodePhrase(input);
		
		gui = new GUI();
		r = new Random();
		
		initializeGLetters();
	}
	
	public void initializeGLetters(){
		// Add all letter objects onto the Reflector, Rotors, and Plugboard.
		for(int i = 0; i < 26; i++){
			// Reflector
			handler.addObject(new GLetter(GUI.getReflectorX() + GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getReflectorY() + ((GUI.getReflectorHEIGHT() / 26) * i), i,
					RIGHT, REFLECTOR, ID.Letter, alphabet[i], handler, enigma));
			
			// Plugboard
			handler.addObject(new GLetter(GUI.getPlugboardX(), GUI.getPlugboardY() + ((GUI.getPlugboardHEIGHT() / 26) * i), i,
					LEFT, PLUGBOARD, ID.Letter, enigma.getPlugboard().getPlugboard()[i], handler, enigma));
			handler.addObject(new GLetter(GUI.getPlugboardX() + GUI.getPlugboardWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getPlugboardY() + ((GUI.getPlugboardHEIGHT() / 26) * i), i,
					RIGHT, PLUGBOARD, ID.Letter, alphabet[i], handler, enigma));
		}
		// Left Rotor
		for(int i = enigma.getRotors(LEFT).getPos(enigma.getRotors(LEFT).getRotorSetting());
				i < enigma.getRotors(LEFT).getPos(enigma.getRotors(LEFT).getRotorSetting()) + 26; i++){
			handler.addObject(new GLetter(GUI.getLeftRotorX(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (i - enigma.getRotors(LEFT).getPos(enigma.getRotors(LEFT).getRotorSetting()))), i,
					LEFT, LEFT, ID.Letter, alphabet[i % 26], handler, enigma));
			handler.addObject(new GLetter(GUI.getLeftRotorX() + GUI.getRotorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (i - enigma.getRotors(LEFT).getPos(enigma.getRotors(LEFT).getRotorSetting()))), i,
					RIGHT, LEFT, ID.Letter, alphabet[i % 26], handler, enigma));
			
		}
			// Middle Rotor
		for(int i = enigma.getRotors(MIDDLE).getPos(enigma.getRotors(MIDDLE).getRotorSetting());
				i < enigma.getRotors(MIDDLE).getPos(enigma.getRotors(MIDDLE).getRotorSetting()) + 26; i++){
			handler.addObject(new GLetter(GUI.getMiddleRotorX(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (i - enigma.getRotors(MIDDLE).getPos(enigma.getRotors(MIDDLE).getRotorSetting()))), i,
					LEFT, MIDDLE, ID.Letter, alphabet[i % 26], handler, enigma));
			handler.addObject(new GLetter(GUI.getMiddleRotorX() + GUI.getRotorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (i - enigma.getRotors(MIDDLE).getPos(enigma.getRotors(MIDDLE).getRotorSetting()))), i,
					RIGHT, MIDDLE, ID.Letter, alphabet[i % 26], handler, enigma));
			
		}
			// Right Rotor
		for(int i = enigma.getRotors(RIGHT).getPos(enigma.getRotors(RIGHT).getRotorSetting());
				i < enigma.getRotors(RIGHT).getPos(enigma.getRotors(RIGHT).getRotorSetting()) + 26; i++){
			handler.addObject(new GLetter(GUI.getRightRotorX(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (i - enigma.getRotors(RIGHT).getPos(enigma.getRotors(RIGHT).getRotorSetting()))), i,
					LEFT, RIGHT, ID.Letter, alphabet[i % 26], handler, enigma));
			handler.addObject(new GLetter(GUI.getRightRotorX() + GUI.getRotorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (i - enigma.getRotors(RIGHT).getPos(enigma.getRotors(RIGHT).getRotorSetting()))), i,
					RIGHT, RIGHT, ID.Letter, alphabet[i % 26], handler, enigma));
			
		}
	}

	public void run(){
		this.requestFocus(); // Puts focus on window immediately, so there's no need to click on it initially.
		  long lastTime = System.nanoTime();
		  double amountOfTicks = 60.0;
		  double ns = 1000000000 / amountOfTicks;
		  double delta = 0;
		  long timer = System.currentTimeMillis();
		  int frames = 0;
		  while(running){
			  long now = System.nanoTime();
			  delta += (now - lastTime) / ns;
			  lastTime = now;
			  while(delta >= 1){
				  tick();
				  delta--;
			  }
		      if(running) render();
		      frames++;
		      
		      if(System.currentTimeMillis() - timer > 1000){
		    	  timer += 1000;
//		    	  System.out.println("FPS: " + frames);
		    	  frames = 0;
		      }
		  }
		  stop();
	}
	
	
	
	private void tick() {
		Window.contentPane.setBackground(ColorTheme.backgroundColor);
		
		handler.tick();
		if(gui != null){
			gui.tick();
		}
		
		if(!Window.inputField.getText().equals(input)){						// If text has changed
			if(input.length() > Window.inputField.getText().length()){		// If input has been backspaced
				enigma.updateRotorSettings(DECREMENT);						// Undo the rotor settings
				output = output.substring(0, output.length() - 1);
				
				if(Window.inputField.getText().length() > 0){
					enigma.updateRotorSettings(DECREMENT);
					output = output.substring(0, output.length() - 1);
				}
				if(Window.inputField.getText().length() == 0){
					output = "";
				}
			}
			
			input = Window.inputField.getText();							// Update the input variable
			
			if(input.length() > 0){
				output += enigma.encodeChar(input.substring(input.length() - 1));		// Encode again
			}
			Window.outputField.setText(output);
			updateSettingsLabels();
		}
		
		JTextField[] plugboardFields = {Window.plugboardAField, Window.plugboardBField, Window.plugboardCField, Window.plugboardDField, Window.plugboardEField,
				Window.plugboardFField, Window.plugboardGField, Window.plugboardHField, Window.plugboardIField, Window.plugboardJField};
		for(int i = 0; i < plugboardFields.length; i++){
			if(plugboardFields[i].getText().length() == 2){ 
	            enigma.getPlugboard().setPlugs(plugboardFields[i].getText(), i);
		    }
			if(plugboardFields[i].getText().length() < 2){ 
	            enigma.getPlugboard().undoPlug(enigma.getPlugboard().getPlugs()[i]);
				enigma.getPlugboard().setPlugs("", i);
		    }
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(ColorTheme.backgroundColor); // Background color
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(gui != null){
			gui.render(g);
		}
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void updateSettingsLabels(){
		Window.leftPositionLabel.setText("[ " + enigma.getRotors(LEFT).getRotorSetting() + " ]");
		Window.middlePositionLabel.setText("[ " + enigma.getRotors(MIDDLE).getRotorSetting() + " ]");
		Window.rightPositionLabel.setText("[ " + enigma.getRotors(RIGHT).getRotorSetting() + " ]");
	}
	
	public static int clamp(int var, int min, int max){
		if(var >= max){
			return var = max;
		}else if(var <= min){
			return var = min;
		}else{
			return var;
		}
	}
	
	public static int getRandom(int min, int max){
		return (int) (Math.random() * (max - min) + 1);
	}

}
