import java.util.Stack;

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

    // Print the queue
    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Get the first node's value
    public int getFirst() {
        return first != null ? first.value : -1; // Return -1 if the queue is empty
    }

    // Get the last node's value
    public int getLast() {
        return last != null ? last.value : -1; // Return -1 if the queue is empty
    }

    // Get the length of the queue
    public int getLength() {
        return length;
    }

    // enqueue method
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    //dequeue method
    public Node dequeue() {
        if (length == 0) {
            return null;
        }
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

     public static String reverseString(String string) {
        Stack<Character> stack = new Stack<>();
        String reversedString = "";

        for (char c : string.toCharArray()) {
            stack.push(c);
        }
        
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        return reversedString;
    }


    public static boolean isBalancedParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop().charValue() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void sortStack(Stack stack) {
        Stack additionalStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
        
    }


}
