class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l =0, r = n-1;
        int index=n-1;
        while(l <= r){
            int lSquare = nums[l] * nums[l];
            int rSquare = nums[r] * nums[r];

            if(lSquare > rSquare){
                result[index] = lSquare;
                l++;
            }else{
                result[index] = rSquare;
                r--;
            }
            index--;
        }
        return result;
    }
}