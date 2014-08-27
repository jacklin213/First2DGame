package game.entity;

import java.awt.Color;
import java.awt.Graphics;

import game.StartingClass;

public class Ball {

	private int x = 200;
	private int y = 25;
	private int radius = 20;
	private double speedX = 0;
	private double speedY = 0;
	private double gravity = 15;
	private double energyloss = 1;
	private double xFriction = .9;
	private double dt = .2;
	private Color color;
	
	public Ball() {
		this(200, 25);
	}
	
	public Ball(int x, int y) {
		this(x, y, Color.GREEN);
	}
	
	public Ball(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void update(StartingClass instance) {
		if (x + speedX > instance.getWidth() - radius - 1) { //Checks if ball is touching wall. 1 because of pixal
			x = instance.getWidth() - radius - 1; 
			speedX = -speedX; //Makes ball bounce off ball
		} else if (x + speedX < 0 + radius) { 
			x = 0 + radius;
			speedX = -speedX; //Negative negative = positive
		} else {
			x += speedX;
		}
		
		if (y == instance.getHeight() - radius - 1) {
			speedX *= xFriction;
			if (Math.abs(speedX) < .8) {
				speedX = 0;
			}
		}
		
		if (y > instance.getHeight() - radius - 1) {
			y = instance.getHeight() - radius - 1;
			speedY *= energyloss; //Make ball lose some energy. speedY = speedY * energyloss
			speedY = -speedY;
		} else {
			speedY += gravity*dt; //v = u + at
			y += speedY*dt + .5*gravity*dt*dt; // v = ut + 1/2at^2
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	public void moveRight() {
		if (speedX + 1 < 20) {
			speedX += 1;
		}
	}
	
	public void moveLeft() {
		if (speedX - 1 > 20) {
			speedX -= 1;
		}
	}
}
