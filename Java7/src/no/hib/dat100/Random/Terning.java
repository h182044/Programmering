package no.hib.dat100.Random;

import java.util.Arrays;
import java.util.Random;

public class Terning {
	private int terning;
	private int[] antallKast = new int[6];
	private int[] Kast;
	private int antall;

	public Terning(int antall) {
		this.antall = antall;
		Kast = new int[antall];
		for(int i = 0; i < antall; i++) {
			terning = new Random().nextInt(6);
			Kast[i] = terning;
			antallKast[terning]++;
		}
	}
	public double Gjennomsnitt() {
		double gjennomsnitt = 0;
		for(int i = 0; i < antall; i++) {
			gjennomsnitt += Kast[i];
		}
		gjennomsnitt /= antall;
		return gjennomsnitt;
	}
	public int flestAv() {
		int flestAv = 0;
		int max = 0;
		for(int i = 0; i < 6; i++) {
			if(antallKast[i] > max) {
			max = antallKast[i];
			flestAv = i;
			}
		}
		return flestAv + 1;
		
	}
	public int forsteSekser() {
		boolean funnet = false;
		int i = 0;
		while(!funnet && i < antall) {
			if(Kast[i] == 5) {
				funnet = true;
			}else {
				i++;
				}
		}
		if(!funnet) {
			return -1;
		}else {
			return i+1;
		}
	}

	public int getTerning() {
		return terning;
	}

	public int[] getAntallKast() {
		return antallKast;
	}

	public int[] getKast() {
		return Kast;
	}

	public int getAntall() {
		return antall;
	}

	@Override
	public String toString() {
		return "Terning [antallKast=" + Arrays.toString(antallKast) + ", Kast=" + Arrays.toString(Kast) + "]";
	}


}
