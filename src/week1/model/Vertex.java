package week1.model;

public class Vertex {

	private int id;
	private double latitude;
	private double longitude;
	
	//default constructor
	public Vertex() {
		this.id=0;
		this.latitude=0;
		this.longitude=0;
	}
	
	//parameterized Constructor
	public Vertex(int id, double latitude, double longitude) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String toString() {
		return "Vertex [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	
}
