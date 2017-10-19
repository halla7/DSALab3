
public class MyStack<T> implements StackInterface<T> {

	private class Node<T> {
		public T data;
		public Node<T> next;

		
		public Node(T o) {
			this.data = o;
			this.next = null;
		}
	}
	
	MyLinkedList list = new MyLinkedList();
	private Node<T> head;
	public MyStack() {
		head = null;
	
	}

	@Override
	public void push(T item) {
//		Node<T> newHead = new Node<T>(item);
//		newHead.next = head;
//		head = newHead;
		list.shift(1);
		list.add(0, item);
	}
		

	@Override
	public T pop() {
		
		return null;
	}

	@Override
	public int size() {
		
		return 0;
	}

	@Override
	public boolean isEmpty() {
	
		return false;
	}

	@Override
	public void Clear() {
	
		
	}

	@Override
	public T first() {
		
		return null;
	}

	@Override
	public T next() {
	
		return null;
	}
	

}
