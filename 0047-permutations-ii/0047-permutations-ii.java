import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // important for duplicate handling
        boolean[] used = new boolean[nums.length];
        backtrack(result, nums, used, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums,
                           boolean[] used, List<Integer> current) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(result, nums, used, current);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}