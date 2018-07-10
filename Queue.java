public interface Queue<E> {
	public abstract boolean isEmpty(); //Checks to see if queue is empty
	public abstract void enqueue( E obj ); //Adds an element to the front of the queue
	public abstract E dequeue(); //Removes an element from the rear of the queue
}