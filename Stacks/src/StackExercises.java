public class StackExercises {
    private Node top;
    private  int height;
    class Node{
        int value;
        Node next;
    
         Node(int value) {
            this.value= value;
        }
        
    }
    // constructor
    public StackExercises(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    //print 
    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // get Top
    public void getTop(){
        System.out.println("Top: "+top.value);

    }

    //getHeigth
    public void getHeight(){
        System.out.println("Height: "+height);
    }

    //push mehtod
    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    // pop Method
    public int pop() {
        if (height == 0) {
            System.out.println("Stack is empty");
            return -1; // or throw an exception
        }
        int poppedValue = top.value;
        top = top.next;
        height--;
        return poppedValue;
    }




}

