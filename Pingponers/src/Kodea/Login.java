package Kodea;

import java.sql.ResultSet;
import java.sql.SQLException;

import konektorea.DBKudeatzailea;

public class Login {
 public boolean login(String user, String password) {
	 String query = "Select user from Pingponers.Erabiltzaileak where User='"+user+"' and Password='"+password+"');"; //TODO
	 ResultSet rs = DBKudeatzailea.getInstantzia().execSQL(query);
	 try {
		while(rs.next()) {
			 if(rs.getString("user").equals(user)) {
				 return true;
			 }
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return false;
 }
}
