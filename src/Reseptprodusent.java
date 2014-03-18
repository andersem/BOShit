
public class Reseptprodusent {
		
	private static int reseptNummer;
	
	public static Resept nyResept(boolean blaa, int reit, Lege lege, Person person, Legemiddel legemiddel) {
		Resept resept = new Resept(blaa, reit, lege, person, legemiddel, reseptNummer);
		reseptNummer++;
		return resept;
	}
}

