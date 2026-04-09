import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Handle edge case
        if (nums == null || nums.length < 4) {
            return result;
        }

        // 2. Sort the array to use two-pointer technique and handle duplicates
        Arrays.sort(nums);
        int n = nums.length;

        // 3. First loop for the first number
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first position
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 4. Second loop for the second number
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second position
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 5. Two-pointer approach for the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to prevent overflow when adding large integers
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate values for the third position
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicate values for the fourth position
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // We need a larger sum
                    } else {
                        right--; // We need a smaller sum
                    }
                }
            }
        }

        return result;
    }
}
