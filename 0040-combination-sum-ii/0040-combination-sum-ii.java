import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // important for duplicate handling
        backtrack(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] candidates,
                           int target, int start, List<Integer> current) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Stop if number exceeds target
            if (candidates[i] > target) break;

            current.add(candidates[i]);

            // Move to next index (no reuse)
            backtrack(result, candidates, target - candidates[i], i + 1, current);

            current.remove(current.size() - 1); // backtrack
        }
    }
}