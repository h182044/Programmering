package no.hib.dat100;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static java.lang.Integer.*;

public class NFakultet {

	public static void main(String[] args) {
		int sum1 = 1; // OBS! En lokal variabel må gis verdi før vi i bruker den
		int i = 1;
		boolean gyldigInndata;
		String tallTxt = "";
		String feilmelding = "Feil inndata. Tallet er ikke et tall mellom 2 og 20.";
		String melding = "Tast inn n (et tall mellom 2 og 20): ";
		int n = 1;

		/* do-while-løkke ved innlesing */
		do {
			tallTxt = showInputDialog(null, melding);
			n = parseInt(tallTxt);
			gyldigInndata = (n >= 2) && (n <= 20);
			if (!gyldigInndata) {
				showMessageDialog(null, feilmelding);
			}
		} while (!gyldigInndata);

		/* for-løkke ved summering */
		for (i = 1; i < n; i++) { // evt.i = i + 1
			sum1 = sum1 * i;

			System.out.print(i + " * ");
		}
		System.out.println(n + " = " + (sum1));

	}
}
