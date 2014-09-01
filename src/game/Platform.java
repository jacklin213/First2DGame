package game;

import game.entity.Ball;

import java.awt.Color;
import java.awt.Graphics;

public class Platform {

	int speedX, x, y, width, height;
	
	public Platform() {
		this(300, 300);
	}
	
	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
		speedX = -10;
		width = 120;
		height = 40;
	}
	
	public void update(StartingClass instance, Ball ball) {
		collisionCheck(ball);
	}
	
	private void collisionCheck(Ball ball) {
		int ballX = ball.getX();
		int ballY = ball.getY();
		int radius = ball.getRadius();
		
		if (ballY + radius > y && ballY + radius < y + height) {
			if (ballX > x && ballX < x + width) {
				ball.setY(y - radius);
				ball.setSpeedY(ball.getGameSpeedY());
			}
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
}
