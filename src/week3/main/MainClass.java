package week3.main;

import java.sql.SQLException;
import java.util.List;

import week3.database.Database;
import week3.model.Vertex;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		Vertex v1 = new Vertex("zzz", 324.33, 232.24);
		Database db = new Database();
		// db.addVertex(v1);
		
		v1=v1=db.getVertexSQLInjectionPrev("2' or '1'='1");
		System.out.println(v1);

		/*
		 * List<Vertex> vList=db.getAllVertex(); for(Vertex v:vList) {
		 * System.out.println(v); } v1=db.getVertex(3);
		 * //v1=db.getVertexSQLInjection("2' or '1'='1");
		 * System.out.println("vertex with id 3 is "+v1);
		 */
	}
}
