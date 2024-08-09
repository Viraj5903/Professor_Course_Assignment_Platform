package datastructures.queue;


import java.util.ArrayList;
import java.util.List;

/**
 * PriorityQueue represents a priority queue implemented using a linked list.
 * Elements in the queue are ordered based on their natural ordering, as defined by the Comparable interface.
 * Elements are inserted in such a way that they maintain their priority order.
 * Higher priority elements are placed closer to the head of the queue.
 *
 * @param <T> The type of elements stored in the priority queue, must implement Comparable<T> for ordering.
 */
public class PriorityQueue<T extends Comparable<T>> extends QueueLinkedList<T>{

    public PriorityQueue() {
        super();
    }

    public PriorityQueue(List<T> inputList) {

        super(inputList);

    }

    /**
     * Inserts an element into the priority queue based on its priority.
     * If the queue is empty or the new element has higher priority than the head node, the new node is added before the head node.
     * Otherwise, the new element is inserted in the correct position in the queue.
     *
     * @param element The element to be enqueued.
     */
    @Override
    public void enqueue(T element) {

        // Create a new node with the given element.
        Node newNode = new Node(element);

        // If the queue is empty or the new element has higher priority than the head node, add the new node before the head node.
        if (isEmpty() || element.compareTo(this.head.getData()) >= 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        // Otherwise, find the correct position to insert the new element in the queue.
        else {
            Node current = this.head;

            // Traverse the queue to find the correct position to insert the new element.
            while (current.getNext() != null && element.compareTo((current.getNext()).getData()) < 0) {
                current = current.getNext();
            }

            // Insert the new element after the current node.
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        // Increment the size of the queue.
        this.size++;
    }

    /**
     * Searches for and displays the specified element if found in the priority queue.
     *
     * @param element The element to be searched for and displayed.
     */
    public void displayElement(T element) {

        Node current = this.head;

        // Traverse the queue to find the specified element.
        while (current != null) {
            if (current.getData().equals(element)) {
                System.out.println("Element found: " + current.getData());
                return;
            }

            current = current.getNext();
        }

        // If the element is not found in the queue, print a message.
        System.out.println("Element not found in queue.");
    }

    /**
     * Displays all elements in the priority queue that have a higher priority than the specified element.
     *
     * @param element The element whose higher priority elements are to be displayed.
     */
    public void displayHigherElement(T element) {

        Node current = this.head;

        System.out.println("Higher priority elements than " + element + ":");

        // Traverse the queue and print elements with higher priority.
        while (current != null) {
            if (current.getData().compareTo(element) > 0) {
                System.out.println(current.getData());
            }
            current = current.getNext();
        }
    }

    /**
     * Displays all elements in the priority queue that have a lower priority than the specified element.
     *
     * @param element The element whose lower priority elements are to be displayed.
     */
    public void displayLowerElement(T element) {

        Node current = this.head;

        System.out.println("Lower priority elements than " + element + ":");

        // Traverse the queue and print elements with lower priority.
        while (current != null) {
            if (current.getData().compareTo(element) < 0) {
                System.out.println(current.getData());
            }
            current = current.getNext();
        }
    }

    /**
     * Converting the priority queue into the array.
     *
     * @return Return an array.
     */
    public T[] toArray() {

        List<T> list = new ArrayList<>();
        Node current = this.head;

        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }

        // Convert ArrayList to array
        return list.toArray((T[]) new Object[list.size()]);
    }
}
