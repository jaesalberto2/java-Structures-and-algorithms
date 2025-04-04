
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableE {
public static void main(String[] args) {
    
    int[] array1 = {1,2,5,5,1,6,4};
    int[] array2 = {2,4,5};
    
    int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = {2, 4, 6, 8, 10};
int target = 7;

List<int[]> pairs = findPairs(arr1, arr2, target);
System.out.println(pairs.toString());

/*     System.out.println( hasUniqueChars("abcdeefg")); */

   
/* 
    System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

  */


  /* System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
  System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
  System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
  System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
  System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
  System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
  System.out.println(Arrays.toString(twoSum(new int[]{}, 0))); */
    

}

public static boolean itemInCommon(int[] array1, int[] array2) {
   for( int i : array1){
    for( int j : array2){
        if(i==j) return true;
    }
   }
    return false;
}

public static boolean itemInCommon2(int[] array1, int[] array2){
    HashMap<Integer, Boolean> myHashMap = new  HashMap<>();
    for ( int i : array1){
        myHashMap.put(i, true); 
    }
    for (int j : array2){
        if(myHashMap.get(j) != null) return true;
    }
    return  false;
}

public static  List<Integer>  FindDuplicates(int[] array1){
    HashMap<Integer,Boolean> myHashMap = new HashMap<>();
    List<Integer> temp = new ArrayList<>();
    for( int i : array1){
        if(myHashMap.get(i) == null){
        myHashMap.put(i, true);
        }else{
            temp.add(i);
        }
    }
    return temp;
}


//First Non-Repeating Character
public static  List<Character>  FirstNonRepeating(String string){

    HashMap<Character, Integer> charCount = new HashMap<>();
    List<Character> result = new ArrayList<>();

    // Count the occurrences of each character
    for (char c : string.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }

    // Find the first non-repeating character
    for (char c : string.toCharArray()) {
        if (charCount.get(c) == 1) {
            result.add(c);
            break;
        }
    }

    return result;
}

//Group Anagrams



     public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> anagramGroups = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);

            if (anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(string);
            } else {
                List group = new ArrayList<>();
                group.add(string);
                anagramGroups.put(canonical, group);
            }
        }

        return new ArrayList<>(anagramGroups.values());
    }


    //two sums
    public static int[] twoSum(int[] nums, int target) {
        Map numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (numMap.containsKey(complement)) {
                return new int[]{(int) numMap.get(complement), i};
            }
            numMap.put(num, i);
        }

        return new int[]{};
    }


    public static int[] subarraySum(int[] nums, int target) {
        Map sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[]{(Integer) sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);
        }

        return new int[]{};
    }


    public static  List<Integer>  RemoveDuplicates(int[] array1){
        HashMap<Integer,Boolean> myHashMap = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        for( int i : array1){
            if(myHashMap.get(i) == null){
            myHashMap.put(i, true);
            temp.add(i);

            }else{
            }
        }
        return temp;
    }

    //has unique chars
    public static  boolean   hasUniqueChars(String string){
    HashMap<Character,Boolean> myHashMap = new HashMap<>();
    char[] array1 = string.toCharArray();
    for( Character i : array1){
        if(myHashMap.get(i) == null){
        myHashMap.put(i, true);
        }else{
            return false;
        }
    }
    return true;
}

//find pairs
public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
    HashMap<Integer, Boolean> set = new HashMap<>();
    List<int[]> result = new ArrayList<>();

    // Convert arr1 to a set
    for (int num : arr1) {
        set.put(num, true);
    }

    // Find pairs
    for (int num : arr2) {
        int complement = target - num;
        if (set.containsKey(complement)) {
            result.add(new int[]{complement, num});
        }
    }

    return result;
}



//longest consecutive secuence
/* private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) {
    System.out.println("Test: " + title);
    System.out.print("Testing array: ");
    for (int num : nums) {
        System.out.print(num + " ");
    }
    System.out.println();

    int result = longestConsecutiveSequence(nums);
    System.out.println("Expected longest streak: " + expected);
    System.out.println("Actual longest streak: " + result);

    if (result == expected) {
        System.out.println("PASS\n");
    } else {
        System.out.println("FAIL\n");
    }
} */

}
