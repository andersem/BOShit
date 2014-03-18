import java.util.Iterator;

public class EnkelReseptListe{

	private Node<Resept> forste;
	private Node<Resept> siste;
	public int antall;

	public EnkelReseptListe() {

		forste = new Node<Resept>();
		siste = new Node<Resept>();

		forste.neste = siste;
		siste.forgje = forste;
	}

	public boolean settInnObjekt(Resept data) {
		return settInnSist(data);
	}

	public boolean settInnForst(Resept data) {
		if (data == null) throw new
		NullPointerException("Ikke tillatt med null-verdier!");

		Node<Resept> node = new Node<Resept>(data);
		Node<Resept> andreNode = forste.neste;

		forste.neste = node;
		andreNode.forgje = node;

		node.forgje = forste;
		node.neste = andreNode;

		antall++;

		return true;
	}

	public boolean settInnSist(Resept data) {
		if (data == null) throw new
		NullPointerException("Ikke tillatt med null-verdier!");

		Node<Resept> node = new Node<Resept>(data);
		Node<Resept> antSist = siste.forgje;

		siste.forgje = node;
		antSist.neste = node;

		node.neste = siste;
		node.forgje = antSist;

		antall++;

		return true;
	}

	public String hentListeData() {
		String data = "";
		Iterator<Resept> ith = iterator();
		while (ith.hasNext()) {
			data += ith.next().toString() + "\n";
		}

		return data;
	}

	public Iterator<Resept> iterator() {
//		return new MinListeIterator<Resept>(forste, siste);
        return new Iterator<Resept>() {
            Node<Resept> node = forste;
            @Override
            public boolean hasNext() {
                return node != siste;
            }

            @Override
            public Resept next() {
                if (!hasNext()) {
                    throw new IllegalStateException ("Ingen flere noder, dust");
                }

                node = node.neste;
                return node.data;
            }

            @Override
            public void remove() {

            }
        };
	}


	public Resept finnElementFraPersonNummer(int personNummer) {
		Iterator<Resept> ith = this.iterator();
		while (ith.hasNext()) {
			Resept data = ith.next();
			if ((data.hentPerson().hentNummer() == personNummer)) {
				return data;
			}
		}
		return null;
	}

	public Resept finnElementFraNummer(int reseptnummer) {
		Iterator<Resept> ith = this.iterator();
		while (ith.hasNext()) {
			Resept data = ith.next();
			if ((data.hentReseptNummer() == reseptnummer)) {
				return data;
			}
		}
		return null;
	}


	public Resept finnElement(String nokkel) {
		Iterator<Resept> ith = this.iterator();
		while (ith.hasNext()) {
			Resept data = ith.next();
			if ((data.hentLegemiddel().hentNavn()).equals(nokkel) ||
					data.hentPerson().hentNavn().equals(nokkel) ||
					data.hentLege().hentNavn().equals(nokkel)) {
				return data;
			}
		}
		return null;
	}

	/*
	 * Intern Node klasse for lister
	 */
	class Node<E> {
		public final E data;

		public Node<E> forgje;
		public Node<E> neste;

		public Node() {
			data = null;
		}

		public Node(E data) {
			this.data = data;
		}
	}
}