public class LinkedListQueue implements Queue {

	private Node head;
	private Node tail;

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

	public void enqueue( Job element ) {
		
		Node newElement = new Node(element);

		if ( isEmpty() ) {	
			tail = newElement;
			head = tail;
		} else {	
			tail.setNext( newElement );
			tail = newElement;
		}		

	}

	public void enqueue( Job element, Node selectedNode ) {
		
		Node newElement = new Node( element, selectedNode );

		if ( isEmpty() ) {	
			tail = newElement;
			head = tail;
		} else {	
			tail.setNext( newElement );
			tail = newElement;
		}

		newElement.setData(null);
		newElement.setNext(null);

	}

	public Job dequeue() {

		if ( isEmpty() ) {
			return null;
		}

		Node toBeRemoved = head;
		Job savedData = toBeRemoved.getData();
		head = head.getNext();

		if ( head == null ) {
			tail = null;
		}

		toBeRemoved.setData(null);
		toBeRemoved.setNext(null);

		return savedData;
		
	}

}