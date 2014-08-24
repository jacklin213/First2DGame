package game;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class StartingClass extends Applet implements Runnable{

	private Image image;
	private Graphics doubleBuffer;
	
	int x = 200;
	int y = 25;
	int radius = 20;
	double speedX = 0;
	double speedY = 0;
	double gravity = 15;
	double energyloss = .65;
	double dt = .2;
	
	@Override
	public void init() {
		setSize(400, 300);
	}
	
	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void stop() {
	
	}
	
	@Override
	public void destroy() {
	
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			doubleBuffer = image.getGraphics();
		}
		
		doubleBuffer.setColor(getBackground());
		doubleBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		doubleBuffer.setColor(getForeground());
		paint(doubleBuffer);
		
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {
		while(true) {
			if (x + speedX > this.getWidth() - radius - 1) { //Checks if ball is touching wall. 1 because of pixal
				x = this.getWidth() - radius - 1; 
				speedX = -speedX; //Makes ball bounce off ball
			} else if (x + speedX < 0 + radius) { 
				x = 0 + radius;
				speedX = -speedX; //Negative negative = positive
			} else {
				x += speedX;
			}
			
			if (y > this.getHeight() - radius - 1) {
				y = this.getHeight() - radius - 1;
				speedY *= energyloss; //Make ball lose some energy. speedY = speedY * energyloss
				speedY = -speedY;
			} else {
				speedY += gravity*dt; //v = u + at
				y += speedY*dt + .5*gravity*dt*dt; // v = ut + 1/2at^2
			}
			
			
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
