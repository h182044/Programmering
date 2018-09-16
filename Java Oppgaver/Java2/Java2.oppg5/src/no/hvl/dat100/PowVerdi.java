package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

public class PowVerdi {

	public static void main(String[] args) {

		int tall1;
		int tall2;
		int x = 1;
		int resultatPow;

		String melding;
		String input;

		melding = "Tall 1: ";
		input = showInputDialog(null, melding);
		tall1 = parseInt(input);
		melding = "Tall 2: ";
		input = showInputDialog(null, melding);
		tall2 = parseInt(input);

		System.out.println("Tall 1: " + tall1 + " | Tall 2: " + tall2);
		System.out.println("------------------------------");
		// Med math funksjonen
		resultatPow = (int) Math.pow(tall1, tall2);
		System.out.println("Resultat med pow: " + resultatPow);

		// Med while-løkke
		int resultatWhile = tall1;
		while (x < tall2) {
			resultatWhile *= tall1;
			x++;
		}
		System.out.println("Resultat med do-while: " + resultatWhile);
	}

}
