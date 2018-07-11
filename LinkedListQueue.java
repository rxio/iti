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

	public void enqueue( E obj ) {
		
		Node<E> newElement = new Node<E>(obj);

		if ( isEmpty() ) {	
			tail = newElement;
			head = tail;
		} else {	
			tail.setNext( newElement );
			tail = newElement;
		}		

	}

	public void enqueue( E obj, Node<E> selectedNode ) {
		
		Node<E> newElement = new Node<E>( obj, selectedNode );

		if ( isEmpty() ) {	
			tail = newElement;
			head = tail;
		} else {	
			tail.setNext( newElement );
			tail = newElement;
		}

	}

	public E dequeue() {

		if ( isEmpty() ) {
			return null;
		}

		Node<E> toBeRemoved = head;
		E savedData = toBeRemoved.getData();
		head = head.getNext();

		if ( head == null ) {
			tail = null;
		}

		return savedData;
		
	}

}