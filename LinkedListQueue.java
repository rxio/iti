public class LinkedListQueue implements Queue {

	/**
	 * Instance variables
	 */
	private Node head;
	private Node tail;
	
    /**
     * The constructor initializes the head and tail instance variables.
     */
	public LinkedListQueue() {

		head = null;
		tail = null;

	}

    /**
     * Checks to see if the queue contains elements. 
     * It returns true if the queue is empty and false otherwise.
     */
	public boolean isEmpty() {

		return head == null;

	}

    /**
     * Adds an element to the rear of the queue.
     * This enqueue() method is called only if one argument is given.
     */
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

    /**
     * Adds an element to the rear of the queue.
     * This enqueue() method is called when two arguments are given.
     */
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

    /**
     * Removes an element from the front of the queue.
     */	
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

    /**
     * Removes all the elements from the queue.
     */
	public void clear() {

		head = null;
		tail = null;

	}

}