public class LinkedList {
    private Node head; // Head of the list
    private Node tail; // Tail of the list
    private int length; // Size of the list
   
    class Node {
        int value; // Value of the node
        Node next; // Pointer to the next node

        // Constructor for the Node class
        public Node(int value) {
            this.value = value; // Set the value of the node
        }
    }
     
    //constructor
    public LinkedList(int value) {
        Node newnode = new Node(value);
        head = newnode; // Set the head to the new node
        tail = newnode; // Set the tail to the new node
        length = 1; // Set the length to 1
      
    }

    //print the linked list
    public void printList() {
        Node temp = head; // Start from the head
        while (temp != null) { // While there are nodes in the list
            System.out.println(temp.value); // Print the value of the current node
            temp = temp.next; // Move to the next node
        }
        System.out.println("null"); // Print null at the end of the list
    }

    //getters
    public Node getHead() {
        return head; // Return the head of the list
    }
    public Node getTail() {
        return tail; // Return the tail of the list
    }
    public int getLength() {
        return length; // Return the length of the list
    }

    //append a new node to the end of the list
    public void append(int value) {

        Node newnode = new Node(value); // Create a new node with the given value
        if (length == 0) { // If the list is empty
            head = newnode; // Set the head to the new node
            tail = newnode; // Set the tail to the new node
        } else {
            tail.next = newnode; // Set the next of the current tail to the new node
            tail = newnode; // Update the tail to the new node
        }
        length++; // Increment the length of the list
    }

}
