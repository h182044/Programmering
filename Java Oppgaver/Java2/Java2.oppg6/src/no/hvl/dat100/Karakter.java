package no.hvl.dat100;

import static java.lang.Integer.*;
import static javax.swing.JOptionPane.*;

public class Karakter {

	public static void main(String[] args) {

		int antall = 1;
		String melding = "Skriv inn poengsum:";

		do {
			int poengsum;
			String input = showInputDialog(null, melding);
			poengsum = parseInt(input);

			if (poengsum <= 100 && poengsum >= 90) {
				System.out.println("Karakter nr " + antall + ": A");
				antall++;
			} else if (poengsum <= 89 && poengsum >= 80) {
				System.out.println("Karakter nr " + antall + ": B");
				antall++;
			} else if (poengsum <= 79 && poengsum >= 60) {
				System.out.println("Karakter nr " + antall + ": C");
				antall++;
			} else if (poengsum <= 59 && poengsum >= 50) {
				System.out.println("Karakter nr " + antall + ": D");
				antall++;
			} else if (poengsum <= 49 && poengsum >= 40) {
				System.out.println("Karakter nr " + antall + ": E");
				antall++;
			} else if (poengsum <= 39 && poengsum >= 0) {
				System.out.println("Karakter nr " + antall + ": F");
				antall++;
			} else {
				System.out.println("ugyldig poengsum, vennligst prøv igjen.");
			}
		} while (antall <= 10);

	}

}
