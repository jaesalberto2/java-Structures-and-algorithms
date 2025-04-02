
import jdk.jfr.snippets.Snippets;

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
    }// end append method

    //remove last method to remove the last node from the list

    public Node removeLast() {
        if (length == 0)  return null; // Do nothing
        Node temp = tail; // Store the current tail node in a temporary variable
         if (length == 1) { // If the list has only one node
            head = null; // Set the head to null
            tail = null; // Set the tail to null
        } else {
            tail = tail.prev; // Move the tail pointer to the previous node
            tail.next = null; // Set the next of the new tail to null
            temp.prev = null; // Set the previous of the new tail to null
        }
        length--; // Decrement the length of the list
        return temp; // Return the removed node
    }// end remove last method

    //prepend method to add a new node at the beginning of the list
    public void prepend(int value) {
        Node newNode = new Node(value); // Create a new node with the given value
        if (length == 0) { // If the list is empty
            head = newNode; // Set the head to the new node
            tail = newNode; // Set the tail to the new node
        } else {
            newNode.next = head; // Set the next of the new node to the current head
            head.prev = newNode; // Set the previous of the current head to the new node
            head = newNode; // Update the head to the new node
        }
        length++; // Increment the length of the list
    }// end prepend method

    //remove first method to remove the first node from the list
    public Node removeFirst() {
        if (length == 0) return null; // Do nothing
        Node temp = head; // Store the current head node in a temporary variable
        if (length == 1) { // If the list has only one node
            head = null; // Set the head to null
            tail = null; // Set the tail to null
        } else {
            head = head.next; // Move the head pointer to the next node
            head.prev = null; // Set the previous of the new head to null
            temp.next = null; // Set the next of the removed node to null
        }
        length--; // Decrement the length of the list
        return temp; // Return the removed node
    }// end remove first method


    //get method to get the node at a specific index
    public Node get(int index) {

        if (index < 0 || index >= length) return null; // Check for invalid index
        Node temp = head; // Start from the head node
        if (index < length / 2) { // If the index is in the first half of the list
            for (int i = 0; i < index; i++) { // Traverse to the desired index
                temp = temp.next; // Move to the next node
            }
        } else { // If the index is in the second half of the list
            temp = tail; // Start from the tail node
            for (int i = length - 1; i > index; i--) { // Traverse to the desired index
                temp = temp.prev; // Move to the previous node
            }
        }
        return temp; // Return the node at the specified index
            }// end get method


    //set method to set the value of a node at a specific index
    public boolean set(int index, int value) {
        Node temp = get(index); // Get the node at the specified index
        if (temp != null) { // If the node exists
            temp.data = value; // Set the value of the node
            return true; // Return true to indicate success
        }
        return false; // Return false to indicate failure
    }// end set method

    //insert method to insert a new node at a specific index
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false; // Check for invalid index
        if (index == 0) { // If the index is 0, prepend the new node
            prepend(value); // Call the prepend method
            return true; // Return true to indicate success
        } else if (index == length) { // If the index is equal to the length, append the new node
            append(value); // Call the append method
            return true; // Return true to indicate success
        } else { // If the index is in between, insert the new node at the specified index
            Node newNode = new Node(value); // Create a new node with the given value
            Node beforeNode = get(index - 1); // Get the node before the specified index
            Node afterNode = beforeNode.next; // Get the node after the specified index

            beforeNode.next = newNode; // Set the next of the before node to the new node
            newNode.prev = beforeNode; // Set the previous of the new node to the before node
            newNode.next = afterNode; // Set the next of the new node to the after node
            afterNode.prev = newNode; // Set the previous of the after node to the new node

            length++; // Increment the length of the list
            return true; // Return true to indicate success
        }
    }// end insert method



    //remove method to remove a node at a specific index
    public Node remove(int index) {
        if (index < 0 || index >= length) return null; // Check for invalid index
        if (index == 0) { // If the index is 0, remove the first node
            return removeFirst(); // Call the removeFirst method
        } else if (index == length - 1) { // If the index is equal to the last index, remove the last node
            return removeLast(); // Call the removeLast method
        } else { // If the index is in between, remove the node at the specified index
            Node beforeNode = get(index - 1); // Get the node before the specified index
            Node removedNode = beforeNode.next; // Get the node to be removed
            Node afterNode = removedNode.next; // Get the node after the specified index

            beforeNode.next = afterNode; // Set the next of the before node to the after node
            afterNode.prev = beforeNode; // Set the previous of the after node to the before node

            removedNode.next = null; // Set the next of the removed node to null
            removedNode.prev = null; // Set the previous of the removed node to null

            length--; // Decrement the length of the list
            return removedNode; // Return the removed node
        }
    }// end remove method

    

}
