package no.hvl.dat100;

import java.text.DecimalFormat;

public class Repitisjonsløkke {

	public static void main(String[] args) {
	
		double x = 0;
		String t = "    ";
		String t2 = "       ";
		System.out.print("X i Grader"+t);
		System.out.print("X i Radianer"+t);
		System.out.print("sin(x)"+t);
		System.out.println("cos(x)");
		System.out.println("-----------------------------------------");
		
		
		while(x <= 100) {
			double grader = x;
			double radianer = Math.toRadians(x);
			double sinus = Math.sin(radianer);
			double cosinus = Math.cos(radianer);
			
			DecimalFormat df = new DecimalFormat("####0.000");
			System.out.print(grader+t2);
			System.out.print(df.format(radianer)+t2);
			System.out.print(df.format(sinus)+t2);
			System.out.println(df.format(cosinus));
			
			x += 15;
		}
		System.out.println("-----------------------------------------");

	}

}
