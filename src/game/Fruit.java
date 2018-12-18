package game;

import geom.Point3D;

public class Fruit {
	private int id;
	private Point3D mikum;
	private int weight;
	private final static String ICON="icons\\pineapple.png";
	
	public Fruit(int _id,Point3D _startPoint,int _weight) {
		id=_id;
		mikum=_startPoint;		
		weight=_weight;
	}
	
	public Point3D getPoint() {
		return mikum;
	}
	public String toString() {
		return "f,"+id + "," + mikum.x()+","+mikum.y()+","+mikum.z() + "," + weight;
	}
}
