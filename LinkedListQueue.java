public class LinkedListQueue<E> implements Queue<E> {

	private Node<E> head;
	private Node<E> tail;

	public LinkedListQueue() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {

		return head == null;

	}

	public void clear() {

		head = null;
		tail = null;
	}

	

	public void enqueue( E obj, Node<E> selectedNode ) {

		if ( isEmpty() ) {
			Node<E> newElement = new Node<E>(obj);
			tail = newElement;
			head = tail;
		} else {
			Node<E> newElement = new Node<E>( obj, selectedNode);
			tail.next = newElement;
			tail = newElement;
		}

	}

	public E dequeue() {

		if ( isEmpty() ) {
			return null;
		}

		
	}

}