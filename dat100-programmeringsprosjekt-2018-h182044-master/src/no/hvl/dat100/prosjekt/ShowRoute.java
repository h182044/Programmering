package no.hvl.dat100.prosjekt;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;

public class ShowRoute extends EasyGraphics {

	private static int[] times;
	private static double[] latitudes;
	private static double[] longitudes;
	private static double[] elevations;

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;
	private static GPSComputer gpscomputer;

	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");

		GPSData gpsdata = GPSDataReaderWriter.readGPSFile(filename);

		gpscomputer = new GPSComputer(gpsdata);

		times = gpscomputer.times;
		latitudes = gpscomputer.latitudes;
		longitudes = gpscomputer.longitudes;
		elevations = gpscomputer.elevations;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(longitudes);
		double minlon = GPSUtils.findMin(longitudes);

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// y-pixels per breddegrad
	
	public double ystep() {
		
		// TODO
		// OPPGAVE - START
		double maxlat = GPSUtils.findMax(latitudes);
		double minLat = GPSUtils.findMin(latitudes);
		
		double ystep = MAPYSIZE / (Math.abs(maxlat - minLat));
		
		// OPPGAVE SLUTT
		
		return ystep;
	}

	public void showRouteMap(int ybase) {
		
		double xstep = xstep();
		double ystep = ystep();

		double minlon = GPSUtils.findMin(longitudes);
		double minlat = GPSUtils.findMin(latitudes);

		setColor(0, 255, 0); // green

		// draw the locations
		for (int i = 0; i < latitudes.length; i++) {

			int x,y;

			// TODO: OPPGAVE START
			
			// må finne punkt nr i fra latitues og longitudes tabellene
			// og sette x og y til der de skal tegnes som et punkt i vinduet
			setColor(0, 0, 255); // blue;

			// make a circle in the first point
			 x = MARGIN + (int) ((longitudes[i] - minlon) * xstep);
			 y = ybase - (int) ((latitudes[i] - minlat) * ystep);

			fillCircle(x, y, 7);
			// OPPGAVE SLUTT
	}
		

	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;
		String tid         ="Total Time       :   "+ GPSUtils.printTime( gpscomputer.totalTime());
		String distanse    ="Total Distance   :"+ GPSUtils.printDouble((gpscomputer.totalDistance()/1000))+ " Km";
		String elevation   ="Total Elevation  :"+ GPSUtils.printDouble(gpscomputer.totalElevation())+ " M";
		String maxspeed    ="Max Speed        :"+ GPSUtils.printDouble(gpscomputer.maxSpeed())+ " Km/t";
		String avaragespeed="Avarage Speed   :"+ GPSUtils.printDouble(gpscomputer.averageSpeed())+" Km/t";
		setColor(0,0,0);
		setFont("Courier",16);
		// TODO:
		// OPPGAVE - START
		drawString(tid, MARGIN, MARGIN);
		drawString(distanse, MARGIN, MARGIN+(TEXTDISTANCE*1));
		drawString(elevation, MARGIN, MARGIN+(TEXTDISTANCE*2));
		drawString(maxspeed, MARGIN, MARGIN+(TEXTDISTANCE*3));
		drawString(avaragespeed, MARGIN, MARGIN+(TEXTDISTANCE*4));
				
		// OPPGAVE - SLUTT;
	}

	public void playRoute(int ybase) {
		
		double minlat = GPSUtils.findMin(latitudes);
		double minlon = GPSUtils.findMin(longitudes);

		double xstep = xstep();
		double ystep = ystep();

		setColor(0, 0, 255); // blue;

		// make a circle in the first point
		int x = MARGIN + (int) ((longitudes[0] - minlon) * xstep);
		int y = ybase - (int) ((latitudes[0] - minlat) * ystep);

		int movingcircle = fillCircle(x, y, 7);

		// TODO: 
		// EKSTRAOPPGAVE -- START

		// Få cirklen til å flytte seg mellom punktene i vinduet
		
		// EKSTRAOPPGAVE - SLUTT
	}

}
