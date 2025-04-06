import java.util.Arrays;

public class QuickSort {

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

    private  static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;

    }
    private  static int pivot(int[] array, int pivotIndex, int endIndex) {
    int swapIndex = pivotIndex;
    for (int i = pivotIndex; i <= endIndex; i++) {
        if (array[i] < array[pivotIndex]) {
            swapIndex++;
            swap(array, swapIndex, i);
        }
    }
    swap(array, pivotIndex, swapIndex);
    return swapIndex;
    }

    // QuickSort function
    public  static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }
    }

    //main
    public static void main(String[] args) {
        int[] array = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("Original array: " + Arrays.toString(array));
        int[] sortedArray = mergeSort(array);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

}
