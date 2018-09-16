package no.hvl.dat100;

import java.util.Scanner;

public class Tabeller {

	public static void main(String[] args) {
		
		// Skrive inn ord start.
		System.out.println("Skriv inn antall ord: ");
		Scanner in = new Scanner(System.in);
		int lengde = in.nextInt();
		int x = 0;
		int ordSomInn = 0;
		String[] strengtab = new String[lengde];
		do {
			System.out.println("Skriv inn et ord:");
			String s = in.next();
			strengtab[x] = s;
			x++;
		}
		while(x < lengde);
		for(int i = 0; i < strengtab.length; i++) {
			System.out.println("Streng: " + strengtab[i]);
		}
		// Skrive inn ord slutt.
		
		// Skrive inn mønster start.
		System.out.println("Skriv inn et Streng-Mønster:");
		String mønster = in.next();
		for(int i = 0; i < strengtab.length; i++) {
			if(strengtab[i].contains(mønster)) {
				ordSomInn++;
			}
		}
		System.out.println("Antall ord som innehelde mønsteret: " + ordSomInn);
		in.close();
		
		for(int i = 0; i < strengtab.length; i++) {
			String s = strengtab[i];
			if(s.length() == 1) {
				System.out.println(s);
			} else if(s.length() % 2 == 0) {
				System.out.println("Partal: " + strengtab[i].substring(lengde/2-1,(lengde/2)+1));
			} else if(s.length() % 2 != 0 && lengde >= 3){
				System.out.println("Oddetal: " + strengtab[i].substring(lengde/3, (lengde/3)+3));
			}
		}
		
	}

}
