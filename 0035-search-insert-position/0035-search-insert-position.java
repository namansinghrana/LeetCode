class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int l = 0, r = nums.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid]  < target){
                    l = mid+1;
                    index = l;
            }else{  r = mid-1; }
        }

        return index;
    }
}