package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		Connection connection = null;
		final String url = "jdbc:mysql://localhost:3306/web_toeic?useUnicode=true&amp";
		final String userName = "root";
		final String passWord = "123456";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, passWord);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Connection connection = getConnection();
		if (connection != null) {
			System.out.println("ok");
		} else {
			System.out.println("fail");
		}
	}

}
