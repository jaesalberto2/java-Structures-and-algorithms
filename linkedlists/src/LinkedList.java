

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

    //remove the last node from the list

    public Node removeLast() {
        if (length == 0) { // If the list is empty
            return null; // Return null
        }
        Node temp = head; // Start from the head
        Node pre = head; // Previous node
        while (temp.next != null) { // While there are nodes in the list
            pre = temp; // Update the previous node to the current node
            temp = temp.next; // Move to the next node
        }
        tail = pre; // Update the tail to the previous node
        tail.next = null; // Set the next of the tail to null
        length--; // Decrement the length of the list
        if (length == 0) { // If the list is empty after removal
            head = null; // Set the head to null
            tail = null; // Set the tail to null
        }
        return temp; // Return the removed node
    }

    // Prepend a new node to the beginning of the list
    public void prepend(int value) {
        Node newNode = new Node(value); // Create a new node with the given value
        if (length == 0) { // If the list is empty
            head = newNode; // Set the head to the new node
            tail = newNode; // Set the tail to the new node
        } else {
            newNode.next = head; // Set the next of the new node to the current head
            head = newNode; // Update the head to the new node
        }
        length++; // Increment the length of the list
    }

    // Remove the first node from the list
    public Node removeFirst() {
        if (length == 0) { // If the list is empty
            return null; // Return null
        }
        Node temp = head; // Store the current head
        head = head.next; // Update the head to the next node
        temp.next = null; // Set the next of the removed node to null
        length--; // Decrement the length of the list
        if (length == 0) { // If the list is empty after removal
            tail = null; // Set the tail to null
        }
        return temp; // Return the removed node
    }

    //get method to get the node at a specific index
    public Node get(int index) {
        if (index < 0 || index >= length) { // If the index is out of bounds
            return null; // Return null
        }
        Node temp = head; // Start from the head
        for (int i = 0; i < index; i++) { // Traverse to the specified index
            temp = temp.next; // Move to the next node
        }
        return temp; // Return the node at the specified index
    }

    //set method to set the value of a node at a specific index
    public boolean set(int index, int value) {
        Node temp = get(index); // Get the node at the specified index
        if (temp != null) { // If the node exists
            temp.value = value; // Set the value of the node
            return true; // Return true
        }
        return false; // Return false if the node does not exist
    } // Close the set method

    // Insert a new node at a specific index
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) { // If the index is out of bounds
            return false; // Return false
        }
        if (index == 0) { // If the index is 0
            prepend(value); // Prepend the new node
            return true; // Return true
        }
        if (index == length) { // If the index is equal to the length
            append(value); // Append the new node
            return true; // Return true
        }
        Node newNode = new Node(value); // Create a new node with the given value
        Node temp = get(index - 1); // Get the node at the specified index - 1
        newNode.next = temp.next; // Set the next of the new node to the next of the current node
        temp.next = newNode; // Set the next of the current node to the new node
        length++; // Increment the length of the list
        return true; // Return true
    } // Close the insert method

    //remove a node at a specific index
    public Node remove(int index) {
        if (index < 0 || index >= length) { // If the index is out of bounds
            return null; // Return null
        }
        if (index == 0) { // If the index is 0
            return removeFirst(); // Remove the first node
        }
        if (index == length - 1) { // If the index is equal to the length - 1
            return removeLast(); // Remove the last node
        }
        Node temp = get(index - 1); // Get the node at the specified index - 1
        Node removedNode = temp.next; // Store the node to be removed
        temp.next = removedNode.next; // Set the next of the current node to the next of the removed node
        removedNode.next = null; // Set the next of the removed node to null
        length--; // Decrement the length of the list
        return removedNode; // Return the removed node
    } // Close the remove method

    // Reverse the linked list
    public void reverse() {

        Node temp = head; // Start from the head
        head = tail; // Set the head to the tail
        tail = temp; // Set the tail to the current head
        Node after = null; // Previous node
        Node before = null; // Next node
        for (int i = 0; i < length; i++) { // Traverse the list
            after = temp.next; // Store the next node
            temp.next = before; // Reverse the link
            before = temp; // Update the previous node
            temp = after; // Move to the next node
        }
        
    } // Close the reverse method


    //middle node of the linked list
    
    public Node middleNode() {
        Node slow = head; // Start from the head
        Node fast = head; // Start from the head
        while (fast != null && fast.next != null) { // While there are nodes in the list
            slow = slow.next; // Move the slow pointer one step
            fast = fast.next.next; // Move the fast pointer two steps
        }
        return slow; // Return the middle node
    } // Close the middleNode method



    // hasLoop method to check if the linked list has a loop
    public boolean hasLoop() {
        Node slow = head; // Start from the head
        Node fast = head; // Start from the head
        while (fast != null && fast.next != null) { // While there are nodes in the list
            slow = slow.next; // Move the slow pointer one step
            fast = fast.next.next; // Move the fast pointer two steps
            if (slow == fast) { // If the slow and fast pointers meet
                return true; // Return true (loop exists)
            }
        }
        return false; // Return false (no loop)
    } // Close the hasLoop method

    //partition method to partition the linked list around a value
    public void patitionList(int x){
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }  
    

    //remove duplicates from the linked list
    public void removeDuplicates() {
        Node current = head; // Start from the head
        while (current != null) { // While there are nodes in the list
            Node runner = current; // Start a runner from the current node
            while (runner.next != null) { // While there are nodes in the list
                if (runner.next.value == current.value) { // If the next node has the same value
                    runner.next = runner.next.next; // Remove the duplicate node
                    length--; // Decrement the length of the list
                } else {
                    runner = runner.next; // Move to the next node
                }
            }
            current = current.next; // Move to the next node
        }
    } // Close the removeDuplicates method

    // binary to decimal conversion
    public int binaryToDecimal() {
        Node current = head; // Start from the head
        int decimalValue = 0; // Initialize the decimal value
        int base = 1; // Initialize the base (2^0)

        while (current != null) { // While there are nodes in the list
            decimalValue += current.value * base; // Add the value multiplied by the base to the decimal value
            base *= 2; // Update the base (multiply by 2)
            current = current.next; // Move to the next node
        }
        return decimalValue; // Return the decimal value
    } // Close the binaryToDecimal method

    //reverse between two nodes
    public void reverseBetween(int left, int right) {
        if (left == right) return; // If the left and right indices are the same, no need to reverse

        Node dummy = new Node(0); // Create a dummy node
        dummy.next = head; // Set the next of the dummy node to the head
        Node prev = dummy; // Previous node
        for (int i = 0; i < left - 1; i++) { // Traverse to the left index
            prev = prev.next; // Move to the next node
        }
        Node start = prev.next; // Start node
        Node then = start.next; // Next node

        for (int i = 0; i < right - left; i++) { // Reverse the nodes between left and right
            start.next = then.next; // Set the next of the start node to the next of the then node
            then.next = prev.next; // Set the next of the then node to the next of the previous node
            prev.next = then; // Set the next of the previous node to the then node
            then = start.next; // Move to the next node
        }
        head = dummy.next; // Update the head to the new head
    } // Close the reverseBetween method
} // Close the LinkedList class
