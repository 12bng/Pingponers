package Kodea;

import java.sql.ResultSet;
import java.sql.SQLException;

import konektorea.DBKudeatzailea;

public class Login {
 public boolean login(String user, String password) {
	 String query = "Select Erabiltzailea from Erabiltzaileak where Erabiltzailea='"+user+"' and Password='"+password+"';"; //TODO
	 ResultSet rs = DBKudeatzailea.getInstantzia().execSQL(query);
	 try {
		while(rs.next()) {
			 if(rs.getString("Erabiltzailea").equals(user)) {
				 return true;
			 }
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return false;
 }
	public boolean createUser(String user, String password) {
		 boolean libre = true;
		 String query = "Select Erabiltzailea from Erabiltzaileak where Erabiltzailea='"+user+"';"; 
		 ResultSet rs = DBKudeatzailea.getInstantzia().execSQL(query);
		 try {
			while(rs.next()) {
				 if(rs.getString("Erabiltzailea").equals(user)) {
					 libre= false;
				 }
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			}
		 if (libre) {
			 query = "INSERT INTO Erabiltzaileak VALUES ('"+user+"','"+password+"');";
			 DBKudeatzailea.getInstantzia().execSQL(query);
		 }
		return libre;
	}
}
