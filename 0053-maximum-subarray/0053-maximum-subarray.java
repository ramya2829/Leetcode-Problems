class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend or start new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update max
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}