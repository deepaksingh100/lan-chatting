package me.deepak.chat.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author SONY
 */
public class DataBaseUtil {

	private static Connection connection;
	private static Statement statement;

	private DataBaseUtil() {
	}

	public static void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat", "root", "root");
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Statement getStatement() {
		if (statement == null)
			createConnection();
		return statement;
	}

	public static void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
