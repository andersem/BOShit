
public class Person implements Lik{
	
	private String navn;
	private int personnummer;
	private boolean mann;
	private YngsteForstReseptListe resepter = new YngsteForstReseptListe();
	
	
	public Person(String navn, int personNummer, boolean mann) {
		this.navn = navn;
		this.personnummer = personNummer;
		this.mann = mann;
	}
	
	public String hentNavn() {
		return navn;
	}
	public int hentNummer() {
		return personnummer;
	}

	public boolean hentKjonn() {
		return mann;
	}
	public YngsteForstReseptListe hentResept() {
		return resepter;
	}

	@Override
	public boolean samme(String lik) {
		return navn.equals(lik);
	}	
}
