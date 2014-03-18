import java.util.Iterator;

public class EldsteForstReseptListe {
	private final EnkelReseptListe liste = new EnkelReseptListe();

	public boolean settInnElement(Resept resept) {
		return liste.settInnForst(resept);
	}

	public Resept finnElement(String nokkel) {
		return liste.finnElement(nokkel);
	}

	public Iterator<Resept> iterator() {
		return liste.iterator();
	}
}
