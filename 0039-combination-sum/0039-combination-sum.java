class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(candidates, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> curr, int i){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || i >= nums.length) return;

        curr.add(nums[i]);
        backtrack(nums, target-nums[i], curr, i);
        curr.remove(curr.size()-1);
        backtrack(nums, target, curr, i+1);
    }
}