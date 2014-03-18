import java.util.Iterator;

public class YngsteForstReseptListe {
	private final EnkelReseptListe liste = new EnkelReseptListe();
	
	public boolean settInnElement(Resept resept) {
		return liste.settInnSist(resept);
	}

	public Resept finnElement(String nokkel) {
		return liste.finnElement(nokkel);
	}

	public Iterator<Resept> iterator() {
		return liste.iterator();
	}
}
