package spacebattle;

import java.util.Date;

public class Ship {
	private String id;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double ax;
	private double ay;
	private double heading;
	private long lastTimeUpdated;
	
	public Ship(String id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
		this.ax = 0;
		this.ay = 0;
		this.heading = 0;
		this.lastTimeUpdated = new Date().getTime();
	}
	public String getID() {return id;}
	public double getX() { return x; }
	public double getY() { return y; }
	public double getDX() { return dx; }
	public double getDY() { return dy; }
	public double getAX() { return ax; }
	public double getAY() { return ay; }
	public double getHeading() { return heading; }
	
	public void setAcceleration(double ax, double ay) {
		this.update();
		this.ax = ax;
		this.ay = ay;
	}
	public void update() {
		long now = System.currentTimeMillis();
		double dT = (now - lastTimeUpdated)*0.0001; // in seconds
		this.dx = this.dx + dT * this.ax;
		this.dy = this.dy + dT * this.ay;
		this.x = this.x + dT * this.dx;
		this.y = this.y + dT * this.dy;
		lastTimeUpdated = now;
		this.heading = (this.heading + dT*100) % 360.0;
	}
}
