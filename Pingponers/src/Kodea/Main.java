package Kodea;

import interfazea.ILogin;

public class Main {
	static Main main;
	
	public static Main getMain() {
	
		if (main == null) {
			main = new Main();
		}
		return main;
	}

	public static void main(String[] args) {
		getMain();
		ILogin nireLogin = new ILogin();
	}
	
	public boolean login(String user, String password) {
		Login login = new Login();
		if(login.login(user, password)) {
			//TODO
			//lamar la nueva interfaz
			return true;
		}
		else {
			//TODO
			//sacar el mensaje de error
			return false;
		}
	}
	public void createUser(String user, String password) {
		Login login = new Login();
		if( login.createUser(user, password)) {
			//TODO mensaje de creacion correcta
		}
		else {
			//TODO mensaje de usuario ya existe
		}
	}
}
