package week2.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import week2.model.Vertex;

public class MainClass {

	public static void main(String[] args) {
		// connection string
		ArrayList<Vertex> vList=new ArrayList<Vertex>();
		Vertex v;
		String url = "jdbc:mysql://localhost:3306/graph";
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
				
				  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
				  rs.getDouble(3)+" "+rs.getDouble(4));
				 

				/*
				 * int id = rs.getInt(1); String name = rs.getString(2); double latitude =
				 * rs.getDouble(3); double longitude = rs.getDouble(4); v = new Vertex(id, name,
				 * latitude, longitude); vList.add(v);
				 */

			}
			/*
			 * for(Vertex v1:vList) { System.out.println(v1); }
			 */

		} catch (SQLException e7) {
			// TODO Auto-generated catch block
			System.out.println(e7.getMessage());
		}

	}

}
