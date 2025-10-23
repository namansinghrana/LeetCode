//Naive One
//-------------------------------
class Solution{
    public int findMin(int[] nums){
        int min=Integer.MAX_VALUE;
        for(int num : nums){ min = Math.min(min, num);}
        return min;
    }
}


//-------------------------------
class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int res= nums[0];
        while(l <= r){
            if(nums[l] <= nums[r]){
                res = Math.min(nums[l], res);
                break;
            }
            
            int mid = l + (r-l)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] >= nums[l]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return res;
    }
}

//Another One
class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while(left< right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
