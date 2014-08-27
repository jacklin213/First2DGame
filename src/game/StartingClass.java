package game;

import game.entity.Ball;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class StartingClass extends Applet implements Runnable{

	private Image image;
	private Graphics doubleBuffer;
	private Ball ball, badBall;
	
	@Override
	public void init() {
		setSize(400, 300);
	}
	
	@Override
	public void start() {
		ball = new Ball();
		badBall = new Ball(400, 50, Color.BLACK);
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
		ball.paint(g);
		badBall.paint(g);
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
			ball.update(this);
			badBall.update(this);
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
