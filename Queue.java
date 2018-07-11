public interface Queue<E> {
	public abstract boolean isEmpty(); //Checks to see if the queue contains an elements. It returns true if the queue is empty and false otherwise.
	public abstract void enqueue( E obj ); //Adds an element to the rear of the queue
	public abstract E dequeue(); //Removes an element from the front of the queue
	public abstract void clear(); //Removes all the elements from the queue
}