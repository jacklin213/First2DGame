package game;

import game.entity.Ball;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingClass extends Applet implements Runnable, KeyListener{

	private Image image;
	private Graphics doubleBuffer;
	private Ball ball;
	private Platform platform, platform2;
	
	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);
	}
	
	@Override
	public void start() {
		ball = new Ball();
		platform = new Platform();
		platform2 = new Platform(100, 425);
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
	public void paint(Graphics g) {
		ball.paint(g);
		platform.paint(g);
		platform2.paint(g);
	}
	
	@Override
	public void run() {
		while(true) {
			ball.update(this);
			platform.update(this, ball);
			platform2.update(this, ball);
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
