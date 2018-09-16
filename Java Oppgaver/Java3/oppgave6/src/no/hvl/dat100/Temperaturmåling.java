package no.hvl.dat100;

public class Temperaturmåling extends EasyGraphics{

	int[] temp = {8,18,17,18,16,25,14};
	String[] dag = {"Man", "Tir", "Ons", "Tor", "Fre", "Lør", "Søn"};
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void run() {
		makeWindow("Temperatur", 700, 500);
		setFont("Arial", 30);
		String txt = "Temperatur for uke:";
		setFont("Arial", 24);
		drawString(txt, 10,25);
		int y = 425;
		int bredde = 50;
		int faktor = 15;
		int luft = 90;
		
		for(int i = 0; i < temp.length; i++) {
			int høgde = temp[i] * faktor;
			int x = 50 + (luft*i);
			setColor(125, 100, 100);
			fillRectangle(x, y-høgde, bredde, høgde);
			txt = dag[i];
			drawString(txt, x+5, y+20);
			txt = ""+temp[i];
			drawString(txt, x+10, 420-høgde);
		}
	}
}
