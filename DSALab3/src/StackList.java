public class StackList<T> implements StackInterface2<T> {

	private class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T o) {
			this.data = o;
			this.next = null;
		}
	}
	private int size=0;
	private Node<T> head;	
	private Node<T> tail;
	private String name;
	
	public StackList(){
		
	}
	
	public StackList(String name){
		this.name = name;
	}
	
	public boolean add(int index, T t) {
		if (index < 1 || index > size) {
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
		Node n = new Node(o);
		
		if(size == 0) {  //might need to reverse this logic for a stack
			head = n;
			tail = head;
			tail.next =null;
		} else {
//			tail.next=n
			tail = n;
			tail.next=null;
		}
		
		size++;
		return true;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(T o) {
		boolean flag = false;
		Node<T> current=head;
		Node<T> nextone=head.next;
		
		do {
			if (current.equals(o))
				return true;
			else {
				current=nextone;
				nextone=current.next;
			}
		} while (current!=head);
		return flag;
	}

	@Override
	public T get(int index) {
		Node<T> current=head;
		Node<T> nextone=head.next;
		for (int i=0; i<index; i++) {
			current=nextone;
			nextone=current.next;
//			System.out.println(current.data.toString());
		}
		return current.data;
	}

	@Override
	public int indexOf(T o) {
		int mCount = 0;
		Node<T> current=head;
		Node<T> nextone=head.next;
		
		do {
			if (current.equals(o))
				return mCount;
			else {
				current=nextone;
				nextone=current.next;
				mCount+=1;
			}
		} while (current!=head);
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
		Node<T> prevone=null;
		Node<T> current=head;
		Node<T> nextone=head.next;
		for (int i=0; i<index; i++) {
			prevone=current;
			current=nextone;
			nextone=current.next;
		}
		if (prevone!=null)
			prevone.next=current.next;
		return current.data;
	}

	@Override
	public T remove(T o) {
		Node<T> prevone=tail;
		Node<T> current=head;
		Node<T> nextone=head.next;
		do {
			if (current.equals(o))
				prevone.next=current.next;
			else {
				prevone=current;
				current=nextone;
				nextone=current.next;
			}
		} while (current!=head);
		return current.data;
	}

	@Override
	public boolean set(int index, T element) {
		Node<T> prevone=null;
		Node<T> current=head;
		Node<T> nextone=head.next;
		for (int i=0; i<index; i++) {
			prevone=current;
			current=nextone;
			nextone=current.next;
		}
		if (prevone!=null) {
			current.data=element;
			return true;
		}
		
		return false;
	}

	@Override
	public int size() {
//		size=0;
//		Node<T> current=head;
//		while (current.next!=head) {
//			current=current.next;
//			size+=1;
//			}
		return size;
	}

	@Override
	public StackList subList(int fromIndex, int toIndex) {
		StackList myList = new StackList();
		Node<T> current=head;
		if (size()<toIndex-fromIndex)
			return null;
		for (int i=0; i<fromIndex; i++) {
			current=current.next;
		}
		for (int i=fromIndex; i<toIndex; i++) {
			myList.add(current);
			current=current.next;
		}
		return myList;
	}

	@Override
	public T[] toArray() {
		T[] myList = (T[]) new Object[size];
		Node<T> current=head;
		int mCount=0;
		while (current.next!=head) {
			myList[mCount]=current.data;
			current=current.next;
			mCount+=1;
			}
		return myList;
	}

	@Override
	public boolean swap(int position1, int position2) {
		Node<T> prev1=head;
		Node<T> prev2=head.next;
		Node<T> swap1=head;
		Node<T> swap2=head.next;
		for (int i=0; i<position1; i++) {
			prev1=swap1;
			swap1=swap1.next;
		}
		for (int i=0; i<position2; i++) {
			prev2=swap2;
			swap2=swap2.next;
		}
		prev1.next=swap2;
		prev2.next=swap1;
		swap1.next=swap2.next;
		swap2.next=swap1.next;
		return false;
	}

	@Override
	public boolean shift(int positions) {
		@SuppressWarnings("unchecked")
		Node<T> myListNew=null;
		Node<T> current=head;
		if (positions==0) {
			return false;
		}else if (size()<Math.abs(positions)) {
			return false;
		}
		if (positions<0) {
			for (int i=0; i<size()+positions; i++) {
			   myListNew=current;
			   current=current.next;
			}
		}else {
			for (int i=0; i<positions; i++) {
				   myListNew=current;
				   current=current.next;
			}
		}
		head=myListNew;
		for (int i=Math.abs(positions); i<size()+Math.abs(positions); i++) {
			myListNew.next=current;
			myListNew=current;
			current=current.next;
		}
		tail=myListNew;
		tail.next=head;
		return true;
	}

	@Override
	public void push(T o) {
		// TODO Auto-generated method stub
		Node<T> n = new Node<T>(o);
		Node<T> prev = head;
		head=n;
		head.next=prev;
		size+=1;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		Node<T> n=head;
//		head.next=null;
		head=n.next;
		size-=1;
		return n.data;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (size<1)
			return null;
		Node<T> n=head;
		return n.data;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		Node<T> n=head.next;
		return n.data;
	}

}