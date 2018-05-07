package konektorea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBKudeatzailea {

	Connection connect = null;

	private void conOpen() {
		String path = "Pingponers.db";
				//this.getClass().getResource("brokersimulator.db").getPath();
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + path);
			if (connect != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
		}
	}

	private void conClose() {

		if (connect != null)
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println("Database connection terminated");

	}

	private ResultSet query(Statement s, String query) {

		ResultSet rs = null;

		try {
			//System.out.println(query);
			rs = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	// singleton patroia
	private static DBKudeatzailea instantzia = new DBKudeatzailea();

	private DBKudeatzailea() {
		this.conOpen();

	}

	public static DBKudeatzailea getInstantzia() {
		return instantzia;
	}

	public ResultSet execSQL(String query) {
		int count = 0;
		Statement s = null;
		ResultSet rs = null;

		try {
			s = (Statement) connect.createStatement();
			if (query.toLowerCase().indexOf("select") == 0) {
				// select agindu bat
				rs = this.query(s, query);

			} else {
				// update, delete, create agindu bat
				count = s.executeUpdate(query);
				System.out.println(count + " rows affected");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
}