class Solution {
    public void helper(int nums[], int n, List<Integer> temp, List<List<Integer>> res, int idx){
        if(idx == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        helper(nums, n, temp, res, idx + 1);
        temp.remove(temp.size() - 1);
        helper(nums, n, temp, res, idx + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        helper(nums, n, temp, res, 0);
        return res;
    }
}