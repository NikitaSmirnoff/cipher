package enigma2D;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import enigma.EnigmaI;

public class GLetter extends GameObject{
	
	public static final int LEFT = 0;
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	public static final int REFLECTOR = 3;
	public static final int PLUGBOARD = 4;
	
	public int x;
	public int y;
	public int index;
	public int side;
	public int part;
	public String letter;
	public boolean result = false;
	public boolean input = false;
	public boolean output = false;
	public boolean position = false;
	public boolean turnoverNotch = false;
	public Handler handler;
	public EnigmaI enigma;
	public Color resultColor;
	
	public GLetter(int x, int y, int index, int side, int part, ID id, String letter, Handler handler, EnigmaI enigma){
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.index = index;
		this.side = side;
		this.part = part;
		this.letter = letter;
		this.handler = handler;
		this.enigma = enigma;
	}
	
	public void tick(){
		for(int i = 0; i < handler.object.size(); i++){
			GLetter tempObject = (GLetter) handler.object.get(i);
			
			for(int j = 0; j < Game.alphabet.length; j++){
				if(this.side == LEFT && tempObject.getSide() == RIGHT){
					if(this.part == PLUGBOARD && tempObject.getPart() == PLUGBOARD){
						if(this.index == tempObject.index){
							this.letter = enigma.getPlugboard().getConnection(tempObject.getLetter());
						}
					}
				}
			}
		}
		
		if(Game.input.length() > 0){	
			if(this.part == PLUGBOARD){
				if(this.side == RIGHT){
					if(enigma.getInput().equals(letter)){
						result = true;
						input = true;
						output = false;
						resultColor = ColorTheme.selectedBColor;
					} else {
						if(enigma.getResultOfPlugboardBack().equals(letter)){
							result = true;
							input = false;
							output = true;
							resultColor = ColorTheme.selectedAColor;
						} else {
							result = false;
							input = false;
							output = false;
						}
					}
					
				}
				if(this.side == LEFT){
					if(enigma.getResultOfPlugboard().equals(letter)){
						result = true;
						resultColor = ColorTheme.selectedBColor;
					} else {
						if(enigma.getInputOfPlugboardBack().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedAColor;
						} else {
							result = false;
						}
					}
					
				}
			}
			
			if(this.part == LEFT || this.part == MIDDLE || this.part == RIGHT){
				if(enigma.getRotors(this.part).getRotorSetting().equals(letter)){
					position = true;
				} else {
					position = false;
				}
				if(this.side == RIGHT){
					if(this.part == RIGHT){
						if(enigma.getInputOfRotorRight().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedBColor;
						} else {
							if(enigma.getResultOfRotorRightBack().equals(letter)){
								result = true;
								resultColor = ColorTheme.selectedAColor;
							} else {
								result = false;
							}
						}
					}
					if(this.part == MIDDLE){
						if(enigma.getInputOfRotorMiddle().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedBColor;
						} else {
							if(enigma.getResultOfRotorMiddleBack().equals(letter)){
								result = true;
								resultColor = ColorTheme.selectedAColor;
							} else {
								result = false;
							}
						}
					}
					if(this.part == LEFT){
						if(enigma.getInputOfRotorLeft().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedBColor;
						} else {
							if(enigma.getResultOfRotorLeftBack().equals(letter)){
								result = true;
								resultColor = ColorTheme.selectedAColor;
							} else {
								result = false;
							}
						}
					}
				}
				
				if(this.side == LEFT){
					if(this.part == RIGHT){
						if(enigma.getRotors(this.part).getFirstTurnoverNotch().equals(letter)){
							turnoverNotch = true;
						} else {
							turnoverNotch = false;
						}
						if(enigma.getResultOfRotorRight().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedBColor;
						} else {
							if(enigma.getInputOfRotorRightBack().equals(letter)){
								result = true;
								resultColor = ColorTheme.selectedAColor;
							} else {
								result = false;
							}
						}
					}
					if(this.part == MIDDLE){
						if(enigma.getRotors(this.part).getFirstTurnoverNotch().equals(letter)){
							turnoverNotch = true;
						} else {
							turnoverNotch = false;
						}
						if(enigma.getResultOfRotorMiddle().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedBColor;
						} else {
							if(enigma.getInputOfRotorMiddleBack().equals(letter)){
								result = true;
								resultColor = ColorTheme.selectedAColor;
							} else {
								result = false;
							}
						}
					}
					if(this.part == LEFT){
						if(enigma.getResultOfRotorLeft().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedBColor;
						} else {
							if(enigma.getInputOfRotorLeftBack().equals(letter)){
								result = true;
								resultColor = ColorTheme.selectedAColor;
							} else {
								result = false;
							}
						}
					}
				}
			}
			
			if(this.part == REFLECTOR){
				if(this.side == RIGHT){
					if(enigma.getInputOfReflector().equals(letter)){
						result = true;
						resultColor = ColorTheme.selectedBColor;
					} else {
						if(enigma.getResultOfReflector().equals(letter)){
							result = true;
							resultColor = ColorTheme.selectedAColor;
						} else {
							result = false;
						}
					}
				}
			}
		} else {
			if(this.part == LEFT || this.part == MIDDLE || this.part == RIGHT){
				if(enigma.getRotors(this.part).getRotorSetting().equals(letter)){
					position = true;
				} else {
					position = false;
				}
			}
			result = false;
		}
	}
	
	public void render(Graphics g){
//		if(this.part == LEFT){
//			this.y = GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (index - enigma.getRotors(LEFT).getPos(enigma.getRotors(LEFT).getRotorSetting())));
//		} else {
//			if(this.part == MIDDLE){
//				this.y = GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (index - enigma.getRotors(MIDDLE).getPos(enigma.getRotors(MIDDLE).getRotorSetting())));
//			} else {
//				if(this.part == RIGHT){
////					this.index = enigma.getRotors(RIGHT).getPos(enigma.getRotors(RIGHT).getRotorSetting());
//					this.y = GUI.getRotorY() + ((GUI.getRotorHEIGHT() / 26) * (index - enigma.getRotors(RIGHT).getPos(enigma.getRotors(RIGHT).getRotorSetting())));
//				}
//			}
//		}
		
		if(turnoverNotch){
			int[] x = {(this.x - GUI.getLetterBoxWIDTH() * 1 / 2), this.x, this.x};
			int[] y = {(this.y + GUI.getRotorHEIGHT() / 26), (this.y + GUI.getRotorHEIGHT() / 52 * 3), (this.y + GUI.getRotorHEIGHT() / 52)};
			g.setColor(new Color(157, 157, 157));
			g.fillPolygon(x, y, 3);
			g.setColor(Color.BLACK);
			g.drawPolygon(x, y, 3);
		}
		if(result){
			g.setColor(resultColor); 									// Background if the letter is a part of the encryption
			g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
			if(output){
				int[] x = {(this.x + GUI.getLetterBoxWIDTH() * 6 / 5), (this.x + GUI.getLetterBoxWIDTH() * 6 / 5), (this.x + GUI.getLetterBoxWIDTH() * 3 / 2)};
				int[] y = {(this.y + GUI.getRotorHEIGHT() / 26), this.y, (this.y + GUI.getRotorHEIGHT() / 52)};
				g.setColor(ColorTheme.selectedAColor);
				g.fillPolygon(x, y, 3);
				g.setColor(Color.BLACK);
				g.drawPolygon(x, y, 3);
			}
			if(input){
				int[] x = {(this.x + GUI.getLetterBoxWIDTH() * 6 / 5), (this.x + GUI.getLetterBoxWIDTH() * 3 / 2), (this.x + GUI.getLetterBoxWIDTH() * 3 / 2)};
				int[] y = {(this.y + GUI.getRotorHEIGHT() / 52), this.y, (this.y + GUI.getRotorHEIGHT() / 26)};
				g.setColor(ColorTheme.selectedBColor);
				g.fillPolygon(x, y, 3);
				g.setColor(Color.BLACK);
				g.drawPolygon(x, y, 3);
			}
		} else {
			if(position){
				g.setColor(new Color(157, 157, 157)); 					// Background if the letter is the rotor's current position
				g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
			} else {
				g.setColor(ColorTheme.letterColor); 					// Background
				g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
			}
		}
		
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
		g.setColor(Color.BLACK);									// Letter
		g.setFont(new Font("Courier", Font.BOLD,12));
		if(this.side == LEFT){
			g.drawString(this.letter, this.x + ((GUI.getLetterBoxWIDTH() / 10) * 7), this.y + (GUI.getRotorHEIGHT() / 32));
		}
		if(this.side == RIGHT){
			g.drawString(this.letter, this.x + ((GUI.getLetterBoxWIDTH() / 10) * 2), this.y + (GUI.getRotorHEIGHT() / 32));
		}	
		connectLetters(g);
		
	}
	
	private void connectLetters(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		for(int i = 0; i < handler.object.size(); i++){
			GLetter tempObject = (GLetter) handler.object.get(i);
			
			if(Game.input.length() > 0){
				if(tempObject.getID() == ID.Letter){
					if(this.side == RIGHT && tempObject.getSide() == LEFT){
						if(this.part == RIGHT && tempObject.getPart() == RIGHT){
							if((enigma.getInputOfRotorRight().equals(this.letter) && enigma.getResultOfRotorRight().equals(tempObject.getLetter())) 
								|| (enigma.getResultOfRotorRightBack().equals(this.letter) && enigma.getInputOfRotorRightBack().equals(tempObject.getLetter()))){
								drawRotorLine(Color.BLACK, 3, g, tempObject);
							} else {
								if(enigma.getRotors(RIGHT).getConnection(this.letter).equals(tempObject.getLetter())){
									drawRotorLine(ColorTheme.lineColor, 1, g, tempObject);
								}
							}
						}
						if(this.part == MIDDLE && tempObject.getPart() == MIDDLE){
							if((enigma.getInputOfRotorMiddle().equals(this.letter) && enigma.getResultOfRotorMiddle().equals(tempObject.getLetter()))
									|| (enigma.getResultOfRotorMiddleBack().equals(this.letter) && enigma.getInputOfRotorMiddleBack().equals(tempObject.getLetter()))){
								drawRotorLine(Color.BLACK, 3, g, tempObject);
							} else {
								if(enigma.getRotors(MIDDLE).getConnection(this.letter).equals(tempObject.getLetter())){
									drawRotorLine(ColorTheme.lineColor, 1, g, tempObject);
								}
							}
						}
						if(this.part == LEFT && tempObject.getPart() == LEFT){
							if((enigma.getInputOfRotorLeft().equals(this.letter) && enigma.getResultOfRotorLeft().equals(tempObject.getLetter()))
								|| (enigma.getResultOfRotorLeftBack().equals(this.letter) && enigma.getInputOfRotorLeftBack().equals(tempObject.getLetter()))){
								drawRotorLine(Color.BLACK, 3, g, tempObject);
							} else {
								if(enigma.getRotors(LEFT).getConnection(this.letter).equals(tempObject.getLetter())){
									drawRotorLine(ColorTheme.lineColor, 1, g, tempObject);
								}
							}
						}
					}
					if(this.side == RIGHT && tempObject.getSide() == RIGHT){
						if(this.part == REFLECTOR && tempObject.getPart() == REFLECTOR){
							if(enigma.getInputOfReflector().equals(tempObject.getLetter()) && enigma.getResultOfReflector().equals(this.letter)){
								drawReflectorLine(Color.BLACK, 3, g, tempObject);
								drawReflectorLine(ColorTheme.lineColor, 1, g, tempObject);
							} else {
								if(enigma.getReflector().getPos(tempObject.getLetter()) > enigma.getReflector().getPos(this.letter) && enigma.getReflector().getConnection(this.letter).equals(tempObject.getLetter())){
									drawReflectorLine(ColorTheme.lineColor, 1, g, tempObject);
								}
							}
						}
					}
				}
			} else {
				if(tempObject.getID() == ID.Letter){
					if(this.side == RIGHT && tempObject.getSide() == LEFT){
						if(this.part == RIGHT && tempObject.getPart() == RIGHT){
							if(enigma.getRotors(RIGHT).getConnection(this.letter).equals(tempObject.getLetter())){
								drawRotorLine(ColorTheme.lineColor, 1, g, tempObject);
							}
						}
						if(this.part == MIDDLE && tempObject.getPart() == MIDDLE){
							if(enigma.getRotors(MIDDLE).getConnection(this.letter).equals(tempObject.getLetter())){
								drawRotorLine(ColorTheme.lineColor, 1, g, tempObject);
							}
						}
						if(this.part == LEFT && tempObject.getPart() == LEFT){
							if(enigma.getRotors(LEFT).getConnection(this.letter).equals(tempObject.getLetter())){
								drawRotorLine(ColorTheme.lineColor, 1, g, tempObject);
							}
						}
					}
					if(this.side == RIGHT && tempObject.getSide() == RIGHT){
						if(this.part == REFLECTOR && tempObject.getPart() == REFLECTOR){
							if(enigma.getReflector().getPos(tempObject.getLetter()) > enigma.getReflector().getPos(this.letter) && enigma.getReflector().getConnection(this.letter).equals(tempObject.getLetter())){
								drawReflectorLine(ColorTheme.lineColor, 1, g, tempObject);
							}
						}
					}
				}
			}
		}
		
		g2.setStroke(new BasicStroke(1));
	}
	
	public void drawRotorLine(Color color, int thickness, Graphics g, GLetter tempObject){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(thickness));
		g.setColor(color);
		
		g.drawLine(this.x - (GUI.getRotorWIDTH() - (GUI.getLetterBoxWIDTH() * 2)) / 8, this.y + (GUI.getRotorHEIGHT() / 52),
				this.x - (GUI.getRotorWIDTH() - (GUI.getLetterBoxWIDTH() * 2)) / 4, this.y + (GUI.getRotorHEIGHT() / 52));
		g.drawLine(this.x - (GUI.getRotorWIDTH() - (GUI.getLetterBoxWIDTH() * 2)) / 4, this.y + (GUI.getRotorHEIGHT() / 52), 
				tempObject.getX() + GUI.getLetterBoxWIDTH() + (GUI.getRotorWIDTH() - (GUI.getLetterBoxWIDTH() * 2)) / 4, tempObject.getY() + (GUI.getRotorHEIGHT() / 52));
		g.drawLine(tempObject.getX() + GUI.getLetterBoxWIDTH() + (GUI.getRotorWIDTH() - (GUI.getLetterBoxWIDTH() * 2)) / 4, tempObject.getY() + (GUI.getRotorHEIGHT() / 52), 
				tempObject.getX() + GUI.getLetterBoxWIDTH() + (GUI.getRotorWIDTH() - (GUI.getLetterBoxWIDTH() * 2)) / 8, tempObject.getY() + (GUI.getRotorHEIGHT() / 52));
	}
	
	public void drawReflectorLine(Color color, int thickness, Graphics g, GLetter tempObject){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(thickness));
		g.setColor(color);
		
		g.drawLine(this.x - (GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH()) / 26 , this.y + (GUI.getReflectorHEIGHT() / 52),
				this.x - ((GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH()) / 13) * ((enigma.getReflector().getPos(this.letter) % 13) + 1), this.y + (GUI.getReflectorHEIGHT() / 52));
		g.drawLine(this.x - ((GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH()) / 13) * ((enigma.getReflector().getPos(this.letter) % 13) + 1), this.y + (GUI.getReflectorHEIGHT() / 52), 
				tempObject.getX() - ((GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH()) / 13) * ((enigma.getReflector().getPos(this.letter) % 13) + 1), tempObject.getY() + (GUI.getReflectorHEIGHT() / 52));
		g.drawLine(tempObject.getX() - ((GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH()) / 13) * ((enigma.getReflector().getPos(this.letter) % 13) + 1), tempObject.getY() + (GUI.getReflectorHEIGHT() / 52), 
				tempObject.getX() - (GUI.getReflectorWIDTH() - GUI.getLetterBoxWIDTH()) / 26, tempObject.getY() + (GUI.getReflectorHEIGHT() / 52));
	}
	
	public String getLetter(){
		return this.letter;
	}
	
	public void setLetter(String letter){
		this.letter = letter;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getSide() {
		return this.side;
	}

	public int getPart() {
		return this.part;
	}

	public boolean isPosition() {
		return this.position;
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
	}
	
	
}
