package no.hib.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Oddetal {

	public static void main(String[] args) {

		int nGrense;
		int x;
		int hGrense;
		boolean siste;
		String melding;
		melding = "Skriv inn nedre grense:";
		String s = showInputDialog(null, melding);
		nGrense = parseInt(s);

		melding = "Skriv inn øvre grense:";
		s = showInputDialog(null, melding);
		hGrense = parseInt(s);
		System.out.println("**************************");
		System.out.println("Nedre grense: " + nGrense);
		System.out.println("Øvre grense: " + hGrense);
		System.out.println("**************************");
		System.out.print("Resultat: ");

		if (hGrense % 2 != 0) {
			for (int i = nGrense; i < hGrense; i++) {
				if (i % 2 != 0) {
					System.out.print(i + ",");
				}
			}
			System.out.print(hGrense + ".");
		} else if (hGrense % 2 == 0) {
			for (int t = nGrense; t <= hGrense; t++) {
				if (t % 2 != 0 && t != (hGrense - 1)) {
					System.out.print(t + ",");
				}
			}
			System.out.println(hGrense - 1 + ".");
		}

	}
}
