package interfazea;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

import Kodea.Paleta;
import Kodea.Pilota;

public class Zelaia extends JPanel implements ActionListener, KeyListener {

	private Pilota pilota;
	private Paleta jokalari1, jokalari2;
	private Graphics2D g2d;
	private String lengoaia;
	private String jokoMota;
	Timer timer;
	
	public Zelaia(String pLengoaia, String pJokoMota) {
		this.setBackground(Color.BLACK);
		lengoaia = pLengoaia;
		jokoMota = pJokoMota;
		pilota = new Pilota(490, 290);
		jokalari1 = new Paleta (25, 0);
		jokalari2 = new Paleta (975,0);
		timer = new Timer(5, this);
		timer.setInitialDelay(100);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		pilota.eguneratu(g2d);
		g2d.setColor(Color.WHITE);
		jokalari1.eguneratu(g2d);
		jokalari2.eguneratu(g2d);
	}
	
	public void eguneratu() {
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.VK_W == e.getKeyCode()) {
			jokalari1.goraMugitu();
		}
		if(e.VK_S == e.getKeyCode()) {
			jokalari1.beheraMugitu();
		}
		if(e.VK_UP == e.getKeyCode()) {
			jokalari2.goraMugitu();
		}
		if(e.VK_DOWN == e.getKeyCode()) {
			jokalari2.beheraMugitu();
		}	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.VK_W == e.getKeyCode()) {
			jokalari1.ezMugitu();
		}
		if(e.VK_S == e.getKeyCode()) {
			jokalari1.ezMugitu();
		}
		if(e.VK_UP == e.getKeyCode()) {
			jokalari2.ezMugitu();
		}
		if(e.VK_DOWN == e.getKeyCode()) {
			jokalari2.ezMugitu();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		pilota.mugitu();
		jokalari1.mugitu();
		jokalari2.mugitu();
		eguneratu();
	}
}
