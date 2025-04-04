import java.util.ArrayList;
import java.util.List;

public class Heap {

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(findKthSmallest(nums, k));  // Output: 7
    }

    private final List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int lefChild(int index) {
        return 2 * index + 1;
    }
    private  int rigthChild(int index){
        return 2 * index + 2;
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2,temp);
    }


    //insert a new element
    public void insert(int value){
        heap.add(value);
        int index = heap.size()-1;
        while (index>0 && heap.get(index)>heap.get(parent(index))){
            swap(index,parent(index));
            index = parent(index);
        }
    }

    //remove an element
    public Integer remove(){
        if (heap.isEmpty()){
            return null;
        }
        if (heap.size() == 1){
            return heap.remove(0);
        }
        int root = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        sinkDown(0);
        return root;
    }
    //sink down
    private void sinkDown(int index){
        int leftChild = lefChild(index);
        int rightChild = rigthChild(index);
        int largest = index;

        if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)){
            largest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)){
            largest = rightChild;
        }
        if (largest != index){
            swap(index,largest);
            sinkDown(largest);
        }else {
            return;
        }
    }

    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();
        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }
        return maxHeap.getHeap().get(0);

    }


    // Function that processes a stream of integers and returns the maximum number encountered so far for each input number.
    public static List<Integer> streamMax(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE; // Set the initial maximum to the smallest possible value.
        for (int num : nums) {
            if (num > currentMax) {
                currentMax = num; // Update the maximum if the current number is larger.
            }
            result.add(currentMax); // Add the current maximum to the result list.
        }
        return result;
    }
}
