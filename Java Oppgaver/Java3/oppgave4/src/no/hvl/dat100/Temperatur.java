package no.hvl.dat100;

import java.util.Scanner;

public class Temperatur {

	public static void main(String[] args) {
		System.out.println("Skriv inn temperaturen for uken: ");
		Scanner in = new Scanner(System.in);
		double[] tempTab = new double[7];
		double gjennomsnitt = 0;
		double max = 0;
		
		for(int i = 0; i < tempTab.length; i++) {
			tempTab[i] = in.nextDouble();
		}
		System.out.println("------------------------");
		for(int i = 0; i < tempTab.length; i++) {
			System.out.println((i+1) +". Dag: " + tempTab[i]);
			gjennomsnitt += tempTab[i];
			if(max < tempTab[i]) {
				max = tempTab[i];
			}
		}
		System.out.println("Gjennomsnittstemperaturen var " + (gjennomsnitt / tempTab.length));
		System.out.println("Den høgste temperaturen for uken " + max);
	}

}
