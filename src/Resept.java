
public class Resept {
	private boolean blaa = false;
	private int reseptNummer;
	private int reit;
	private Lege lege;
	private Person person;
	private Legemiddel legemiddel;
	public Resept neste;

	public Resept(boolean blaa, int reit, Lege lege, Person person,
			Legemiddel legemiddel, int reseptNummer) {
		this.blaa = blaa;
		this.reit = reit;
		this.lege = lege;
		this.person = person;
		this.legemiddel = legemiddel;
		this.reseptNummer = reseptNummer;
	}

	/*
	 * Sjekker om dette er en bl� resept, setter prisen p� legemiddelet i
	 * resepten til 0.0 dersom blaa == true
	 */
	public double hentPris() {
		if (blaa == true) {
			return 0.0;
		}
		return legemiddel.hentPris();
	}

	public Legemiddel hentLegemiddel() {
		return legemiddel;
	}

	public Person hentPerson() {
		return person;
	}

	public Lege hentLege() {
		return lege;
	}

	public int hentReseptNummer() {
		return reseptNummer;
	}

	public boolean brukResept() {
		if (reit < 1) {
			System.out.println("Resepten er oppbrukt.");
			return false;
			
		}
		reit--;
		reseptInfo();
		System.out.println("Det er "+reit+" reit igjen.");
		return true;
	}
	
	public void reseptInfo() {
		System.out.println("Pris: "+ hentPris());
		System.out.println("Lege: "+ hentLege().hentNavn());
		System.out.println("Person: "+hentPerson().hentNavn());
		System.out.println("");
		System.out.println("Legemiddel INFO");
		System.out.println("Navn: "+hentLegemiddel().hentNavn());
		System.out.println("Type: "+hentLegemiddel().hentType());
		if(!hentLegemiddel().hentType().equals("C")) {
			System.out.println("Egenskap: "+hentLegemiddel().hentEgenskap());
		}
		System.out.println("Format :"+hentLegemiddel().hentFormat());
		System.out.println("Mengde: "+hentLegemiddel().hentMengde());
	}
	
	public int hentReit() {
		return reit;
	}
	
	public String toString() {
		return "Resept(" + "lege=" + lege + ", person=" + person
				+ ", legemiddel=" + legemiddel + ")";
	}
}
