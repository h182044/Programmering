package no.hvl.dat100;

public class Matriser {

	public static void FyllMatrise(int[][] matrise) {
		for (int i = 0; i < matrise.length; i++) {
			for (int j = 0; j < matrise.length; j++) {
				matrise[i][j] = (int) Math.round(Math.random());
			}
		}

	}

	public static void skrivutv1(int[][] matrise) {
		for (int i = 0; i < matrise.length; i++) {
			for (int j = 0; j < matrise.length; j++) {

				System.out.print(matrise[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void skrivut2(int[][] matrise) {
		for (int[] a : matrise) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}

	}

	public static int[][] skaler(int tall, int[][] matrise) {
		for (int i = 0; i < matrise.length; i++) {
			for (int j = 0; j < matrise.length; j++) {
				matrise[i][j] *= 8;
			}
		}
		return matrise;

	}

	public static int[][] speile(int[][] matrise) {
		for (int i = 0; i < matrise.length; i++) {
			for (int j = 0; j < matrise.length; j++) {
				matrise[i][j] = matrise[j][i];
			}
		}

		return matrise;

	}

	public static int[][] multipliser(int[][] matrise1, int[][] matrise2) {
		for (int i = 0; i < matrise1.length; i++) {
			for (int j = 0; j < matrise1.length; j++) {
				matrise2[i][j] *= matrise1[i][j];
			}
		}

		return matrise2;
	}

}
