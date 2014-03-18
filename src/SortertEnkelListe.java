import java.util.Iterator;

public class SortertEnkelListe<T extends Lik & Comparable<T>> implements AbstraktSortertEnkelListe<T>, Iterable<T>{
	
	private Node<T> forste;
	private Node<T> siste;
	public int antall;

	public SortertEnkelListe() {
		
		forste = new Node<T>();
		siste = new Node<T>();

		forste.neste = siste;	
		siste.forgje = forste;
	}


	@Override
	public boolean settInnElement(T t) {
		
		//Lets try this
		if (!settInnSist(t))
		{
			return false;
		}
		
		//Traveser lista backlengs
		Node<T> node = siste;
		while ((node = node.forgje) != forste) {
			if (node.forgje == forste) {
				break;
			}
			
			Node<T> venstreNode = node.forgje;
			Node<T> hogreNode = node;
			
			//Bytt plass paa nodene..
			if (hogreNode.data.compareTo(venstreNode.data) < 0) {
				venstreNode.neste = hogreNode.neste;
				hogreNode.forgje = venstreNode.forgje;
				
				venstreNode.forgje.neste = hogreNode;
				hogreNode.neste.forgje = venstreNode;
				
				hogreNode.neste = venstreNode;
				venstreNode.forgje = hogreNode;
			}
		}
		
	
		
		return true;
	}
	
	private boolean settInnSist(T data) {
		if (data == null) throw new
		NullPointerException("Ikke tillatt med null-verdier!");
		
		Node<T> node = new Node<T>(data);
		Node<T> antSist = siste.forgje;
		
		siste.forgje = node;
		antSist.neste = node;
		
		node.neste = siste;
		node.forgje = antSist;
		
		antall++;
		
		return true;
	}
	
	@Override
	public T finnElement(String nokkel) {
		Iterator<T> ith = this.iterator();
		while (ith.hasNext()) {
			T data = ith.next();
			if (data.samme(nokkel)) {
				return data;
			}
		}
		return null;
	}

	@Override
	public Iterator<T> iterator() {
	    return new Iterator<T>() {
            Node<T> node = forste;
            @Override
            public boolean hasNext() {
                return forste.neste != siste;
            }

            @Override
            public T next() {
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
