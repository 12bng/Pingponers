package Kodea;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.concurrent.ThreadLocalRandom;

public class Oztopo {
	private String kolorea; //rojo, blanco o verde
	private int x;
	private int y;
	private Double irudia;
	
	public void randomObstacle() {
		int aux = ThreadLocalRandom.current().nextInt(1, 4);
		if(aux==1) {
			kolorea = "RED";
		}
		if(aux==2) {
			kolorea = "WHITE";
		}
		if(aux==3) {
			kolorea = "GREEN";
		}
		randomPosition();
	}
	private void randomPosition() {
		x = ThreadLocalRandom.current().nextInt(250, 751);
		y = ThreadLocalRandom.current().nextInt(100, 551);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Rectangle2D.Double getOztopoa() {
		this.irudia = new Rectangle2D.Double(x, y, 30, 30);
		return irudia;
	}
	public void eguneratu(Graphics2D g2d) {
		g2d.fill(getOztopoa());
	}
	public String getKolorea() {
		return kolorea;
	}
}
