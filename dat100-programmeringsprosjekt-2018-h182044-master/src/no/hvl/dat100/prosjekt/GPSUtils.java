package no.hvl.dat100.prosjekt;

import static java.lang.Math.*;

public class GPSUtils {

	public GPSUtils() {

	}

	// konverter sekunder til string på formen hh:mm:ss
	public static String printTime(int secs) {
		// TODO
		String timestr = "";
		int tid = secs;
		int timer = 0;
		int minutt = 0;
		int sekund = 0;
		if (tid > 3600) {
			timer = tid / 3600;
			tid = tid - (timer * 3600);
		}
		if (tid > 60) {
			minutt = tid / 60;
			tid = tid - (minutt * 60);
		}
		if (tid < 60) {
			sekund = tid;
		}
		timestr = String.format("%02d:%02d:%02d", timer, minutt, sekund);

		return timestr;
	}

	// beregn maximum av en tabell av doubles med minnst et element
	public static double findMax(double[] da) {

		double max = da[0];

		for (double d : da) { 
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	// beregn minimum av en tabell av doubles med minnst et element
	public static double findMin(double[] da) {

		// fjern = "0.0" når metoden implementeres for ikke få forkert minimum
		double min = 0.0;

		// TODO
		// OPPGAVE - START
		min = da[0];
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}

		// OPPGAVE - SLUT
		return min;
	}

	private static int R = 6371000; // jordens radius

	// Beregn avstand mellom to gps punkter ved bruk av Haversine formlen
	public static double distance(double latitude1, double longitude1, double latitude2, double longitude2) {

		double a, c, d = 1.0; // fjern = 1.0

		// TODO:
		// OPPGAVE - START
		double latDistance = Math.toRadians(latitude2 - latitude1);
		double lonDistance = Math.toRadians(longitude2 - longitude1);
		a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(latitude1))
				* Math.cos(Math.toRadians(latitude2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R * c; // convert to meters

		// OPPGAVE - SLUTT

		return d;
	}

	// beregn gjennomsnits hastighet i km/t mellom to gps punkter
	public static double speed(int secs, double latitude1, double longitude1, double latitude2, double longitude2) {

		double speed = 0.0;

		// TODO:
		// OPPGAVE - START
		double avstand = distance(latitude1, longitude1, latitude2, longitude2);

		double mph = avstand / secs;
		speed = (mph * 3600) / 1000;

		// OPPGAVE - SLUTT

		return speed;
	}

	private static int TEXTWIDTH = 10;

	// konverter double til string med 2 decimaler og streng lengde 10
	// eks. 1.346 konverteres til " 1.35" og enhet til slutt
	// Hint: se på String.format metoden

	public static String printDouble(double d) {

		// String str = "";

		// TODO
		// OPPGAVE - START
		// String dobbel = Double.toString(d);
//		str = String.format(".2d", d);
//		System.out.println(str);
		double sluttVerdi = Math.round(d * 100.0) / 100.0;
		String sluttString = "";
		String dobbelString = Double.toString(sluttVerdi);
		int lengde = sluttString.length();
		if (dobbelString.length() < 10) {
			for (int i = lengde; i < 10 - dobbelString.length(); i++) {
				sluttString += " ";
			}
		}
		sluttString += dobbelString;
		return sluttString;

		// OPPGAVE - SLUTT

		// return str;
	}
}
