class Solution {
    public int removeDuplicates(int[] nums) {
        // If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // 'i' is the pointer for the position of the last unique element found
        int i = 0;

        // 'j' is the explorer pointer that scans the array
        for (int j = 1; j < nums.length; j++) {
            // If we find a value that is different from the current unique element
            if (nums[j] != nums[i]) {
                // Move the unique pointer forward
                i++;
                // Update the next unique position with the new value found
                nums[i] = nums[j];
            }
        }

        // The number of unique elements is the index i + 1
        return i + 1;
    }
}
