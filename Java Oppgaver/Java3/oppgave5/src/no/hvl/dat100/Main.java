package no.hvl.dat100;

public class Main {

	public static void main(String[] args) {
		//-----------------------------------------
		// Streng baklengs
		String p = "Grandiosa";
		System.out.println(Strenger.baklengs(p));
		//-----------------------------------------
		//Er tabell sortert stigande?
		int[] tab1 = {-4,1,2,3,4,5,6,7,8};
		boolean s = Strenger.sortertStigande(tab1);
		System.out.println(s);
		//-----------------------------------------
		String[] alfabetisk = {"apple","banana","cow","defence"};
		String q = Strenger.alfabetisk(alfabetisk);
		System.out.println(q);

	}

}
