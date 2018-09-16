package no.hvl.dat100;

public class GPSUtils {

	public static void main(String[] args) {

	}

	static double distance(double lat1, double long1, double lat2, double long2) {
		int radius = 63710000;
		return radius;
	}

	static double speed(int secs, double lat1, double long1, double lat2, double long2) {
		return long2;

	}

	/*
	 * @param Dobbel
	 * 
	 * @return rundet av dobbel i form av string med lengde på 10.
	 */
	static String printDouble(double d) {
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
	}

	/*
	 * @param Sekunder i form av int
	 * 
	 * @return tid i formatet hh:mm:ss
	 */
	static public String printTime(int secs) {
		String text = "";
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
		text = String.format("%02d:%02d:%02d", timer, minutt, sekund);
		return text;
	}

}
