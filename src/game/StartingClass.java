package game;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class StartingClass extends Applet implements Runnable{

	private Image image;
	private Graphics doubleBuffer;
	
	int x = 0;
	int y = 0;
	int speedX = 1;
	int speedY = 1;
	int radius = 10;
	
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
			x += speedX;
			y += speedY;
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
