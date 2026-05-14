import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {2, 1, 3};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.isGood(nums1));
        
        // Test case 2
        int[] nums2 = {1, 3, 3, 2};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.isGood(nums2));
        
        // Test case 3
        int[] nums3 = {1};
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.isGood(nums3));
    }
}
