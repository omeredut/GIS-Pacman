package game;

import geom.Point3D;

public class Map {
	public String picPath;
	public Point3D rightCornerUp,leftCornerDown,rightCornerDown,leftCornerUp;
	public static final int WIDTHPIC=1433,HEIGHTPIC=642;
	
	public Map(String _picPath) {
		leftCornerUp = new Point3D( 32.105394,  35.202532, 0);
		rightCornerUp = new Point3D( 32.105444,  35.212496, 0);
		leftCornerDown = new Point3D( 32.101899,  35.202447, 0);
		rightCornerDown = new Point3D( 32.101899,  35.212496, 0);
		picPath=_picPath;
	}
	public Map(Point3D _rightCornerUp,Point3D _leftCornerDown,Point3D _leftCornerUp,Point3D _rightCornerDown,String _picPath) {
		rightCornerUp=_rightCornerUp;
		leftCornerDown=_leftCornerDown;
		leftCornerUp=_leftCornerUp;
		rightCornerDown=_rightCornerDown;
		picPath=_picPath;
	}
	

	//convert pixels point to polar point
	public Point3D pixel2Polar(Point3D point) {
		double ratioHorizontal=leftCornerUp.distance3D(rightCornerUp);
		double x=point.x()/WIDTHPIC*ratioHorizontal;
		double ratioVertical=leftCornerUp.distance3D(leftCornerDown);
		double y=point.y()/HEIGHTPIC*ratioVertical;
		return new Point3D(x,y,point.z());
	}
	
	//convert polar point to pixels point
	public Point3D polar2Pixel(Point3D point) {
		
		return point;
		
	}
}
