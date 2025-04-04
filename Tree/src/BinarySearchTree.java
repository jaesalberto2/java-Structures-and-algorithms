
import com.sun.source.tree.BinaryTree;

public class BinarySearchTree {
    
    private Node root;

    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    //insert a Node
    public boolean insert(int value){
        if (root == null) {
            root = new Node(value);
            return true;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
            if (current.left == null) {
                current.left = new Node(value);
                return true;
            }
            current = current.left;
            } else if (value > current.value) {
            if (current.right == null) {
                current.right = new Node(value);
                return true;
            }
            current = current.right;
            } else {
            // Value already exists in the tree
            return false;
            }
        }
    }

    //contains method
    public boolean contains(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return true; // Value found
            }
        }
        return false; // Value not found
    }

    //deleting a node
    public boolean delete(int value) {
        root = deleteRecursive(root, value);
        return root != null;
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
        } else {
            // Node to delete found
            if (current.left == null && current.right == null) {
                return null; // No children
            } else if (current.left == null) {
                return current.right; // One child (right)
            } else if (current.right == null) {
                return current.left; // One child (left)
            } else {
                // Two children
                Node smallestValue = findSmallestValue(current.right);
                current.value = smallestValue.value;
                current.right = deleteRecursive(current.right, smallestValue.value);
            }
        }
        return current;
    }

    private Node findSmallestValue(Node root) {
        return root.left == null ? root : findSmallestValue(root.left);
    }



}
