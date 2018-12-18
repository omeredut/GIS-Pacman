package game;

public class ConvertLatLong2XY {
	//https://stackoverflow.com/questions/14329691/convert-latitude-longitude-point-to-a-pixels-x-y-on-mercator-projection?rq=1
	public static void getXYfromLatLon(double latitude, double longitude) {
		// get x value
		int mapWidth = 307, mapHeight = 570;
		int pX = (int)((longitude+180.)*(mapWidth/360.));

		// convert from degrees to radians
		double latRad = latitude*Math.PI/180.;

		// get y value
		double mercN = Math.log(Math.tan((Math.PI/4.)+(latRad/2.)));
		int pY = (int)((mapHeight/2.)-(mapWidth*mercN/(2.*Math.PI)));
		System.out.println("x = "+pX+", y = "+pY);
	}

	public static void main(String[] args) {
		/////////
		double latitude    = 32.105394; // (φ)
		double longitude   = 35.202532;   // (λ)
		getXYfromLatLon(latitude, longitude);

		latitude    = 30.0; // (φ)
		longitude   = 34.0;   // (λ)
		getXYfromLatLon(latitude, longitude);
	}
/*output:
 * x=154.0, y=67.0
 * x=36.0, y=476.0
 */
}
