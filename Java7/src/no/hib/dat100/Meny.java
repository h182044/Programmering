package no.hib.dat100;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

public class Meny {
	private Grensesnitt gr;
	private Varelager lager;
	
	public Meny(Varelager v) {
		gr = new Grensesnitt();
		this.lager = v;
	};
	
	public void start() {
		System.out.println(" Meny");
		System.out.println(" 1 - Registrer");
		System.out.println(" 2 - Søk");
		System.out.println(" 3 - Slett");
		System.out.println(" 4 - VisAlle");
		System.out.println(" 5 - VisAlleSortert");
		System.out.println(" 9 - Avslutt");
		
		int nr = -1;
		int kode = -1;
		Vare vare = null;
		do {
			String tallTxt = showInputDialog("Kode:");
			kode = parseInt(tallTxt);
			
			switch(kode) {
				case 1:
					gr.lesFlereVarer(lager);
					break;
				case 2:
					tallTxt = showInputDialog("Oppgi varenr");
					nr = parseInt(tallTxt);
					if(!lager.soekVare(nr)) {
						System.out.println("Varen er ikke registrert");
					}else {
						vare = lager.getLager()[nr];
						System.out.println("Varen som ble søkt etter:");
						gr.skrivVare(vare);
					}
					break;
				case 3:
					tallTxt = showInputDialog("Oppgi varenr");
					nr = parseInt(tallTxt);
					lager.slett(nr);
					break;
				case 4:
					gr.visAlle(lager);
					break;
				case 5:
					gr.visAlleSortert(lager);
					break;
				case 9:
					System.out.println("\nAvsluttet");
					break;
				default:
					System.out.println("Feil kode");
				}
			}while(kode != 9);
			
		}
	}


