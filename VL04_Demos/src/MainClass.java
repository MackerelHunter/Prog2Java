
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//doExperiment1();
		//doExperiment2();
		//doExperiment3();
		doExperiment4();
	}
	
	//*** Flexibilität ohne Generics
	static void doExperiment1() {
		String s = "Die Ladung";
		Long lo = 4234234234L;
		
		ObjectTruck oTruck = new ObjectTruck();
		oTruck.load(s);
		// Codezeilen....
		// String s2 = oTruck.unload(); // Hier weiß String nicht, ob sich hinter dem Object von unload ein String befindet
		String s2 = (String) oTruck.unload(); // Expliziter Cast notwendig
		//Man muss buchführen, was unload ausspuckt
		oTruck.load(lo);
		//10000 Codezeilen....
		//Ich habe vergessen, dass da ein Long und kein String drin ist
		s2 = (String) oTruck.unload(); // Er meckert nicht, aber es produziert eine Exception
		//Problematisch: Ich muss ständig buchführen => Fehlen von Typsicherheit
		//Objecttruck soll selber aufpassen, was er beinhaltet
	}
	
	static void doExperiment2() {
		String s = "Die Ladung";
		Long lo = 4234234234L;
		
		Truck<String> stringTruck = new Truck<>(); // Jetzt nimmt der Truck nur Strings! (<> ist der Diamantoperator)
		// stringTruck.load(lo); //Geht nicht, da der Compiler schon erkennt, dass stringTruck nur Strings nimmt!
		stringTruck.load(s);
		Truck<Long> longTruck  = new Truck<>();
		longTruck.load(lo);
		String s2 = stringTruck.unload();
		System.out.println(s2);
	}
	
	static void doExperiment3() {
		String s = "String";
		TextTruck<String> sTruck = new TextTruck<String>();
		sTruck.load(s);;
		sTruck.tellLength();
		TextTruck<StringBuffer> sbTruck = new TextTruck<StringBuffer>(); // kann auch einen StringBuffer reinladen
		sbTruck.load(new StringBuffer("Pufferstring"));
		sbTruck.tellLength(); // Wir können tellLength() aufrufen, weil der Paremeter die CharSequence extended (siehe TextTruck.java)
		// sTruck = new TextTruck<StringBuffer>(); // Macht er nicht, weil wir sTruck mit String parametrisiert haben
	}
	
	//*** Wildcards einsetzen
	static boolean isATruckEmpty(Truck<?> t1, Truck <?> t2) { //Will zwei Truckobjekte reintun können, aber die sollen beliebig parametrisiert sein können
		return ((t1.unload()==null) || (t2.unload()==null)); //Ist einer der beiden Trucks "leer"?
	}
	
	static void doExperiment4() {
		Truck<String> t1 = new Truck<>();
		t1.load("Ladung hehe");
		Truck<Long> t2 = new Truck<>();
		System.out.println(isATruckEmpty(t1, t2));
	}
}
