//Solved using prefix Sum and the differences between the prefix sums.
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum= new int[n];
        int[] rightSum= new int [n];
        leftSum[0]=0; rightSum[n-1]=0;
        for(int i=0;i<n-1;i++){ leftSum[i+1] = leftSum[i] + nums[i]; }
        for(int i=n-1;i>0;i--){ rightSum[i-1] = rightSum[i] + nums[i]; }
        
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
}
