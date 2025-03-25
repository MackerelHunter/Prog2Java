
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eingabeExperimente();
		inselExperimente();
		BrandAufgabe1.brandAufgabe1();
	}
	
	static void eingabeExperimente() {
		EingabeExperimente.setEingabe();
		System.out.println(EingabeExperimente.getEingabe());
		System.err.println("Dies ist eine Fehlermeldung");
	}
	
	static void inselExperimente() {
		// -=- ist letztendlich +=
		int i = 1;
		i -=- i;
		System.out.println(i);
		
		//char werden automatisch zu int umgewandelt
		//UTF-16 Position 122 ist z
		char charToInt = 'z';
		int charNowInt = charToInt;
		System.out.println(charNowInt);
		
	}
	

}
