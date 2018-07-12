public class Node {

	/**
	 * Instance variables
	 */
	private Job data;
	private Node next;

	/**
	 * Constructors
	 */
	public Node( Job data ) {
		this.data = data;
		this.next = null;
	}

	public Node( Job data, Node next ) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Instance getter and setter methods
	 */
	public void setData( Job data ) {
		this.data = data;
	}

	public void setNext( Node next ) {
		this.next = next;
	}

	public Job getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}	
}