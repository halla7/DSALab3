
public class MyLinkedList<T> implements MyList<T> {

	private class Node<T> {
		public T data;
		public Node<T> next;

		
		public Node(T o) {
			this.data = o;
			this.next = null;
		}
	}
	private int size;
	private Node<T> head;	
	private Node<T> tail;
	private T myItem;
	
	public MyLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	@Override
	public boolean add(int index, T t) {
		if (index < 0 || index < size) {
			throw new
			IndexOutOfBoundsException(index + " < 0 or >= " + size);
		} else if (index == size) {	
			add(t);
		} else if (index == 0) {
			Node<T> n = new Node<T>(t);
			head = n;
			size++;
		} else {
			Node<T> prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			
			Node<T> after = prev.next;
			Node<T> n = new Node<T>(t);
			
			prev.next = n;
			
			size++;
			
		}
		
		return false;
	}

	@Override
	public boolean add(T o) {
		Node<T> n = new Node<T>(o);
		if(head == null) {
			head = new Node<T>(o);
			size++;
		} else {
			Node<T> temp = new Node<T>(o);
			temp.next = head;
			head = temp;
			size++;
		}
		
		if(size == 0) {		// If the list is empty
			head = n;		// The first node is n
		} else {
			tail.next = n;	// if it is not empty, make the node after the last node = n 
		}
		tail = n;			// update the last node to be n
		
		size++;            // increment size
		return true;
	}

	@Override
	public boolean clear() {
		// clear all fields;
		head = null;
		tail = null;
		size = 0;
		return false;
	}

	@Override
	public boolean contains(T o) {
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			head = head.next;
			if (head.data.equals(o)) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public T get(int index) {
		Node<T> current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		myItem = current.data;
		return myItem;
	}

	@Override
	public int indexOf(T o) {
		Node<T> current = head;
		int index = 0;
		while (current != null) {
			if (o == null) {	// if o is null find null item in list
				if(current.data == null) {	
					return index;	
				}
			} else {
				if(o.equals(current.data)) {	// if o 
					return index;
				}
			}
			index++;
			current = current.next;
		}
		
		return -1;
	}

	@Override
	public boolean isEmpty() {
		boolean flag = false;
		if (size == 0) {
			flag = true;;
		} else {
			return flag;
		}
		return flag;
	}

	@Override
	public T remove(int index) {
	
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
			current.data = null;
			size--;
		return current.data;
	}

	@Override
	public T remove(T o) {
		int index = indexOf(o);
		if (index == -1) {
			myItem = null;//object is not in list;
		}
			
		return remove(index);
	}

	@Override
	public boolean set(int index, T element) {
		if (index < 0 || index > size) {
			throw new 
			IndexOutOfBoundsException(index + "is out of bounds.");
		} else {
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
			current.data = element;
			size++;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public MyList subList(int fromIndex, int toIndex) {
		
		return null;
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size];
		
		for(int i = 0; i < size; i++) {
			head = head.next;
			array[i] = head.data;
		}
		return array;
	}

	@Override
	public boolean swap(int position1, int position2) {
		Node<T> current = head;
		for (int i = 0; i < size; i++) {
			current = current.next;
		}
		return false;
	}

	@Override
	public boolean shift(int positions) {
		Node<T> current = head;
		
		T[] temp = toArray();
		
		for (int i = 0; i < size; i++) {
			
		}
		return false;
	}

	
		
}