package Kodea;

public class IA {
	
	private static IA nireIA;
	int zailtasuna;
	
	private IA(int pZailtasuna) {
		zailtasuna = pZailtasuna;
	}
	
	public IA getIA(int pZailtasuna) {
		if (nireIA==null) {
			nireIA = new IA(pZailtasuna);
		}
		return nireIA;
	}
	
	public IA getIA() {
		return nireIA;
	}
}
