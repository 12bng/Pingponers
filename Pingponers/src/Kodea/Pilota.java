package Kodea;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Pilota {

	private double x;
	private double y;
	private Ellipse2D.Double irudia;
	private String bertikal;
	private String horizontal;
	private int j1=0;
	private int j2=0;
	private double abiadura = 2.0;
	
	public Pilota(int pX, int pY) {
		this.x = pX;
		this.y = pY;
		bertikal = "behera";
		horizontal = "eskuina";
	}
	
	public Ellipse2D.Double getPilota() {
		this.irudia = new Ellipse2D.Double(x, y, 20, 20);
		return irudia;
	}
	
	public double getX() {
		return x;
	}
	
	public double getAbiadura() {
		return abiadura;
	}
	
	public void setAbiadura(String mota) {
		if (mota.equals("azkartu")) {
			abiadura = abiadura*2;
		}
		if (mota.equals("moteldu")) {
			abiadura = abiadura/2;
		}
		if (mota.equals("reset")) {
			abiadura = 2;
		}
	}
	
	public double getY() {
		return y;
	}
	public int getJ1Puntuak(){
		return j1;
	}
	public int getJ2Puntuak(){
		return j2;
	}
	public void mugitu() {
		noranzkoaEguneratu();
		if (bertikal.equals("behera")) {
			y = y + abiadura;
		}
		if (bertikal.equals("gora")) {
			y = y - abiadura;
		}
		if (horizontal.equals("ezkerra")) {
			x = x - abiadura;
		}
		if (horizontal.equals("eskuina")) {
			x = x + abiadura;
		}
	}

	private void noranzkoaEguneratu() {
		if (x<=0){
			horizontal = "eskuina";
			j2++;
			abiadura = 2;
			x = 490;
			y = 290;
		}
		if (x>=1000){
			horizontal = "ezkerra";
			j1++;
			abiadura = 2;
			x = 490;
			y = 290;
		}
		if (y<=0){
			bertikal = "behera";
		}
		if (y>=575){
			bertikal = "gora";
		}
	}

	public void eguneratu(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.fill(getPilota());
	}
	public void noranzkoaAldatu() {
		if (horizontal.equals("eskuina")){
			horizontal="ezkerra";
		}
		else if (horizontal.equals("ezkerra")){
			horizontal="eskuina";
		}	
	}
}
