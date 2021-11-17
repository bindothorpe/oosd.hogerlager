package cui;

import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		
		@SuppressWarnings("unused")
		HogerLagerApplicatie app = new HogerLagerApplicatie(dc);
	}
	
}
