package week4.model;

public class Edge {

	int id;
	private Vertex source;
	private Vertex destination;
	private double length;
	
	public Edge() {
		id=0;
		this.source = null;
		this.destination = null;
		this.length = 0;
	}
	
	public Edge(int id,Vertex source, Vertex destination, double length) {
		super();
		this.source = source;
		this.destination = destination;
		this.length = length;
	}
	
	public Vertex getSource() {
		return source;
	}
	public void setSource(Vertex source) {
		this.source = source;
	}
	public Vertex getDestination() {
		return destination;
	}
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + ", length=" + length + "]";
	}
	
	
	
	
	
}
