class Solution {
    public int minMoves(int[] nums) {

        int n = nums.length;

        int min=nums[0];
        int res=0;

        for(int i=0; i<n; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }

        for(int i=0;i<n;i++){
            res += nums[i] - min;
        }

        return res;
    }
}