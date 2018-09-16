package no.hvl.dat100.prosjekt;

import easygraphics.EasyGraphics;
import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static int[] times;
	private static double[] latitudes;
	private static double[] longitudes;
	private static double[] elevations;

	private static int MARGIN = 50;
	private static int BARHEIGHT = 500; // assume no height above 500 meters

	private static GPSData gpsdata;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpsdata = GPSDataReaderWriter.readGPSFile(filename);

		GPSDataConverter converter = new GPSDataConverter(gpsdata);
		converter.convert();

		times = converter.times;
		latitudes = converter.latitudes;
		longitudes = converter.longitudes;
		elevations = converter.elevations;
	}

	// read in the files and draw into using EasyGraphics
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = elevations.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + BARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + BARHEIGHT); 
	}

	public void showHeightProfile(int ybase) {


		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering"));

		setColor(0, 0, 255);
		int y = ybase;
		int bredde = 2;
		int luft = 3;

		// elevations tabellen innholder alle høydedata
		for (int i = 0; i < elevations.length; i++) {
			// TODO
			// OPPGAVE - START
			int høgde = (int) (elevations[i]);
			int x = 25 + (luft * i);
			if(høgde < 0) {
				høgde = 1;
			}
			fillRectangle(x, y - høgde, bredde, høgde);
			
			// regn ut koordinator for søylen / linjen
			// (x1,y1) er startpunkt for søylen (linjen)
			// (x2,y2) er slutt punkt.

			// OPPGAVE - SLUTT
			
		}	
	}

}
