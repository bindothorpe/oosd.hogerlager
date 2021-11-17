package domein;

public class DomeinController {

	private HogerLager hogerLagerSpel;
	
	public void startNieuwSpel() {
		this.hogerLagerSpel = new HogerLager();
	}
	
	public HogerLager getHogerLager() {
		return hogerLagerSpel;
	}
	
	
	
}
