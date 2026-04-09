import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to use two pointers and easily skip duplicates
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // 2. Skip the same element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, move the left pointer to the right
                    left++;
                } else {
                    // Sum is too large, move the right pointer to the left
                    right--;
                }
            }
        }
        
        return result;
    }
}
