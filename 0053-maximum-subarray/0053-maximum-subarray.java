class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}


//Revision Brute Force Solution 2026
class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            
            for(int j=i+1;j<n;j++){
                currSum += nums[j];
                res = Math.max(res, currSum);
            }
        }
        return res;
    }
}

//Revision Revised Kadane's Algo Solution 2026
class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int currSum =0, res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(currSum + nums[i] < nums[i]){
                currSum = nums[i];
            }else{  
                currSum += nums[i]; 
            }
            res = Math.max(res, currSum);
        }
    return res;
    }
}
