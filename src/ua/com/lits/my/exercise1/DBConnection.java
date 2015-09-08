package ua.com.lits.my.exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ua.com.lits.my.utils.Logger;

public class DBConnection {

	public void createDb(String USER, String PASS, String JDBC_DRIVER, String DB_URL, Connection conn, Statement stmt) {
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			Logger.print("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// Execute a query
			Logger.print("Creating database...");
			stmt = conn.createStatement();
			String sql = "CREATE DATABASE MyTest";
			stmt.executeUpdate(sql);
			Logger.print("Database created successfully");
		} catch (SQLException se) {
			// Handle errors for JDBC
			Logger.print("ERROR: " + se.getMessage());
		} catch (Exception e) {
			// Handle errors for Class.forName
			Logger.print("ERROR: " + e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				Logger.print("ERROR: " + se.getMessage());
			}
		}
	}

	public void deleteeDb(String USER, String PASS, String JDBC_DRIVER, String DB_URL, Connection conn, Statement stmt) {
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			Logger.print("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Logger.print("Connected database successfully");
			// Execute a query
			Logger.print("Deleting database...");
			stmt = conn.createStatement();
			String sql = "DROP DATABASE MyTest";
			stmt.executeUpdate(sql);
			Logger.print("Database deleted successfully");
		} catch (SQLException se) {
			// Handle errors for JDBC
			Logger.print("ERROR: " + se.getMessage());
		} catch (Exception e) {
			// Handle errors for Class.forName
			Logger.print("ERROR: " + e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				Logger.print("ERROR: " + se.getMessage());
			}
		} 
	}
}
