package by.epam.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		ResourceBundle resource = ResourceBundle.getBundle("by.epam.web.dao.database");
		String url = resource.getString("db.url");
		String user = resource.getString("db.user");
		String pass = resource.getString("db.password");
		return DriverManager.getConnection(url, user, pass);
	}
}
