public class Legemiddel implements Format, Lik {

	private String navn;
	private int legemiddelNummer;
	private double pris;
	private String type;
	private int egenskap;
	private String fysiskformat;
	private double storrelse;
	
	Legemiddel(String navn, int legemiddelNummer, double pris, String fysiskformat, double storrelse, String type, int egenskap) {
		this.navn = navn;
		this.legemiddelNummer = legemiddelNummer;
		this.pris = pris;
		this.type = type;
		this.egenskap = egenskap;
		this.fysiskformat = fysiskformat;
		this.storrelse = storrelse;
	}

	public String hentNavn() {
		return navn;
	}
	
	public int hentNummer() {
		return legemiddelNummer;
	}
	public double hentPris() {
		return pris;
	}
	
	public String hentType() {
		return type;
	}
	
	public int hentEgenskap() {
		return egenskap;
	}
	public String hentFormat() {
		return fysiskformat;
	}
	
	public int hentMengde() {
		String format = hentFormat();
		int mengde = 0;
		if(format.toLowerCase().equals("pille")){
			mengde = pille();
		}
		if(format.toLowerCase().equals("liniment") || format.toLowerCase().equals("salve")){
			mengde = liniment();
		}
		if(format.toLowerCase().equals("injeksjon") || format.toLowerCase().equals("spr�yte")){
			mengde = injeksjon();
		}
		return mengde;
	}
	@Override
	
	public boolean samme(String lik) {
		return navn.equals(lik);
	}
	
	@Override
	public int pille() {
		
			return (int) storrelse;

	}

	@Override
	public int liniment() {
			return (int) storrelse;
	}
	@Override
	public int injeksjon() {
			return (int) storrelse;

	}
}

