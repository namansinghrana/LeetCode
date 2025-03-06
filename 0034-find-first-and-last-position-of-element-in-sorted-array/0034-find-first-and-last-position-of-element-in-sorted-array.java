class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    public  int findFirst(int[] nums, int target) {
        int l=0,r=nums.length-1,first=-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                first = mid;
                r = mid-1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{ r = mid-1; }
        }
        return first;
    }
    
    public int findLast(int[] nums, int target) {
        int l=0,r=nums.length-1,last=-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                last = mid;
                l = mid + 1;
            }else if(nums[mid] < target){
                    l = mid+1;
            }else{  r = mid-1; }
        }
        return last;
    }
}