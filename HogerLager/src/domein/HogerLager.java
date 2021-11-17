package domein;

public class HogerLager {

	private KaartRepository kRepo;
	
	private Kaart huidigeKaart;
	private Kaart vorigeKaart;
	
	private int score = 0;
	private int keuze = 0;
	
	public HogerLager() {
		this.kRepo = new KaartRepository(); // Creatie van alle kaarten
		huidigeKaart = kRepo.trekKaart(); // Trek de bovenste kaart
	}

	public Kaart getHuidigeKaart() {
		return huidigeKaart;
	}

	public Kaart getVorigeKaart() {
		return vorigeKaart;
	}
	
	public void trekKaart() {
		vorigeKaart = huidigeKaart;
		huidigeKaart = kRepo.trekKaart();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getKeuze() {
		return keuze;
	}

	public void setKeuze(int keuze) {
		this.keuze = keuze;
	}
	
	public int aantalResterendeKaarten() {
		return kRepo.aantalResterendeKaarten();
	}
	
	
	
}
