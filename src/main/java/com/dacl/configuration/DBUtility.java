package com.dacl.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				@SuppressWarnings("unused")
				Properties prop = new Properties();
				// InputStream inputStream =
				// DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
				// prop.load(inputStream);
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/testUcl";
				String user = "root";
				String password = "Flatvision12";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}
