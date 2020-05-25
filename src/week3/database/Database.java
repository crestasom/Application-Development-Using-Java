package week3.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import week3.model.Vertex;

public class Database {
	String url = "jdbc:mysql://localhost:3306/tbl_graph";
	String username = "root";
	String password = "";
	String sql = "";
	Statement stmt;
	ResultSet rs;
	Connection con;

	public Database() throws SQLException {
		con = (Connection) DriverManager.getConnection(url, username, password);

	}
	
	public void updateVertex(int id,Vertex v) {
		String sql="update vertex set name="+v.getName()+", latitude="+v.getLatitude()+" where id="+id;
	}

	public void addVertex(Vertex v) throws SQLException{

		sql = "Insert into vertex (name,latitude,longitude) " + "values('" + v.getName() + "', " + v.getLatitude()
				+ ", " + v.getLongitude() + ")";
		System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public Vertex getVertex(String vId) throws SQLException {
		Vertex v = null;
		sql = "SELECT * FROM vertex where id=" + vId;
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		rs.next();
		int id = rs.getInt(1);
		String name = rs.getString(2);
		double latitude = rs.getDouble(3);
		double longitude = rs.getDouble(4);
		v = new Vertex(id, name, latitude, longitude);
		rs.close();
		stmt.close();
		return v;
	}

	public List<Vertex> getAllVertex() throws SQLException {
		Vertex v;
		List<Vertex> vList = new ArrayList<Vertex>();
		sql = "SELECT * FROM vertex";
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		while (rs.next()) {

			int id = rs.getInt(1);
			String name = rs.getString(2);
			double latitude = rs.getDouble(3);
			double longitude = rs.getDouble(4);
			v = new Vertex(id, name, latitude, longitude);
			vList.add(v);

		}
		rs.close();
		stmt.close();
		return vList;
	}

	public Vertex getVertexSQLInjection(String vId) throws SQLException {
		Vertex v = null;
		sql = "SELECT * FROM vertex where id='" + vId + "";
		System.out.println(sql);
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		rs.next();
		int id = rs.getInt(1);
		String name = rs.getString(2);
		double latitude = rs.getDouble(3);
		double longitude = rs.getDouble(4);
		v = new Vertex(id, name, latitude, longitude);
		rs.close();
		stmt.close();
		return v;
	}

	public Vertex getVertexSQLInjectionPrev(String vId) throws SQLException {
		Vertex v = null;
		sql = "SELECT * FROM vertex where id = ?";
		// 3. prepare sql statement to be executed
		PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
		p.setString(1, vId);
		// 4 get the resultset from execution
		rs = p.executeQuery();
		rs.next();
		int id = rs.getInt(1);
		String name = rs.getString(2);
		double latitude = rs.getDouble(3);
		double longitude = rs.getDouble(4);
		v = new Vertex(id, name, latitude, longitude);
		rs.close();
		stmt.close();
		return v;
	}

}
