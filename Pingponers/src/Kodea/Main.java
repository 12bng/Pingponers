package Kodea;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.management.timer.Timer;

import interfazea.ILogin;
import interfazea.LeihoNagusia;

public class Main {
	private static Main main;
	private String lengoaia;
	private String jokoMota;
	private LeihoNagusia nire_Lehioa;
	private Oztopo[] oztopoak = new Oztopo[3];
	public static Main getMain() {
	
		if (main == null) {
			main = new Main();
		}
		return main;
	}
	
	private Main() {}

	public static void main(String[] args) {
		getMain();
		ILogin.main(args);
	}
	
	public boolean login(String user, String password) {
		Login login = new Login();
		if(login.login(user, password)) {
			System.out.println("Kaixo " + user);
			String[] aldagaiak = new String[2];
			aldagaiak[0] = lengoaia;
			aldagaiak[1] = jokoMota;
			oztopoak[0] = null;
			oztopoak[1] = null;
			oztopoak[2] = null;
			return true;
		}
		else {
			//TODO
			//sacar el mensaje de error
			System.out.println("Erabiltzaile edo pasahitz okerra");
			return false;
		}
	}
	public void createUser(String user, String password) {
		Login login = new Login();
		if( login.createUser(user, password)) {
			//TODO mensaje de creacion correcta´
			System.out.println("Erabiltzaile berria sortuta");
		}
		else {
			//TODO mensaje de usuario ya existe
			System.out.println("Erabiltzaile hori badago sortuta");
		}
	}
	
	public void setLengoaia(String pLengoaia) {
		lengoaia = pLengoaia;
	}
	public void setJokoMota(String pJokoMota) {
		jokoMota = pJokoMota;
	}
	public void nireLehioNagusia() {
		nire_Lehioa = new LeihoNagusia(lengoaia, jokoMota);
		temporizador();
	}
	private void temporizador() {
		System.out.println("Timer start");
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate( ()-> {oztopoaGehitu();} , 0, 15, TimeUnit.SECONDS);

	}
	private void oztopoaGehitu() {	
			if(oztopoak[0]==null) {
				oztopoak[0]= new Oztopo();
				oztopoak[0].randomObstacle();
			}
			else if(oztopoak[1]==null) {
				oztopoak[1]= new Oztopo();
				oztopoak[1].randomObstacle();
			}
			else if(oztopoak[2]==null) {
				oztopoak[2]= new Oztopo();
				oztopoak[2].randomObstacle();
			}
			System.out.println("Oztopoa gehitu da");
	}
	public void oztopoaKendu(int i) {
		if(i==0) {
			oztopoak[0]= null;
		}
		else if(i==1) {
			oztopoak[1]= null;
		}
		else if(i==2) {
			oztopoak[2]= null;
		}
	}
	public Oztopo[] getOztopoak() {
		return oztopoak;
	}
}
