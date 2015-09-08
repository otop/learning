package ua.com.lits.my.exercise1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import ua.com.lits.my.utils.Logger;

public class WorkingWithDB {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Test";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "12345qwerty";

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet resultSet = dbm.getCatalogs();
			DBConnection dbConn = new DBConnection();
			String sql = null;
			// Checks if database already esixts
			while (resultSet.next()) {
				if (resultSet.equals("MyTest")) {
					Logger.print("DB exists");
				} else {
					// Create new DataBase
					dbConn.createDb(USER, PASS, JDBC_DRIVER, DB_URL, conn, stmt);
					break;
				}
			}
			// Check if tables exists
			if (dbm.getTables("MyTest", null, "TestData", null).next()) {
				Logger.print("Table exists");
			} else {
				// Create new table
				sql = "CREATE TABLE TestData (ID INT NOT NULL PRIMARY KEY, Title NVARCHAR(50) NULL, Artist NVARCHAR(50) NULL, Duration VARCHAR(10) NULL)";
				stmt.executeUpdate(sql);
			}
			// Insert new data in table
			sql = "insert into TestData values (1, 'Do I Wanna Know?', 'Arctic Monkeys', '03:40'),"
					+ " (2, 'Let Her Go', 'Passenger', '04:10'), (3, 'Imagine Dragons', 'Demons', NULL),"
					+ " (4, 'Give Me Love', 'Ed Sheeran', '03:50'), (5, 'Counting Stars', 'OneRepublic', '03:15'),"
					+ " (6, 'All of Me', 'John Legend', '04:24'), (7, 'Summertime Sadness', 'Lana Del Rey', '05:01'),"
					+ " (8, 'Young And Beautiful', NULL, '04:21'), (9, 'R U Mine?', 'Arctic Monkeys', '04:00'), (10, 'Skinny Love', 'Birdy', NULL)";
			stmt.executeUpdate(sql);
			Logger.print("----------------------------------------------------------------");
			sql = "SELECT Title, Artist FROM TestData";
			ResultSet rs = stmt.executeQuery(sql);
			// Put data from db in HashMAp
			HashMap<String, String> songs = new HashMap<String, String>();
			while (rs.next()) {
				songs.put(rs.getString("Title"), rs.getString("Artist"));
			}
			for (String key : songs.keySet()) {
				// Displaying data from DB
				Logger.print("Artist name is " + songs.get(key) + " Songs title is " + key);
			}
			rs.close();
			Logger.print("-----------------------------------------------------------------");
		} catch (SQLException e) {
			Logger.print("ERROR: " + e.getMessage());

		} catch (ClassNotFoundException ex) {
			Logger.print("ERROR: " + ex.getMessage());
		} finally {
			// Drop created table
			String sql = "DROP TABLE TestData";
			stmt.executeUpdate(sql);
			Logger.print("TestData table is deleted");
			// Drop created DB
			DBConnection dbConn = new DBConnection();
			dbConn.deleteeDb(USER, PASS, JDBC_DRIVER, DB_URL, conn, stmt);
			// Close connections
			stmt.close();
			conn.close();
		}
	}

}
