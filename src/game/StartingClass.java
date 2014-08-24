package game;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class StartingClass extends Applet implements Runnable{

	@Override
	public void init() {
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
	
	}
	
	@Override
	public void update(Graphics g) {

	}

	@Override
	public void run() {
		while(true) {
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
