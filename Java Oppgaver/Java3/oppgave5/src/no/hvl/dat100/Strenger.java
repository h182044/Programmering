package no.hvl.dat100;

public class Strenger {
	
	
	public static String baklengs(String s) {
		String ny = "";
		
		for(int i = s.length()-1; i >= 0; i--) {
			ny += s.charAt(i);
		}
		return ny;
	}
	public static boolean sortertStigande(int[] tab) {
		boolean sann = true;
		int i = 0;
		int siste = tab[0];
		do {
			if(siste <= tab[i]) {
				siste = tab[i];
			}else {
				sann = false;
			}
			i++;
		}while(i < tab.length && sann);
		return sann;
		
	}
	public static String alfabetisk(String[] s) {
		String q = "z";
		
		for(int i = 0; i < s.length; i++) {
			if(q.compareTo(s[i]) >= 0) {
				q = s[i];
			}
		}
		return q;
		
	}
	
}
