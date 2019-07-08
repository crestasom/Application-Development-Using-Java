package week1.main;

import java.util.Scanner;

import week1.model.Edge;
import week1.model.Vertex;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vertex a, b, c, d, e;
		Edge e1, e2, e3, e4, e5, e6;
		// input for vertex v1
		/*
		 * a = new Vertex(); System.out.println("Enter Vertex Id:");
		 * a.setId(sc.nextInt()); sc.next(); System.out.println("Enter Vertex Name:");
		 * a.setName(sc.next()); System.out.println("Enter Vertex Latitude:");
		 * a.setLatitude(sc.nextDouble());
		 * System.out.println("Enter Vertex Longitude:");
		 * a.setLongitude(sc.nextDouble()); System.out.println(a);
		 */
		a=initializeVertex();
		b=initializeVertex();
		c=initializeVertex();
		d=initializeVertex();
		e=initializeVertex();
		
		
		/*
		 * // input for vertex b b = new Vertex();
		 * System.out.println("Enter Vertex Id:"); b.setId(sc.nextInt()); // sc.next();
		 * System.out.println("Enter Vertex Name:"); b.setName(sc.next());
		 * System.out.println("Enter Vertex Latitude:"); b.setLatitude(sc.nextDouble());
		 * System.out.println("Enter Vertex Longitude:");
		 * b.setLongitude(sc.nextDouble()); System.out.println(b);
		 */

		// creating a new edge with vertex v1 as source and
		// vertex v2 as destination
		e1 = new Edge(1, a, b, 5);
		e2 = new Edge(2, a, c, 9);
		e3 = new Edge(3, c, d, 2);
		e4 = new Edge(4, b, d, 3);
		e5 = new Edge(5, b, e, 4);
		e6 = new Edge(6, d, e, 10);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
		System.out.println(e5);
		System.out.println(e6);
		//System.out.println(e6);
		
	}

	public static Vertex initializeVertex() {
		Scanner sc = new Scanner(System.in);
		Vertex v1 = new Vertex();
		System.out.println("Enter Vertex Id:");
		v1.setId(sc.nextInt());
		System.out.println("Enter Vertex Latitude:");
		v1.setLatitude(sc.nextDouble());
		System.out.println("Enter Vertex Longitude:");
		v1.setLatitude(sc.nextDouble());
		System.out.println(v1);
		return v1;
	}
}
