class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0, end=0, sum=0, minLength=Integer.MAX_VALUE;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= target){
                minLength = Math.min(minLength, end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}