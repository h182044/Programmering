package no.hib.dat100;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.Arrays;

public class Grensesnitt {
	
	public Grensesnitt() {
	}
	
	public void lesFlereVarer(Varelager reg) {
		String ledetekst = "Programmet leser inn vareinformasjon";
		System.out.println(ledetekst);
		String tallTxt = showInputDialog("Oppgi antall registreringer");
		int ant = parseInt(tallTxt);
		Vare v = null;

		
		for(int i = 0; i < ant; i++) {
			v = lesVare();
			reg.leggTil(v);
		}
		
	}
	public void visAlle(Varelager v) {
		System.out.println("\nAlle Varer");
		Vare vare = null;
		for(int i = 0; i < v.getAntall(); i++) {
			vare = v.getLager()[i];
			skrivVare(vare);
		}
	}
	
	public void visAlleSortert(Varelager v) {
		System.out.println("\nSkriver ut studentopplysningene sortert");
		int stor = v.getAntall();
		String[] nrTab = new String[stor];
		for(int i = 0; i < nrTab.length; i++) {
			nrTab[i] = v.getLager()[i].toString();
		}
		Arrays.sort(nrTab);
		
		for(int i = 0; i < nrTab.length; i++) {
			System.out.println(nrTab[i]);
		}
	}
	
	
	public Vare lesVare() {
		String t = showInputDialog("Oppgi VareNr");
		int vareNr = parseInt(t);
		String varenavn = showInputDialog("oppgi VareNavn");
		String prisTxt = showInputDialog("Oppgi Pris: ");
		double pris = parseDouble(prisTxt);
		
		Vare vare = new Vare(vareNr,varenavn,pris);
		
		return vare;
	}
	void skrivVare(Vare vare) {
		System.out.println(vare);
	}

}
