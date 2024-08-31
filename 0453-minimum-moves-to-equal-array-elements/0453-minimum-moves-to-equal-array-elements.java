class Solution {
    public int minMoves(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int min=nums[0];
        int res=0;

        for(int i=0;i<n;i++){
            res += nums[i] - min;
        }

        return res;
    }
}