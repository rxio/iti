public class PriorityQueue implements Queue
{
    /**
     * Instance variables
     */
    private Job[] heap;
    private int tail;

    /**
     * The constructor creates an empty array for the heap and sets the tail to 0.
     */
    public PriorityQueue()
    {
        heap = new Job[10];
        tail = 0;
    }

    /**
     * Checks to see if the queue contains elements. 
     * It returns true if the queue is empty and false otherwise.
     */
    public boolean isEmpty()
    {        
        return tail == 0;
    }

    /**
     * Adds an element to the rear of the queue
     */    
    public void enqueue(Job element)
    {    
        if(tail <= heap.length) 
        {
            heap[tail] = element;
            reverseHeapify(tail);
            tail++;
        } 
        else 
        {
            resize();
            heap[tail] = element;
            reverseHeapify(tail);
            tail++;
        }
    }
 
     /**
     * Removes an element from the front of the queue.
     */    
    public Job dequeue()
    {
        if( isEmpty() ) 
        {
            return null;
        }
        
        Job heapSwapper = heap[0];
        heap[0] = heap[tail-1];
        heap[tail-1] = heapSwapper;
        
        Job savedElement = heap[--tail];
        
        heap[tail] = null;

        heapify( 0 );

        return savedElement;
    }

    /**
     * Removes all the elements from the queue.
     */    
    public void clear()
    {
        Job[] newReplacementArray = new Job[heap.length];
        heap = newReplacementArray;
    }

    /**
     * If the queue reaches its max size, this method will double the size of the queue.
     */     
    private void resize()
    {
        Job[] temporaryArray = new Job[(heap.length*2)];

        for(int i = 0; i < heap.length; i++)
        {
            temporaryArray[i] = heap[i];
        } 

        heap = temporaryArray;
    }
    
    /**
     * Takes the child element and compares it to the parent element.
     * If the parent element is smaller than the child element, it will swap them.
     * This method will traverse up the heap until all parent elements are greater than their children.
     */
    private void reverseHeapify(int i)
    {
        Job heapSwapper;
        int p = parent(i);
        while (heap[p].getOwner() < heap[i].getOwner())
        {
            heapSwapper = heap[p];
            heap[p] = heap[i];
            heap[i] = heapSwapper;
            i = p;
            p = parent(i);
        }
    }
    
    /**
     * Given an array index i, this method returns the array index of the i's
     * parent node in the heap.
     * 
     * @param i The index of the node for whom's parent we are searching.
     * @return The index in the array of i's parent.
     */
    private int parent(int i)
    {
        return (int) Math.floor((i - 1) / 2.0f);
    }
    
    /**
     * Given an array index i, this method returns the array index of the i's
     * left child node in the heap.
     * 
     * @param i The index of the node for whom's left child we are searching.
     * @return The index in the array of i's left child.
     */
    private int left(int i)
    {
        return 2 * i + 1;
    }
    
    /**
     * Given an array index i, this method returns the array index of the i's
     * right child node in the heap.
     * 
     * @param i The index of the node for whom's right child we are searching.
     * @return The index in the array of i's right child.
     */
    private int right(int i)
    {
        return 2 * i + 2;
    }
    
    /**
     * Swaps the Job's at position i and j.
     * 
     * @param i the array index of one of the job's to be swapped.
     * @param j the array index of the other job to be swapped.
     */
    private void swap(int i, int j)
    {
        Job temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    /**
     * Heapify works by comparing the current internal node with its children 
     * to see which is the largest. If the root is not the largest then it is 
     * swapped with the largest of its children. Since the child has now been 
     * altered it needs to check to make sure it still satisfies the heap property. 
     * Heapify works its way down the tree in this manner and, when it is complete, 
     * the tree should again be a heap. The details of how Heapify works are a 
     * little complex but the method is provided for you, you just need to 
     * understand when to use it.
     * 
     * The purpose of heapify is to restore the heap property after one of the 
     * internal nodes of the heap has been altered. In the case of a priority queue,
     * this internal nodes get altered during dequeue operations.
     * 
     * @param i The index of the node that we are not certain if it satisfied the
     * heap property (one or both of its children might be larger).
     */
    private void heapify(int i)
    {
            int l = left(i);
            int r = right(i);
            int largest = i;
            
            if (l < tail && 
                heap[l].getOwner() > heap[largest].getOwner())
            {
                    largest = l;
            }
            
            if (r < tail &&
                heap[r].getOwner() > heap[largest].getOwner())
            {
                    largest = r;
            }
            
            if (largest != i)
            {
                    swap(i, largest);
                    heapify(largest);
            }
    }        
}