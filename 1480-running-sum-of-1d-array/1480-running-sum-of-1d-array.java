class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;nums[i]+=nums[i-1],i++);
        return nums;
    }
}