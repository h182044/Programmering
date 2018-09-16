package no.hvl.dat100.prosjekt;

public class GPSComputer {

	public GPSComputer(GPSData gpsdata) {

		GPSDataConverter converter = new GPSDataConverter(gpsdata);
		converter.convert();

		this.times = converter.times;
		this.latitudes = converter.latitudes;
		this.longitudes = converter.longitudes;
		this.elevations = converter.elevations;
	}

	// tabeller for GPS datapunkter
	public int[] times;
	public double[] latitudes;
	public double[] longitudes;
	public double[] elevations;

	// beregn total distances (i meter)
	public double totalDistance() {
		int lengde = times.length;
		double distance = 0;
		// TODO
		// OPPGAVE - START
		for (int i = 0; i < lengde - 1; i++) {
			distance += GPSUtils.distance(latitudes[i], longitudes[i], latitudes[i + 1], longitudes[i + 1]);
		}
		// OPPGAVE - SLUTT

		return distance;
	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		// TODO
		// OPPGAVE - START
		for(int i = 0; i< times.length-1; i++) {
		
			if(elevations[i] < elevations[i+1]) {
				elevation += elevations[i+1] - elevations[i];
			}
		}

		// OPPGAVE - SLUTT
		return elevation;
	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		int totaltime = 0;
		// TODO
		// OPPGAVE START
		for(int i = 0; i < times.length -1; i++) {
			totaltime += times[i+1]-times[i];
		}
		// OPPGAVE SLUTT
		return totaltime;
	}

	// beregn gjennomsnitshastighets mellom hver av gps punktene
	public double[] speeds() {

		double[] speeds = new double[times.length - 1];
		// TODO
		// OPPGAVE - START
		for(int i = 0; i < times.length -1; i++) {
			int tid = times[i+1]-times[i];
			speeds[i] = GPSUtils.speed(tid, latitudes[i], longitudes[i], latitudes[i + 1], longitudes[i + 1]);
		}

		// OPPGAVE - SLUTT
		return speeds;
	}

	// beregn maximum hastighet km/t
	public double maxSpeed() {

		double maxspeed = 0;

		// TODO
		// OPPGAVE - START
		for(int i = 0; i < times.length -1 ; i++) {
			if(speeds()[i] > maxspeed) {
				maxspeed = speeds()[i];
			}
		}

		// OPPGAVE - SLUTT

		return maxspeed;
	}

	// beregn gjennomsnittshasitiget for hele turen km/t
	public double averageSpeed() {
		double tid = totalTime();
		double distanse = totalDistance();
		double avarage;
		// TODO
		// OPPGAVE - START
		tid = tid / 60/ 60;
		distanse = distanse / 1000;
		avarage = distanse / tid;
		// OPPGAVE - SLUTT

		return avarage;
	}

	// conversion factor kph (km/t) to miles per hour (mph)
	public static double MS = 0.62;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {
		double kcal = 0;
		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;
		double speedmph = speed * MS;
		// TODO
		// OPPGAVE START
		if(0 < speedmph && speedmph < 10) {
			met = 4;
		}else if(speedmph <= 12) {
			met = 6;
		}else if(speedmph <= 14) {
			met = 8;
		}else if(speedmph <= 15) {
			met = 10;
		}else if(speedmph <= 20) {
			met = 12;
		}else {
			met = 16;
		}
		kcal = met * weight * (secs/60/60);
		// Energy Expended (kcal) = MET x Body Weight (kg) x Time (h)
		// OPPGAVE SLUTT
		return kcal;
	}
	public double totalKcal(double weight) {
		double totalkcal = 0;
		// TODO
		// OPPGAVE - START
		
		totalkcal = kcal(weight, totalTime(), averageSpeed());
		// Hint: hent hastigheter i speeds tabellen og tider i timestabellen
		// disse er definer i toppen av klassen og lese automatisk inn
		// OPPGAVE - SLUTT
		return totalkcal;
	}

	private static double WEIGHT = 80.0;

	// skriv ut statistikk for turen
	public void print() {

		// TODO
		// OPPGAVE - START
		System.out.println("Total Time     :   "+ GPSUtils.printTime(totalTime()));
		System.out.println("Total Distance : "+ GPSUtils.printDouble(totalDistance()/1000)+" KM");
		System.out.println("Total elevation: "+ GPSUtils.printDouble(totalElevation())+" M");
		System.out.println("Max Speed      : "+ GPSUtils.printDouble(maxSpeed())+" KM/T");
		System.out.println("Avarage speed  : "+ GPSUtils.printDouble(averageSpeed())+ " KM/T");
		System.out.println("Energy         : "+ GPSUtils.printDouble(totalKcal(WEIGHT))+ " KCAL");
		System.out.println(times[1] -times[0]);

		// OPPGAVE - SLUT
	}

	// ekstraoppgaver
	public void climbs() {

	}

	public void maxClimb() {

	}
}
