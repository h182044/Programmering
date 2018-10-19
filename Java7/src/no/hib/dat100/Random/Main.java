package no.hib.dat100.Random;

public class Main {

	public static void main(String[] args) {
		Terning t = new Terning(500);
		
		System.out.println(t.toString());
		System.out.println("---------------------");
		System.out.println("Antall Kast: " + t.getAntall());
		System.out.println("Antall 6-ere: "+ t.getAntallKast()[5] );
		System.out.println("Antall 5-ere: "+ t.getAntallKast()[4]);
		System.out.println("Antall 4-ere: "+t.getAntallKast()[3]);
		System.out.println("Antall 3-ere: "+ t.getAntallKast()[2]);
		System.out.println("Antall 2-ere: "+t.getAntallKast()[1]);
		System.out.println("Antall 1-ere " + t.getAntallKast()[0]);
		System.out.println("---------------------");
		System.out.println("Gjennomsnittskast : " + t.Gjennomsnitt());
		if(t.forsteSekser() > 0) {
		System.out.println("Antall kast for å få den første 6-eren: "+ t.forsteSekser());
		} else {
			System.out.println("Ingen 6-er");
		}
		System.out.println("Terningverdien det var flest av : " + t.flestAv());
	}

}
