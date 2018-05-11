package Kodea;

import java.util.concurrent.ThreadLocalRandom;

public class Oztopo {
	private String kolorea; //rojo, blanco o verde
	private int x;
	private int y;
	
	public void randomObstacle() {
		int aux = ThreadLocalRandom.current().nextInt(1, 4);
		if(aux==1) {
			kolorea = "Red";
		}
		if(aux==2) {
			kolorea = "White";
		}
		if(aux==3) {
			kolorea = "Green";
		}
		randomPosition();
	}
	private void randomPosition() {
		x = ThreadLocalRandom.current().nextInt(50, 951);
		y = ThreadLocalRandom.current().nextInt(10, 451);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
