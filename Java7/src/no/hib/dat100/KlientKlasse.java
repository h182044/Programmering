package no.hib.dat100;

public class KlientKlasse {

	public static void main(String[] args) {
		
		Varelager v = new Varelager();
		Meny meny = new Meny(v);
		meny.start();

	}

}
