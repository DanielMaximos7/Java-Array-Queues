import java.util.Queue;

public class ArrayBasedQueue<E> implements Queue<E> {
    // Instance variables
    private E[] data;           // generic array used for storage
    private int front = 0;      // index of the front element
    private int size = 0;       // current number of elements

    // Constructors
    public ArrayBasedQueue() {  // Constructs queue with default capacity
        this(CAPACITY);     
    }
    public ArrayBasedQueue(int capacity) {  // Constructs queue with given capacity
        data = (E[]) new Object[capacity];
    }

    // Methods
    /** Returns the numbers of elements in the queue */
    public int size() {
        return size;
    }

    /** Tests whether the queue is empty */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Inserts an element at the rear of the queue */
    public void enqueue(E e) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        int avail = (front + size) % data.length;
        data[avail] = e;
        size++;
    }

    /** Returns, but does not remove, the first element of the queue (null if emepty) */
    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }
    
    /** Removes and returns the first element of the queue (null if empty) */
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[front];
        data[front] = null;     // dereference to help garabe collection
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    /** Returns, but does not remove, the # assigned element of the queue (null if empty) */
    public E queueElement(int assigned) {
        if (isEmpty()) return null;
        
        /** If the value of front is greater than zero, the start of the queue isn't at the start of the array.
        When elements are removed, the other elements don't change position. Thus, when the
        total number of elements added exceeds the capacity size, new elements will be added 
        at the front, acting as a circular queue. */

        int truePosition = assigned + front;
        if (truePosition >= data.length) {
            truePosition = truePosition - data.length;  // Reset the true position to the start of the array
        }
        return data[truePosition];
    }
}
