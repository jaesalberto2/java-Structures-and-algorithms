import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        printArray(arr);
        bubbleSort(arr);
        System.out.println("Sorted array");
        printArray(arr);

        // Selection sort
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array");
        printArray(arr2);
        selectionSort(arr2);
        System.out.println("Sorted array");
        printArray(arr2);

        // Insertion sort
        int[] arr3 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array");
        printArray(arr3);
        insertionSort(arr3);
        System.out.println("Sorted array");
        printArray(arr3);

        // Merge sort
        int[] arr4 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Unsorted array");
        printArray(arr4);
        int[] arr5 = {1, 4, 6, 8, 10};
        System.out.println("Unsorted array");
        printArray(arr5);
        int[] mergedArray = merge(arr4, arr5);
        System.out.println("Merged array");
        printArray(mergedArray);

        // merge sort
        int[] arr6 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Unsorted array");
        printArray(arr6);
        int [] sortedArray = mergeSort(arr6);
        System.out.println("Sorted array");
        printArray(sortedArray);

        ArrayList newList = new ArrayList<>( Arrays.asList(3,5,6,4,5,8,9,4));
        //print newlist
        System.out.println(newList);
        //sort newlist
        newList.sort(null);
        //print newlist
        System.out.println(newList);

    }
    // Function to print an array
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //bubblesort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // Node class for linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // Selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap arr[i] and arr[minIndex]
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    // Insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
/*

    Implement the Selection Sort algorithm on a singly linked list.

    The linked list will contain integer elements.

    You are required to write a method selectionSort() within the LinkedList class. This method will sort the linked list in ascending order using the Selection Sort algorithm.

    The Selection Sort algorithm works by dividing the list into a sorted and an unsorted region. The sorted region starts out empty and the unsorted region is initially the entire list. The algorithm repeatedly selects the smallest (or largest, depending on sorting order) element from the unsorted region and moves it into the sorted region. When the unsorted region becomes empty, the algorithm stops and the list is sorted.

    Here is a brief overview of the steps involved in implementing the selection sort algorithm:

    Check if the length of the linked list is less than 2. If it is, the list is already sorted, so the method should return immediately.

    Initialize a Node object current to the head of the list.

    Set up a while loop that continues as long as current.next is not null.

    Within this loop, set smallest to current and innerCurrent to the next node in the list.

    While innerCurrent is not null, if innerCurrent's value is less than smallest's value, set smallest to innerCurrent. Then, advance innerCurrent to the next node.

    After going through all nodes in the unsorted region, if smallest is not current, swap the values in smallest and current.

    Move current to the next node and repeat the process until the entire list is sorted.

    At the end of the sort, update the tail of the list to current.



    Please ensure your code follows these steps to correctly implement the selection sort method.

    Assume that all values in the list are integers. The selectionSort() method should not return any value; it should sort the linked list in-place. That is, it should modify the original linked list rather than creating and returning a new, sorted list.
*/


    // Selection sort for linked list
    public static void selectionSortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return; // List is already sorted
        }

        Node current = head;

        while (current != null) {
            Node smallest = current;
            Node innerCurrent = current.next;

            while (innerCurrent != null) {
                if (innerCurrent.data < smallest.data) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }

            // Swap values
            if (smallest != current) {
                int temp = current.data;
                current.data = smallest.data;
                smallest.data = temp;
            }

            current = current.next;
        }
    }


    // Insertion sort for linked list
    public static void insertionSortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return; // List is already sorted
        }

        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null; // Initialize sorted list

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.data < sortedListHead.data) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next != null && searchPointer.next.data < current.data) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead; // Update head to point to the new sorted list
    }

    // Merge sort for linked list
    public static int[] merge(int[] array1, int[] array2) {
        int n1 = array1.length;
        int n2 = array2.length;
        int[] combined = new int[n1 + n2];

        int i = 0, j = 0, index = 0;

        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                combined[index] = array1[i];
                i++;
                index++;
            } else {
                combined[index] = array2[j];
                j++;
                index++;
            }
        }

        while (i < n1) {
            combined[index++] = array1[i++];
        }

        while (j < n2) {
            combined[index++] = array2[j++];
        }

        return combined;
    }

    // Merge sort for linked list
    public static int[] mergeSort(int[] array){

        if (array.length <= 1) return array; // Base case: array is already sorted

        int midIndex = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right =mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);

    }


    // Swap function for linked list





}
