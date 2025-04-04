import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RecursiveBinarySearchTree {
    private Node root;

    public static void main(String[] args) {
        RecursiveBinarySearchTree tree = new RecursiveBinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        printTree(tree);

        printTree(tree);

        //test isvalid method
        System.out.println("Is valid BST: " + tree.isBST()); // true

        //test kth smallest method
        System.out.println("Kth smallest (3rd): " + tree.kthSmallest(3)); // 4
        System.out.println("Kth smallest (5th): " + tree.kthSmallest(5)); // 6
/*        System.out.println("Contains 4: " + tree.rContains(4)); // true
        System.out.println("Contains 9: " + tree.rContains(9)); // false
        //check is valid method
        System.out.println("Is valid BST: " + tree.isBST()); // true
  */
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    //insert a Node
    public boolean insert(int value) {
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
    private boolean rContains(int value) {
        return rContains(root, value);
    }

    private boolean rContains(Node current, int value) {
        if (current == null) {
            return false; // Value not found
        }
        // Compare the value with the current node's value
        if (value == current.value) {
            return true; // Value found
        }
        if (value < current.value) {
            return rContains(current.left, value);
        } else if (value > current.value) {
            return rContains(current.right, value);
        } else {
            return true; // Value found
        }
    }

    //insert method
    private Node rInsert(Node current, int value) {
        if (current == null) {
            return new Node(value); // Create a new node
        }
        if (value < current.value) {
            current.left = rInsert(current.left, value);
        } else if (value > current.value) {
            current.right = rInsert(current.right, value);
        }
        return current; // Return the unchanged node pointer
    }

    private void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            rInsert(root, value);
        }
    }

    private Node deleteNode(Node current, int value) {
        if (current == null) {
            return null; // Value not found
        }
        if (value < current.value) {
            current.left = deleteNode(current.left, value);
        } else if (value > current.value) {
            current.right = deleteNode(current.right, value);
        } else {
            // Node with only one child or no child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            current.value = minValue(current.right);
            // Delete the inorder successor
            current.right = deleteNode(current.right, current.value);
        }
        return current;
    }

    private int minValue(Node current) {

        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    //print tree method
    private static void printTree(RecursiveBinarySearchTree tree) {
        System.out.println("Inorder Traversal:");
        inorderTraversal(tree.root);
        System.out.println();
    }

    private static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }


/*
    The task is to develop a method that takes a sorted array of integers as input and constructs a height-balanced BST.

    This involves creating a BST where the depth of the two subtrees of any node does not differ by more than one.

    Achieving a height-balanced tree is crucial for optimizing the efficiency of tree operations, ensuring that the BST remains efficient for search, insertion, and deletion across all levels of the tree.*/


    // Method to create a height-balanced BST from a sorted array
    public Node sortedArrayToBST(int[] arr) {
        return sortedArrayToBST(arr, 0, arr.length - 1);
    }

    private Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        // Find the middle element and make it the root
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        // Recursively construct the left and right subtrees
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }


    /*
Write a method to invert (or mirror) a binary tree. This means that for every node in the binary tree, you will swap its left and right children.*/


// Method to invert a binary tree

    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


//breath first search

    public ArrayList<Integer> BFS() {
        Node current = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            result.add(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }


//depth first search

public ArrayList<Integer> DFSPreOrder() {
    ArrayList<Integer> result = new ArrayList<>();
    class Traverse {
        void preOrder(Node currentNode) {
            result.add(currentNode.value);
            if (currentNode.left != null) {
                preOrder(currentNode.left);
            }
            if (currentNode.right != null) {
                preOrder(currentNode.right);
            }
        }
    }
    new Traverse().preOrder(root);
    return result;
}
//depth first search post order
public ArrayList<Integer> DFSPostOrder() {
    ArrayList<Integer> result = new ArrayList<>();
    class Traverse {
         void postOrder(Node currentNode) {
            if (currentNode.left != null) {
                postOrder(currentNode.left);
            }
            if (currentNode.right != null) {
                postOrder(currentNode.right);
            }
            result.add(currentNode.value);
        }
    }
    new Traverse().postOrder(root);
    return result;
}


//depth first search in order
public ArrayList<Integer> DFSInOrder() {
    ArrayList<Integer> result = new ArrayList<>();
    class Traverse {
        void inOrder(Node currentNode) {
            if (currentNode.left != null) {
                inOrder(currentNode.left);
            }
            result.add(currentNode.value);
            if (currentNode.right != null) {
                inOrder(currentNode.right);
            }
        }
    }
    new Traverse().inOrder(root);
    return result;}

/*
    Implement a method to validate whether a given binary tree is a correctly formed Binary Search Tree (BST).*/


    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value > max) {
            return false;
        }
        return isBST(node.left, min, node.value - 1) && isBST(node.right, node.value + 1, max);
    }


/*

The kthSmallest(int k) method should find the kth smallest element in the binary search tree. If such an element exists, the method should return its value. If not, it should return null. The smallest element in the tree is the one with the lowest value, the second smallest element is the one with the second lowest value, and so on.

The method should use the in-order traversal technique to visit the nodes of the tree, i.e., it should first visit the left child, then the parent, and finally the right child. To implement this, use a Stack<Node> to store the nodes. Continue with the traversal as long as there are nodes in the stack or the current node is not null.

While the current node is not null, push it onto the stack and move to its left child. Then, once the current node is null, pop a node from the stack, decrement k by one, and if k is zero, return the value of the popped node. Finally, move to the right child of the popped node.*/


// Method to find the kth smallest element in the BST
public Integer kthSmallest(int k) {
    if (k <= 0) {
        return null; // Invalid input
    }
    Stack<Node> stack = new Stack<>();
    Node current = root;
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        k--;
        if (k == 0) {
            return current.value; // Found the kth smallest element
        }
        current = current.right;
    }
    return null; // k is larger than the number of nodes in the tree
}
}
