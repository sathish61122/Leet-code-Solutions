import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1. Sort the array to use the two-pointer approach
        Arrays.sort(nums);
        
        // Initialize closestSum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // 2. Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If we found the exact target, return it immediately
                if (currentSum == target) {
                    return currentSum;
                }
                
                // Update closestSum if the currentSum is closer to the target
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                
                // Move pointers based on the comparison with target
                if (currentSum < target) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }
        
        return closestSum;
    }
}
