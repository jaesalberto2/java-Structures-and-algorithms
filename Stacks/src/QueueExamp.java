public class QueueExamp {
    private  Node first;
    private Node last;
    private int length;

    //create a node
     class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //constructor for a queue

    public QueueExamp(int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
       
    }

}
