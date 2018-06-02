package br.com.zeit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String url = "jdbc:mysql://localhost:3306/zeit";
	private static String user = "root";
	private static String password = "root";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}
	
}