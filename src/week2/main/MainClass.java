package week2.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import week2.model.Edge;
import week2.model.Vertex;

public class MainClass {

	public static void main(String[] args) {
		// connection string
		ArrayList<Vertex> vList = new ArrayList<Vertex>();
		Vertex v;
		Edge e1, e2, e3, e4, e5, e6;
		String url = "jdbc:mysql://localhost:3306/tbl_graph";
		String username = "root";
		String password = "";
		String sql = "";
		Statement stmt;
		ResultSet rs;
		Connection con;
		try {
			// 1. get the connection object
			con = (Connection) DriverManager.getConnection(url, username, password);
			// 2. prepare sql string
			sql = "SELECT * FROM vertex";
			// 3. prepare sql statement to be executed
			stmt = (Statement) con.createStatement();
			// 4 get the resultset from execution
			rs = stmt.executeQuery(sql);
			/*
			 * use rs.get... to get the data from result rs. next check if there is data on
			 * next row also automatically moves the cursor to next row of data
			 */
			while (rs.next()) {

				/*
				 * System.out .println(rs.getInt(1) + " " + rs.getString(2) + " " +
				 * rs.getDouble(3) + " " + rs.getDouble(4));
				 */

				int id = rs.getInt(1);
				String name = rs.getString(2);
				double latitude = rs.getDouble(3);
				double longitude = rs.getDouble(4);
				v = new Vertex(id, name, latitude, longitude);
				vList.add(v);

			}

			/*
			 * for (Vertex v1 : vList) { System.out.println(v1); }
			 */

			e1 = new Edge(1, vList.get(0), vList.get(1), 5.3);
			e2 = new Edge(2, vList.get(1), vList.get(2), 9);
			e3 = new Edge(3, vList.get(2), vList.get(3), 2);
			e4 = new Edge(4, vList.get(3), vList.get(4), 3);
			e5 = new Edge(5, vList.get(4), vList.get(5), 4);
			e6 = new Edge(6, vList.get(0), vList.get(2), 10);
			System.out.println(e1);
			System.out.println(e2);
			System.out.println(e3);
			System.out.println(e4);
			System.out.println(e5);
			System.out.println(e6);

		} catch (SQLException e7) {
			// TODO Auto-generated catch block
			System.out.println(e7.getMessage());
		}

	}

}
