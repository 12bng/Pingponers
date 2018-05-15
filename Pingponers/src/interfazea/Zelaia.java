package interfazea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Kodea.Main;
import Kodea.Oztopo;
import Kodea.Paleta;
import Kodea.Pilota;

public class Zelaia extends JPanel implements ActionListener, KeyListener {

	private Pilota pilota;
	private Paleta jokalari1, jokalari2;
	private Graphics2D g2d;
	private String lengoaia;
	private String jokoMota;
	private Image img = null;
	Timer timer;
	private JButton ranking;
	private boolean amaituta = false;
	
	public Zelaia(String pLengoaia, String pJokoMota) {
		this.setBackground(Color.BLACK);
		lengoaia = pLengoaia;
		jokoMota = pJokoMota;
		pilota = new Pilota(490, 290);
		jokalari1 = new Paleta (30, 0); //(25, 0)
		jokalari2 = new Paleta (970,460); //(975,0)
		timer = new Timer(5, this);
		timer.setInitialDelay(100);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        ranking = new JButton("Ranking");
        ranking.setBounds(500, 300, 50, 50);
        ranking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ranking.main(null);
			}
		});
        this.add(ranking);
        ranking.setVisible(false);
        ranking.setEnabled(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		pilota.eguneratu(g2d);
		g2d.setColor(Color.WHITE);
		g2d.fill(new Rectangle2D.Double(510, 0, 5, 600));
		jokalari1.eguneratu(g2d);
		jokalari2.eguneratu(g2d);
		
		//comprobar las posiciones, las paletas son de 130
		if((pilota.getX()-10)<=jokalari1.getX()) {
			if(pilota.getY()>=jokalari1.getY()&&pilota.getY()<=(jokalari1.getY()+130)) {
				pilota.noranzkoaAldatu();
			}
		}
		if((pilota.getX()+10)>=jokalari2.getX()) {
			if(pilota.getY()>=jokalari2.getY()&&pilota.getY()<=(jokalari2.getY()+130)) {
				pilota.noranzkoaAldatu();
			}
		}
		
		//comprobar si toca un oztopo
		Oztopo[] nireoztopoak = Main.getMain().getOztopoak();
		for (int i=0;i<3;i++) {
			if(!(nireoztopoak[i]==null)) {
				if((pilota.getX()<=nireoztopoak[i].getX()+30)&&(pilota.getX()+10>=nireoztopoak[i].getX())){
					if(pilota.getY()+10>=nireoztopoak[i].getY()&&pilota.getY()<=(nireoztopoak[i].getY()+30)) {
						String kolorea = nireoztopoak[i].getKolorea();
						if (kolorea.equals("WHITE")) {
							pilota.noranzkoaAldatu();
							pilota.setAbiadura("reset");
						}
						else if (kolorea.equals("GREEN")) {
							pilota.setAbiadura("azkartu");
						}
						else if (kolorea.equals("RED")) {
							pilota.setAbiadura("moteldu");
						}
						Main.getMain().oztopoaKendu(i);
					}
				}
			}
			
		}
		
		int j1 = pilota.getJ1Puntuak();
		int j2 = pilota.getJ2Puntuak();
		if(((j1 < 10) && (j2 < 10))){
			if(!(nireoztopoak[0]==null)) {
				String kolor = nireoztopoak[0].getKolorea();
				if(kolor=="WHITE") {
					g2d.setColor(Color.WHITE);
				}
				if(kolor=="GREEN") {
					g2d.setColor(Color.GREEN);
				}
				if(kolor=="RED") {
					g2d.setColor(Color.RED);
				}
				nireoztopoak[0].eguneratu(g2d);
			}
			if(!(nireoztopoak[1]==null)) {
					String kolor = nireoztopoak[1].getKolorea();
					if(kolor=="WHITE") {
						g2d.setColor(Color.WHITE);
					}
					if(kolor=="GREEN") {
						g2d.setColor(Color.GREEN);
					}
					if(kolor=="RED") {
						g2d.setColor(Color.RED);
					}
					nireoztopoak[1].eguneratu(g2d);
			}
			if(!(nireoztopoak[2]==null)) {
					String kolor = nireoztopoak[2].getKolorea();
					if(kolor=="WHITE") {
						g2d.setColor(Color.WHITE);
					}
					if(kolor=="GREEN") {
						g2d.setColor(Color.GREEN);
					}
					if(kolor=="RED") {
						g2d.setColor(Color.RED);
					}
					nireoztopoak[2].eguneratu(g2d);
			}
			String puntuakJ1 = Integer.toString(j1);
			String puntuakJ2 = Integer.toString(j2);
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("Consolas", Font.PLAIN, 70));
			g2d.drawString(puntuakJ1, 400, 100);
			g2d.drawString(puntuakJ2, 600, 100);
			
		}
		else if ((j1 < 10) && (j2 >= 10)) {
			String puntuakJ2 = "Winner";
			if(lengoaia.equals("Euskera")) {
				puntuakJ2 = "Irabazlea";
			}
			if(lengoaia.equals("Castellano")) {
				puntuakJ2 = "Ganador";
			}
			String puntuakJ1 = Integer.toString(j1);
			g2d.setFont(new Font("Consolas", Font.PLAIN, 70));
			g2d.drawString(puntuakJ1, 400, 100);
			g2d.drawString(puntuakJ2, 600, 100);
			this.getImage();
			g2d.drawImage(img,650,200,this);
			timer.stop();
			if (!amaituta) {
				Main.getMain().puntuakGorde(Main.getMain().getUser() + "_2",j2-j1,jokoMota);
				amaituta = true;
			}
			ranking.setEnabled(true);
			ranking.setVisible(true);
		}
		else if ((j2 < 10) && (j1 >= 10)) {
			String puntuakJ1 = "Winner";
			if(lengoaia.equals("Euskera")) {
				puntuakJ1 = "Irabazlea";
			}
			if(lengoaia.equals("Castellano")) {
				puntuakJ1 = "Ganador";
			}
			String puntuakJ2 = Integer.toString(j2);
			g2d.setFont(new Font("Consolas", Font.PLAIN, 70));
			g2d.drawString(puntuakJ1, 100, 100);
			g2d.drawString(puntuakJ2, 590, 100);
			this.getImage();
			g2d.drawImage(img,150,200,this);
			timer.stop();
			if (!amaituta) {
				Main.getMain().puntuakGorde(Main.getMain().getUser(),j1-j2,jokoMota);
				amaituta = true;
			}
			ranking.setEnabled(true);
			ranking.setVisible(true);
		}
	}
	
	public void eguneratu() {
		repaint();
	}
	
	public void getImage() {
		img = new ImageIcon (getClass().getResource("/pictures/dance.gif")).getImage();
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.VK_W == e.getKeyCode()) {
			jokalari1.goraMugitu();
		}
		if(e.VK_S == e.getKeyCode()) {
			jokalari1.beheraMugitu();
		}
		if(jokoMota.equals("JokalariVsJokalari")){
			if(e.VK_UP == e.getKeyCode()) {
				jokalari2.goraMugitu();
			}
			if(e.VK_DOWN == e.getKeyCode()) {
				jokalari2.beheraMugitu();
			}
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
		if(jokoMota.equals("JokalariVsJokalari")){
			if(e.VK_UP == e.getKeyCode()) {
				jokalari2.ezMugitu();
			}
			if(e.VK_DOWN == e.getKeyCode()) {
				jokalari2.ezMugitu();
			}
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
		if(jokoMota.equals("JokalariVsJokalari")){
			jokalari2.mugitu();
		}
		if(jokoMota.equals("JokalariVsIa")){
			jokalari2.IAeasy();
		}
		if(jokoMota.equals("JokalariVsIa_1")){//TODO
			jokalari2.IAhard(pilota.getY());
		}	
		eguneratu();
	}
}
