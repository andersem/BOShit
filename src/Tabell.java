import java.util.Iterator;

public class Tabell<T extends Lik> implements AbstraktTabell<T>, Iterable<T> {

	public int antall;
	private Object[] tabell;
	
	public Tabell(int arrayLengde) {
		tabell = new Object[arrayLengde];
	}
	@Override
	public boolean settInnObjekt(T data, int index) {
		try {
			sjekkKapasitet();
			if (index > antall) {
				return false;
			}
			// Lag plass til objekt p� index
			if (tabell[index] != null) {
				for (int i = antall; i > index; i--) {
					tabell[i] = tabell[i - 1];
				}
			}

			tabell[index] = data;
			antall++;

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// Blir alltid kj�rt, f.eks lurt hvis du bytte te loadcursor
			// � setta tebage te vanlige :P
			// eller avslutta database tilkoblingar and shit
		}
	}

	/*
	 * Sjekker ledig plass og utvider 150% dersom der er fullt.
	 */
	private void sjekkKapasitet() {
		if (antall + 1 > tabell.length) {
			Object[] gammelTabell = tabell;
			tabell = new Object[(int) (gammelTabell.length * 1.5)];

			for (int i = 0; i < gammelTabell.length; i++) {
				tabell[i] = gammelTabell[i];
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lister.AbstraktTabell#finnObjekt(int)
	 */
	@Override
	public T finnObjekt(int index) {
		return (T) tabell[index];
	}


	public T finnObjektFraNokkel(String nokkel) {
		for (int i = 0; i < antall; i++) {
			if (((T) tabell[i]).samme(nokkel)) {
				return (T) tabell[i];
			}
		}
		return null;
	}

	@Override
	public void tom() {
		for (int i = 0; i < antall; i++) {
			tabell[i] = null;
		}

		antall = 0;
	}

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int posisjon = -1;
            @Override
            public boolean hasNext() {
                return posisjon + 1 < tabell.length;
            }

            @Override
            public T next() {
                return (T) tabell[++posisjon];
            }

            @Override
            public void remove() {

            }
        };
    }


}
