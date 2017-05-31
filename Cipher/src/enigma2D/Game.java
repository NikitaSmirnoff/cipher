package enigma2D;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.Random;

import enigma.EnigmaI;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 6691247796639148462L;
	
	public static final int LEFT = 0;
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	public static final int REFLECTOR = 3;
	public static final int PLUGBOARD = 4;
	
	public static final int WIDTH = 1024, HEIGHT = WIDTH / 12 * 9;
	
	private String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private GUI gui;
	private HUD hud;
	
	private Random r;
	
	public static EnigmaI enigma;
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game(){
		handler = new Handler(); // Initialize Handler
		this.addKeyListener(new KeyInput(handler)); // Tell the game to start listening for keys
		new Window(WIDTH, HEIGHT, "Engima", this); // Create the window with WIDTH and HEIGHT and call it New Game
		
		String[] plugs = {"AZ", "XY"};
		enigma = new EnigmaI(plugs, 1, "P", 2, "D", 3, "R", "B");
		enigma.encodePhrase("C");
		
		gui = new GUI();
		
		hud = new HUD();
		
		r = new Random();
		
//		handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, handler)); // Add player object to the game
//		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler)); // Add enemy object to the game
		
		// Add all letter objects onto the Reflector, Rotors, and Plugboard.
		for(int i = 0; i < 26; i++){
			// Reflector
			handler.addObject(new GLetter(GUI.getReflectorX() + GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getReflectorY() + ((GUI.getReflectorHEIGHT() / 26) * i),
					RIGHT, REFLECTOR, ID.Letter, alphabet[i], handler, enigma));
			
			// Left Rotor enigma.getRotors(LEFT).getRotorWiring()[i]
			handler.addObject(new GLetter(GUI.getLeftRotorX(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * i),
					LEFT, LEFT, ID.Letter, alphabet[i], handler, enigma));
			handler.addObject(new GLetter(GUI.getLeftRotorX() + GUI.getRotorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * i),
					RIGHT, LEFT, ID.Letter, alphabet[i], handler, enigma));
			
			// Middle Rotor
			handler.addObject(new GLetter(GUI.getMiddleRotorX(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * i),
					LEFT, MIDDLE, ID.Letter, alphabet[i], handler, enigma));
			handler.addObject(new GLetter(GUI.getMiddleRotorX() + GUI.getRotorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * i),
					RIGHT, MIDDLE, ID.Letter, alphabet[i], handler, enigma));
			
			// Right Rotor
			handler.addObject(new GLetter(GUI.getRightRotorX(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * i),
					LEFT, RIGHT, ID.Letter, alphabet[i], handler, enigma));
			handler.addObject(new GLetter(GUI.getRightRotorX() + GUI.getRotorWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * i),
					RIGHT, RIGHT, ID.Letter, alphabet[i], handler, enigma));
			
			// Plugboard
			handler.addObject(new GLetter(GUI.getPlugboardX(), GUI.getPlugboardY() + ((GUI.getPlugboardHEIGHT() / 26) * i),
					LEFT, PLUGBOARD, ID.Letter, enigma.getPlugboard().getPlugboard()[i], handler, enigma));
			handler.addObject(new GLetter(GUI.getPlugboardX() + GUI.getPlugboardWIDTH() - GUI.getLetterBoxWIDTH(), GUI.getPlugboardY() + ((GUI.getPlugboardHEIGHT() / 26) * i),
					RIGHT, PLUGBOARD, ID.Letter, alphabet[i], handler, enigma));
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
		    	  System.out.println("FPS: " + frames);
		    	  frames = 0;
		      }
		  }
		  stop();
	}
	
	
	
	private void tick() {
		handler.tick();
		gui.tick();
		
//		hud.tick();
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(255, 255, 255)); // Background color
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(gui != null){
			gui.render(g);
		}
		handler.render(g);
		
//		hud.render(g);
		
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
