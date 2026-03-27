import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] candidates,
                           int target, int start, List<Integer> current) {

        // Base case
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);

            // Stay at same index (can reuse element)
            backtrack(result, candidates, target - candidates[i], i, current);

            current.remove(current.size() - 1); // backtrack
        }
    }
}