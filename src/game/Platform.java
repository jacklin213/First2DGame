package game;

import java.awt.Color;
import java.awt.Graphics;

public class Platform {

	int speedX, x, y, width, height;
	
	public Platform() {
		speedX = -10;
		x = 300;
		y = 300;
		width = 120;
		height = 40;
	}
	
	public void update(StartingClass instance) {
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
	}
	
}
