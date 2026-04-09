class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer to place the next element that is not equal to val
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the value we want to remove
            if (nums[i] != val) {
                // Move it to the 'k' index and increment k
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k; // k is the count of elements not equal to val
    }
}
