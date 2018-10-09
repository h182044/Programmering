package no.hvl.dat100;

import java.util.Arrays;

public class Main {

	static int[][] matrise1 = new int[8][8];
	static int[][] matrise2 = new int[8][8];
	static int[][] matrise3 = new int[8][8];
	static int[][] matrise4 = new int[8][8];
	static int[] rekke1 = {1,3,5,7,9};
	static int[] rekke2 = {0,2,4,6,8,10};

	public static void main(String[] args) {
		System.out.println("1:");
		Matriser.FyllMatrise(matrise1);
		Matriser.skrivutv1(matrise1);
		System.out.println("----------------------");
		System.out.println("2:");
		Matriser.FyllMatrise(matrise2);
		Matriser.skrivutv1(matrise2);
		System.out.println("----------------------");
		System.out.println("3:");
		Matriser.skaler(8, matrise2);
		Matriser.skrivut2(matrise2);
		System.out.println("----------------------");
		System.out.println("4:");
		Matriser.speile(matrise1);
		Matriser.skrivut2(matrise1);
		System.out.println("----------------------");
		System.out.println("5:");
		Matriser.multipliser(matrise1, matrise2);
		Matriser.skrivut2(matrise2);
		System.out.println("----------------------");
		System.out.println("6:");
		skrivArray(flette(rekke1,rekke2));
		System.out.println();
		System.out.println("----------------------");
		System.out.println("7:");
		System.out.println(equals(matrise3,matrise4));
		Matriser.skrivut2(matrise4);
	}
	public static void skrivArray(int[] rekke) {
		for(int tall:rekke) {
			System.out.print(tall+ " ");
		}
		
	}
	public static int[] flette (int[] tabell1, int[] tabell2) {
		int lengde = tabell1.length + tabell2.length;
		int[] flettetrekke = new int[lengde];
		int j = 0;
		
		for(int i = 0; i < tabell1.length; i++) {
			flettetrekke[i] = tabell1[i];
		}
		for(int i = tabell1.length; i < lengde; i++) {
			flettetrekke[i] = tabell2[j];
			j++;
		}
		Arrays.sort(flettetrekke);
		return flettetrekke;
		
	}
	public static boolean equals(int[][] mat1 ,int[][] mat2) {
		boolean a = Arrays.deepEquals(mat1, mat2);
		
		return a;
		
	}

}
