package net.devsedge.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {

		try (	// Getting a Connection from DriverManager 
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password");

				// Getting a Statement from Connection
				Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

				// Getting a ResultSet from Statement
				ResultSet res = stat.executeQuery("SELECT * FROM employee");) {

			// Iterating ResultSet
			while (res.next()) {
				System.out.print(res.getString(1) + " ");
				System.out.print(res.getString(2) + " ");
				System.out.print(res.getString(3) + " ");
				System.out.println(res.getString(4));
			}

			// Getting a ResultSetMetaData from ResultSet
			ResultSetMetaData meta = res.getMetaData();

			// Reading ResultSetMetaData
			System.out.println(meta.getColumnCount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
