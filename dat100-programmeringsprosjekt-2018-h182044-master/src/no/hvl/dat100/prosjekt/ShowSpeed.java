package no.hvl.dat100.prosjekt;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;

public class ShowSpeed extends EasyGraphics {
	
	private static int[] times;
	private static double[] latitudes;
	private static double[] longitudes;
	private static double[] elevations;
		
	private static int MARGIN = 50;
	private static int BARHEIGHT = 200; // assume no speed above 200 km/t
	
	private static GPSComputer gpscomputer; 
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		
		GPSData gpsdata = GPSDataReaderWriter.readGPSFile(filename);
		 
		gpscomputer = new GPSComputer(gpsdata);
		
		times = gpscomputer.times;
		latitudes = gpscomputer.latitudes;
		longitudes = gpscomputer.longitudes;
		elevations = gpscomputer.elevations;
	}
	
	// read in the files and draw into using EasyGraphics
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = times.length-1; // number of data points
		
		makeWindow("Speed profile", 2*MARGIN + 2 * N, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT,N);
	}
	
	public void showSpeedProfile(int ybase, int N) {
		
		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering"));
		
		// hent hastigheter på de ulike deler av ruten
		
		double[] speeds = gpscomputer.speeds();
		int x = 0;
		int x2= 25; 
		int y1 = ybase; 
		int y2 = 10;
		
		// TODO:
		setColor(0, 0, 255);
		int y = ybase;
		int bredde = 2;
		int luft = 3;
		for(int i = 0; i < speeds.length; i++) {
			int høgde = (int) (speeds[i]);
			x = 0 + (luft * i);
			if(høgde < 0) {
				høgde = 1;
			}
			fillRectangle(x, y - høgde, bredde, høgde);
		}
		
		setColor(50,205,50);
		for(int i = 0; i < speeds.length; i++) {
			int fart = (int) gpscomputer.averageSpeed();
			drawLine(x,(ybase-fart),10*i,(ybase-fart));
			
	}
	}
}
