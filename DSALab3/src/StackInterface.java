
public interface StackInterface<T> {
	
	void push(T item);
	
	T pop();
	
	int size();
	
	boolean isEmpty();
	
	void Clear();
	
	T first();
	
	T next();

}
