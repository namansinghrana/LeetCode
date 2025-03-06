class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l=0,r=n-1;
        int index = n-1;
        while(l <= r){
            int leftSquare = nums[l] * nums[l];
            int rightSquare = nums[r] * nums[r];
            if(leftSquare > rightSquare){
                result[index] = leftSquare;
                l++;
            }else{
                result[index] = rightSquare;
                r--;
            }
            index--;
        }
        return result;
    }
}