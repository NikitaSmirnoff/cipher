package enigma2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	
	private Handler handler;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 6;
		velY = 6;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 50){
			velY *= -1;
		}
		if(x <= 0 || x >= Game.WIDTH - 16){
			velX *= -1;
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 8, 8, 0.05f, handler));
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
