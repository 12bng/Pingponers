package Kodea;

import interfazea.ILogin;
import interfazea.LeihoNagusia;

public class Main {
	private static Main main;
	private String lengoaia;
	private String jokoMota;
	private LeihoNagusia nire_Lehioa;
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
	}
}
