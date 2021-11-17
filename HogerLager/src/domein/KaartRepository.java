package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KaartRepository {

	private List<Kaart> kaarten;
	
	public KaartRepository() {
		kaarten = new ArrayList<Kaart>();
		initKaarten();
		schudKaarten();
	}

	//Aanmaken van alle 52 kaarten
	private void initKaarten() {
		for(int i = 1; i <= 13; i++) {
			for(int j = 0; j < 4; j++) {
				
				String teken = switch (j) {
				case 0 -> "Harten";
				case 1 -> "Klaver";
				case 2 -> "Schoppen";
				default -> "Ruiten";
				};
				
				kaarten.add(new Kaart(i, teken));
			}
		}
		
	}

	//Schudden van alle kaarten
	private void schudKaarten() {
		Collections.shuffle(kaarten);
	}
	
	public Kaart trekKaart() {
		Kaart kaart = kaarten.get(kaarten.size() -1);
		kaarten.remove(kaarten.size() -1);
		return kaart;
	}
	
	public int aantalResterendeKaarten() {
		return kaarten.size();
	}
	
}
