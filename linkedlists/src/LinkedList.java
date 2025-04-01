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


}
