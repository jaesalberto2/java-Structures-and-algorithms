public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    // node constructor
    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }
    // Constructor for the DoublyLinkedList class
    public DoublyLinkedList(int value) {
 
        Node newNode = new Node(value); // Create a new node with the given value
        head = newNode; // Set the head to the new node
        tail = newNode; // Set the tail to the new node
        length = 1; // Initialize the length to 1

    }

    // append method to add a new node at the end of the list
    public void append(int value) {
        Node newNode = new Node(value); // Create a new node with the given value
        if (length == 0) { // If the list is empty
            head = newNode; // Set the head to the new node
            tail = newNode; // Set the tail to the new node
        } else {
            tail.next = newNode; // Set the next of the current tail to the new node
            newNode.prev = tail; // Set the previous of the new node to the current tail
            tail = newNode; // Update the tail to the new node
        }
        length++; // Increment the length of the list

    

}
