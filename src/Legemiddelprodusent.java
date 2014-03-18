
public class Legemiddelprodusent {
	

	private static int legemiddelNummer;

	
	
	/*
	 * nyttLegemiddel() produserer et nytt legemiddel og returnerer dette.
	 * L�penummer oppdateres etter at legemiddelet opprettes. Dvs n�v�rende legemiddelNummer brukes.
	 */
	public static Legemiddel nyttLegemiddel(String navn, double pris, String fysiskformat, double storrelse, String type, int egenskap) {
		Legemiddel legemiddel = new Legemiddel(navn, legemiddelNummer, pris, fysiskformat, storrelse,type,egenskap);
		legemiddelNummer++;
		return legemiddel;
	}
	
	public static Legemiddel nyttLegemiddel(String navn, double pris, String fysiskformat, double storrelse, String type) {
		Legemiddel legemiddel = new Legemiddel(navn, legemiddelNummer, pris, fysiskformat, storrelse, type,-1);
		legemiddelNummer++;
		return legemiddel;
	}
}
