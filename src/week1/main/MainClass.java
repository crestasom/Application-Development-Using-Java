package week1.main;

import java.util.Scanner;

import week1.model.Edge;
import week1.model.Vertex;

public class MainClass {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vertex v1, v2, v3, v4, v5;
		Edge e1, e2, e3;
		//input for vertex v1
		v1 = new Vertex();
		System.out.println("Enter Vertex Id:");
		v1.setId(sc.nextInt());
		System.out.println("Enter Vertex Latitude:");
		v1.setLatitude(sc.nextDouble());
		System.out.println("Enter Vertex Longitude:");
		v1.setLatitude(sc.nextDouble());
		System.out.println(v1);
		System.out.println(v1);
		
		//input for vertex v1
		v2 = new Vertex();
		System.out.println("Enter Vertex Id:");
		v2.setId(sc.nextInt());
		System.out.println("Enter Vertex Latitude:");
		v2.setLatitude(sc.nextDouble());
		System.out.println("Enter Vertex Longitude:");
		v2.setLatitude(sc.nextDouble());
		System.out.println(v2);
		System.out.println(v2);

		//creating a new edge with vertex v1 as source and 
		//vertex v2 as destination
		e1 = new Edge(1, v1, v2, 5);
		System.out.println(e1);
	}

}

/*
 * class InputClass { Scanner sc = new Scanner(System.in);
 * 
 * public Vertex initializeVertex() { Vertex v1 = new Vertex();
 * System.out.println("Enter Vertex Id:"); v1.setId(sc.nextInt());
 * System.out.println("Enter Vertex Latitude:");
 * v1.setLatitude(sc.nextDouble());
 * System.out.println("Enter Vertex Longitude:");
 * v1.setLatitude(sc.nextDouble()); System.out.println(v1); return v1; } }
 */