class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        rec(0, target, arr, ds, ans);
        return ans;
    }

    private void rec(int idx, int target, int[] arr, List<Integer> ds, List<List<Integer>> ans){
        if(idx == arr.length){
            if(target == 0){ ans.add(new ArrayList<>(ds)); }
            return; 
        }

        if(arr[idx] <= target){
            ds.add(arr[idx]);
            rec(idx, target-arr[idx], arr, ds, ans);
            ds.remove(ds.size()-1);
        }

        rec(idx+1, target, arr, ds, ans);
    }
}
