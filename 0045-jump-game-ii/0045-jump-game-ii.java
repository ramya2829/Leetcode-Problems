class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;   // end of current jump range
        int farthest = 0;     // farthest we can reach

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of current range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}