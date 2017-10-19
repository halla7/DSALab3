

public interface StackInterface2<T> {

	boolean add(int index, T t);
	
	boolean add(T o);
	
	void clear();
	
	boolean contains(T o);
	
	T get(int index);
	
	int indexOf(T o);
	
	boolean isEmpty();
	
	T remove(int index);
	
	T remove(T o);
	
	boolean set(int index, T element);
	
	int size();
	
	StackList<T> subList(int fromIndex, int toIndex);
	
	T[] toArray();
	
	boolean swap(int position1, int position2);
	
	boolean shift(int positions);
	
	void push(T o);
	
	T pop();
	
	T first();
	
	T next();
	
}