class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    public void backtrack(int i,List<Integer> cur,int total, int[] nums, int target){
        if(target == total){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j=i;j<nums.length;j++){
            if(total + nums[j] > target){
                return;
            }
            cur.add(nums[j]);
            backtrack(j, cur, total+nums[j], nums, target);
            cur.remove(cur.size() - 1);
        }
    }
}