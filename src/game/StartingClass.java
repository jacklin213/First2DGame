package game;

import game.entity.Ball;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingClass extends Applet implements Runnable, KeyListener{

	private Image image;
	private Graphics doubleBuffer;
	private Ball ball, badBall;
	private Platform platform;
	
	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);
	}
	
	@Override
	public void start() {
		ball = new Ball();
		badBall = new Ball(400, 50, Color.BLACK);
		platform = new Platform();
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
		platform.paint(g);
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
			platform.update(this);
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		switch(event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			ball.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			ball.moveRight();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}
}
