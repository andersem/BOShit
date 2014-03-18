
public class Lege implements Comparable<Lege>, Lik  {

	private String navn;
	private boolean spesialist = false;
	private EldsteForstReseptListe resepter = new EldsteForstReseptListe();
	private boolean avtale = false;
	private int avtalenummer;
		
	public Lege(String navn, boolean spesialist) {
		this.navn = navn;
		this.spesialist = spesialist;
	}
	public Lege(String navn, boolean spesialist, boolean avtale, int avtalenummer) {
		this.navn = navn;
		this.spesialist = spesialist;
		this.avtale = avtale;
		this.avtalenummer = avtalenummer;
	}
	@Override
	public boolean samme(String lik) {
		return navn.equals(lik);
	}
	@Override
	public int compareTo(Lege annenLege) {
		return navn.compareTo(annenLege.navn);
	}
	public String hentNavn() {
		return navn;
	}
	
	public boolean erLegenSpesialist() {
		return spesialist;
	}
	public EldsteForstReseptListe hentResept() {
		return resepter;
	}
	public boolean hentAvtale() {
		return avtale;
	}
	public int hentAvtaleNummer() {
		return avtalenummer;
	}
	
}
