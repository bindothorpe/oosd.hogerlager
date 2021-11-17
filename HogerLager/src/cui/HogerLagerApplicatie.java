package cui;

import java.util.Scanner;

import domein.DomeinController;
import domein.HogerLager;
import domein.Kaart;

public class HogerLagerApplicatie {

	private DomeinController dc;
	private Scanner scanner;

	public HogerLagerApplicatie(DomeinController dc) {
		this.dc = dc;
		this.scanner = new Scanner(System.in);
		
		startNieuwSpel();
	}
	
	
	private void startNieuwSpel() {
		dc.startNieuwSpel();
		HogerLager hl = dc.getHogerLager();
		toonHuidigeKaart();
		while(hl.getScore() < 15) {
			maakKeuze();
			
			if(isCorrectGekozen()) {
				hl.setScore(hl.getScore() + 1);
				System.out.printf("Correct! Je score is nu %d%n", hl.getScore());
			} else {
				System.out.printf("Fout! Je score is %d%n", hl.getScore());
			}
			
			toonHuidigeKaart();
		}
		
		toonWinnendBricht();
		
	}

	private void toonWinnendBricht() {
		int aantalGeraden = 51 - dc.getHogerLager().aantalResterendeKaarten();
		
		System.out.printf("Je bent gewonnen! Je hebt in totaal %d keren geraden.%n", aantalGeraden);
		System.out.printf("Wil je opnieuw spelen? JA (1), NEE (0): ");
		int keuze = scanner.nextInt();
		
		if(keuze == 1) {
			startNieuwSpel();
		} else {
			System.exit(1);
		}
		
	}


	public void toonHuidigeKaart() {
		Kaart k = dc.getHogerLager().getHuidigeKaart();
		System.out.printf("De huidige kaart is %s %d%n", k.getTeken(), k.getWaarde());
	}

	public void maakKeuze() {
		int keuze = 0;
		do {
			System.out.printf("Is de volgende kaart hoger (1) of lager (0): ");
			keuze = scanner.nextInt();
		} while (keuze < 0 || keuze > 1);
		
		dc.getHogerLager().setKeuze(keuze);
	}
	
	public boolean isCorrectGekozen() { 
		HogerLager hl = dc.getHogerLager();
		int keuze = hl.getKeuze();
		hl.trekKaart();
		
		if(keuze == 1) {
			if(hl.getVorigeKaart().getWaarde() <= hl.getHuidigeKaart().getWaarde())
				return true;
			return false;
		} else {
			if(hl.getVorigeKaart().getWaarde() >= hl.getHuidigeKaart().getWaarde())
				return true;
			return false;
		}
		
	}
	
	
	
}
