package datastructures.queue;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of a generic circular queue data structure using an array as the underlying storage.
 * Supports basic queue operation such as enqueue, dequeue, and display operations.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class CircularQueueArray<T> {

    protected T[] theArray; // Array to store elements of T type.
    protected int size; // Current size of the circular queue.
    protected int front; // Index of the front element.
    protected int rear; // Index of the rear element.

    /**
     * Constructs an empty circular queue with an initial capacity of 20.
     */
    public CircularQueueArray() {
        this.theArray = (T[]) new Object[20]; // Initializing the array with capacity 20 element of type T.
        this.front = this.rear = -1; // Setting front and rear to -1.
        this.size = 0; // Setting size to 0.
    }

    /**
     * Constructs a circular queue initialized with the elements of the specified list.
     *
     * @param inputList The list whose elements are to be placed into the circular queue.
     */
    public CircularQueueArray(List<T> inputList) {

        // Converting the list to an array and doubling its size.
        T[] temp = (T[])inputList.toArray();
        this.theArray = Arrays.copyOf(temp, temp.length * 2);
        this.size = inputList.size(); // Update the size of the queue
        this.front = 0;
        this.rear = this.size - 1;
    }

    /**
     * Returns the current size of the circular queue.
     *
     * @return The number of elements in the circular queue.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Checks if the circular queue is full.
     *
     * @return true if the circular queue is full, false otherwise
     */
    public boolean isFull() {
        return this.size == this.theArray.length;
    }

    /**
     * Checks if the circular queue is empty.
     * @return true if the circular queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Resizes the array when the circular queue is full.
     */
    private void resize() {

        // Create a new array with double the size of the current array.
        T[] temp = (T[]) (new Object[this.theArray.length * 2]);
        // Copying the element from theArray into new temp array.
        for (int i = 0; i < this.size; i++) {
            int index = (this.front + i) % this.theArray.length;
            temp[i] = this.theArray[index];
        }

        // Update front and rear indices.
        this.front = 0;
        this.rear = size - 1;

        // Update theArray reference.
        this.theArray = temp;
    }

    /**
     * Adds an element to the rear of the circular queue.
     *
     * @param element The element to be added to the circular queue.
     */
    public void enqueue(T element) {

        // Check if the circular queue is full and resize if necessary.
        if (isFull()) {
            System.out.println("Queue is full.");
            resize();
        }
        // If the circular queue is empty, set front and rear to 0.
        if (isEmpty()) {
            this.front = this.rear = 0;
        }
        else {
            // Increment rear index (wrap around if necessary).
            this.rear = (this.rear + 1) % this.theArray.length; // Circular increment of rear index.
        }
        // Add the element to the rear of the circular queue.
        this.theArray[this.rear] = element;

        // Increment the size of the circular queue.
        this.size++;
    }

    /**
     * Removes and returns the element at the front of the circular queue.
     *
     * @return The element removed from the front of the circular queue, or null if the queue is empty.
     */
    public T dequeue() {

        // If the queue is empty, return null.
        if (isEmpty()) {
            return null;
        }

        // Get the element to remove.
        // Remove the element at the front of the queue and storing it inside the elementToRemove variable.
        T elementToRemove = this.theArray[this.front];

        // Update front index.

        // If there is only one element in circular queue then setting front and rear to -1.
        if (this.front == this.rear) {
            // Reset front and rear pointers if queue becomes empty after removal.
            this.front = this.rear = -1;
        }
        else {
            // Increment front index (wrap around if necessary).
            this.front = (this.front + 1) % this.theArray.length; // Circular increment of front index.
        }

        // Decrement the size of the circular queue.
        this.size--;

        // Returning the removed element.
        return elementToRemove;
    }

    /**
     * Displays the elements of the circular queue along with their corresponding indices.
     * If the queue is empty, prints "Queue is empty".
     */
    public void displayAllElement() {

        // If the circular queue is empty then display message "Queue is empty.".
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        // Iterate through the elements and display them along with their indices.
        for (int i = 0; i < this.size; i++) {
            int index = (front + i) % this.theArray.length;
            System.out.print(this.theArray[index] + "(index = " + index +") ");
        }

        System.out.println();
    }
}