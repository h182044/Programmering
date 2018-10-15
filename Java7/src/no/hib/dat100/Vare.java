package no.hib.dat100;

public class Vare {
	private int varenr;
	private String navn;
	private double pris;
	
	public Vare() {
		varenr = -1;
		navn = "";
		pris = 0.0;
	}
	public Vare(int varenr, String navn, double pris) {
		this.varenr = varenr;
		this.navn = navn;
		this.pris = pris;
	}
	public int getVarenr() {
		return varenr;
	}
	public void setVarenr(int varenr) {
		this.varenr = varenr;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public double getPris() {
		return pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}
	public double moms() {
		pris = pris + ((pris/100) * 20.0);		
		return pris;		
	}
	public boolean billigereEnn(Vare v) {
		if(this.pris < v.getPris()) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		String s = "Varenr: " + this.varenr + ". Navn: " + this.navn + ". Pris: " + this.pris; 
		return s;
	}

}
