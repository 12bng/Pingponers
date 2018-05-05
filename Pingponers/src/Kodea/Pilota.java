package Kodea;

import java.awt.geom.Rectangle2D;

public class Pilota {

	private int x;
	private int y;
	private Rectangle2D.Double irudia;
	
	public Pilota(int pX, int pY) {
		this.x = pX;
		this.y = pY;
		this.irudia = new Rectangle2D.Double(x, y, 20, 20);
	}
	
	public Rectangle2D.Double getPilota() {
		return irudia;
	}
	
	public void mugitu(int altuera,int zabalera) {
		x = x + 1;
		y = y + 1;
	}
	
}
