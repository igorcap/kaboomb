package pst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/bd_kaboomb", "root", "159753");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
