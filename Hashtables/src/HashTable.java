import java.util.ArrayList;

public class HashTable {
    private int size =7;
    private Node[] dataMap;

    
    public class Node {
        String key;
        int value;
        Node next;
        Node(String key, int value){
           this.key = key;
           this.value = value;
       }
   }

    public HashTable(){
        dataMap = new Node[size];
    }


    public void printTable(){
        for (int i = 0; i < dataMap.length; i++) {
            System.out.print(i + ": ");
            Node current = dataMap[i];
            while (current != null) {
                System.out.print("{" + current.key + "=" + current.value + "} -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    private  int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0 ; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = ( hash + asciiValue*23)%dataMap.length;
        }
        return hash;
    }



    //set method
    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
            Node temp =  dataMap[index];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    // get method

    public int get(String key) {
        int index = hash(key);
        Node current = dataMap[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return 0; // Return 0 if the key is not found
    }

    //Keys method
    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node current = dataMap[i];
            while (current != null) {
                allKeys.add(current.key);
                current = current.next;
            }
        }
        return allKeys;
    }












}
