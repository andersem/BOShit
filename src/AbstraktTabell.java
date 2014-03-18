

public interface AbstraktTabell<T extends Lik> {

	public boolean settInnObjekt(T t, int index); 
	
	public T finnObjekt(int index);

	void tom();

}
