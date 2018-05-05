package interfazea;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Kodea.Pilota;

public class Zelaia extends JPanel {

	Pilota pilota = new Pilota(0, 0);
	
	public Zelaia() {
		this.setBackground(Color.BLACK);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		kokatu(g2d);
		eguneratu();
	}
	public void kokatu(Graphics2D g) {
		g.fill(pilota.getPilota());
	}
	public void eguneratu() {
		pilota.mugitu(this.getHeight(),this.getWidth());
	}
}
