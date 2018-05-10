package Kodea;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Paleta {

	private int x;
	private int y;
	private Rectangle2D.Double irudia;
	private String noranzkoa;
	
	public Paleta(int pX, int pY) {
		this.x = pX;
		this.y = pY;
		noranzkoa = "Geldirik";
	}
	
	public void goraMugitu() {
		noranzkoa = "Gora";
	}
	
	public void beheraMugitu() {
		noranzkoa = "Behera";
	}
	
	public void ezMugitu() {
		noranzkoa = "Geldirik";
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Rectangle2D.Double getPaleta() {
		this.irudia = new Rectangle2D.Double(x, y, 15, 130);
		return irudia;
	}

	public void eguneratu(Graphics2D g2d) {
		g2d.fill(getPaleta());
	}

	public void mugitu() {
		// TODO Auto-generated method stub
		if ((y>0)&&(noranzkoa.equals("Gora"))) {
			y=y-3;
		}
		if ((y<600 - 140)&&(noranzkoa.equals("Behera"))) {
			y=y+3;
		}
	}
	public void IAeasy() {
		if (y<=0) {
			beheraMugitu();
		}
		if(y>=460) {
			goraMugitu();
		}
		mugitu();
	}
	public void IAhard(int pilotaPos) {
		if(pilotaPos>460) {
			y = 460;
		}
		else{y = pilotaPos-10;}
	}
}
