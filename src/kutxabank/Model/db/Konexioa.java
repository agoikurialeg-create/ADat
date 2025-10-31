package kutxabank.Model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
	
	public static Connection getKonexioa() {
		Connection kon  = null;
		String url = "jdbc:mysql://localhost:3306/kutxabank";
		String user = "root";
		String pass = "";
		try {
			kon = DriverManager.getConnection(url, user, pass);
		}catch(SQLException e){ System.out.println("Errorea: " + e.getMessage());}
		
		return kon;
	}
}
