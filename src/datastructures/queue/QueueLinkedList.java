package datastructures.queue;


import java.util.List;

/**
 * QueueLinkedList represents a queue implemented using a singly linked list as the underlying storage.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class QueueLinkedList<T> {

    /**
     * Inner protected class representing a node in the linked list.
     *
     */
    protected class Node {

        private T data; // Data stored in the node.
        private Node next; // Reference to the next node in the linked list.

        /**
         * Constructor to create a new node with the given data.
         *
         * @param data The data to be stored in the node.
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Getter method to retrieve the data stored in the node.
         *
         * @return The data stored in the node.
         */
        public T getData() {
            return this.data;
        }

        /**
         * Setter method to set the data stored in the node.
         *
         * @param data The data to be set in the node.
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * Getter method to retrieve the reference to the next node in the linked list.
         *
         * @return The reference to the next node.
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Setter method to set the reference to the next node in the linked list.
         *
         * @param next The reference to the next node.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    protected Node head; // Reference to the first node in the queue.
    protected Node tail; // Reference to the last node in the queue.
    protected int size; // Number of elements in the queue.

    /**
     * Constructor to create an empty queue.
     */
    public QueueLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructs a queue initialized with the elements of the specified list.
     * Enqueues each element from the input list into the queue.
     *
     * @param inputList The list whose elements are to be placed into the queue.
     */
    public QueueLinkedList(List<T> inputList) {

        // Convert the input list to an array.
        T[] tempArray = (T[]) inputList.toArray();

        // Enqueue each element from the array into the queue.
        for (T t : tempArray) {
            this.enqueue(t);
        }
    }

    /**
     * Method to get the number of elements in the queue.
     *
     * @return The size of the queue.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Method to check if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Method to enqueue an element into the queue.
     *
     * @param element The element to be enqueued in the queue.
     */
    public void enqueue(T element) {

        // Creating the node with data = object.
        Node temp = new Node(element);

        // Enqueue the first node.

        // If queue is empty then inserting the new node at head.
        if (isEmpty()) {
            // Setting tail and head to new node(temp).
            this.tail = this.head = temp;
        }
        else {

            // Setting the tail's next to new node(temp).
            this.tail.next = temp;

            // Setting tail to new node(temp).
            this.tail = temp;
        }

        // Increment the size of the queue.
        this.size++;
    }

    /**
     * Method to dequeue an element from the queue.
     *
     * @return The dequeued element ((Removed element)) or null, if queue is empty.
     */
    public T dequeue() {

        // If queue is empty then returning null.
        if (isEmpty()) {
            System.out.println("No element present.");
            return null;
        }

        // Store the data of the node to be removed.
        T elementToRemove = this.head.data;

        // If there is only one node in the queue.
        if (this.head == this.tail) {
            // Set both head and tail to null, indicating an empty queue.
            this.tail = this.head = null;
        }
        else {
            // Move the head reference to it's next node.
            this.head = this.head.next;
        }

        // Decrement the size of the queue.
        this.size--;

        // Return the removed element.
        return elementToRemove;
    }

    /**
     * Method to display all elements in the queue.
     */
    public void displayAllElement() {
        if (isEmpty()) { // Check if the queue is empty.
            System.out.println("Queue is empty."); // If empty, print a message indicating that the queue is empty.
            return;
        }

        Node current = this.head; // Start traversal from the head node.

        // Iterate through each node in the queue and print its data.
        while (current != null) {
            System.out.println(current.data); // Print the data of the current node.
            current = current.next; // Move to the next node.
        }

        System.out.println();
    }
}