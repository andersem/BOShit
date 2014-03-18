
public class Personprodusent {
	
	private String navn;
	private static int personNummer;
	private boolean mann;
	
	public Personprodusent(String navn, boolean mann) {
		this.navn = navn;
		this.mann = mann;
	}
	public Person nyPerson() {
		Person person = new Person(navn, personNummer, mann );
		personNummer++;
		return person;
	}

}
