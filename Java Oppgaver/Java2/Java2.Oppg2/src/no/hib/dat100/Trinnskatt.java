package no.hib.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Trinnskatt {

	public static void main(String[] args) {

		// les inn inntekta.
		int brutto = parseInt(showInputDialog("Skriv inn bruttoinntekt:"));

		// Sjekker nivået og skriver ut
		if (brutto <= 164100) {
			showMessageDialog(null, "Du bataler ikke toppskatt");
		} else if (brutto <= 230950) {
			showMessageDialog(null, "Du ligger på trinn 1. Sats: 0,93%");
		} else if (brutto <= 580650) {
			showMessageDialog(null, "Du ligger på trinn 2. Sats: 2,41%");
		} else if (brutto <= 934050) {
			showMessageDialog(null, "Du ligger på trinn 3. Sats: 11,52%");
		} else {
			showMessageDialog(null, "Du ligger på trinn 4. Sats: 14,52%");
		}

	}

}
