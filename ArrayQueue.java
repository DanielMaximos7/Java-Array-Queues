public class ArrayQueue {

    public static void main(String[] args) {

        // Create an object of the array-based queue with a capacity of 5
        System.out.println(">>> Creating an object of the array-based queue with a capacity of 5");
        int capacity = 5;
        ArrayBasedQueue object = new ArrayBasedQueue(5);

        // Insert the letters A, B, C, D, E one by one in the queue
        System.out.println(">>> Inserting the letters A, B, C, D, and E in the queue");
        object.enqueue("A");
        object.enqueue("B");
        object.enqueue("C");
        object.enqueue("D");
        object.enqueue("E");

        // Remove the letters A and B from the queue
        System.out.println(">>> Removing the letters A and B from the queue");
        object.dequeue();
        capacity--;
        object.dequeue();
        capacity--;

        // Insert the letters F and G into the queue
        System.out.println(">>> Inserting the letters F and G into the queue");
        object.enqueue("F");
        capacity++;
        object.enqueue("G");
        capacity++;

        // Create a loop that prints all the elements that were stored in the queue
            // Output should be C,D,E,F,G
        System.out.print("\nElements stored in the queue: ");

        for (int i = 0; i < capacity; i++) {    // capacity is used as reference for the number of loops
            if (i < (capacity - 1)) {
                System.out.print(object.queueElement(i) + ", ");
            }
            else {
                System.out.print(object.queueElement(i));
            }
        }

    }
}