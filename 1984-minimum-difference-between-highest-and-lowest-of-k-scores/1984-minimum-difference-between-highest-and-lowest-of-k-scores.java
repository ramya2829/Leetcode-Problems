import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k <= 1) return 0;  // difference is 0 if we choose 1 or 0 elements

        Arrays.sort(nums); // sort the array
        int minDiff = Integer.MAX_VALUE;

        // Sliding window of size k
        for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
