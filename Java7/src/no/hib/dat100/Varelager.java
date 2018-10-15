package no.hib.dat100;

public class Varelager {
	private final static int STK = 100;
	private Vare[] lager;
	private int antall;
	
	public Varelager() {
		this(100);
		
	}
	public Varelager(int kap) {
		lager = new Vare[kap];
		antall = 0;
	}
	
	public Vare[] getLager() {
		return lager;
	}

	public int getAntall() {
		return antall;
	}
	public void leggTil(Vare v) {
		lager[antall] = v;
		antall++;
	}
	public boolean soekVare(int vareNr) {
		boolean funnet = false;
		int i = 0;
		while(i < antall && !funnet) {
			if(vareNr == lager[i].getVarenr()) {
				funnet = true;
			}
			else {
				i++;
			}
		}
		return funnet;
		
	}
	public double totalPris() {
		int i = 0;
		double total = 0.0;
		while(i < antall) {
			total += lager[i].getPris();
			i++;
		}
		return total;
		
	}
	public boolean slett(int vareNr) {
		if(soekVare(vareNr)) {
			antall--;
			lager[vareNr] = lager[antall];
			lager[antall] = null;
			
			System.out.println("Vare Slettet");
			return true;
		} else {
			System.out.println("Varen finnes ikke");
			return false;
		}
		
		
	}
	@Override
	public String toString() {
		int i = 0;
		String s = "";
		while(i < antall) {
			s += lager[i].toString();
			s += System.lineSeparator();
			i++;
		}
		
		return s;
		
	}
	

}
