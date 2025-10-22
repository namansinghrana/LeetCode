class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        return binarySearchSorted(nums, target, start, end);
    }

    static int binarySearchSorted(int[] nums, int target, int start, int end){
        if(start > end){ return -1; }
        int mid = start + (end-start)/2;
        if (nums[mid] == target){ return mid; }

        if(nums[start] <= nums[mid]){
            if(nums[start] <= target && target <= nums[mid]){
                return binarySearchSorted(nums, target, start, mid-1);
            }else{
                return binarySearchSorted(nums, target, mid+1, end);
            }
        }

        if(target >= nums[mid] && target <= nums[end]){
            return binarySearchSorted(nums, target, mid+1, end);
        }
        
        return binarySearchSorted(nums, target, start, mid-1);
    }
}

//New Solution
//Simpler One
class Solution {
    public int search(int[] nums, int target) {
        int left=0, right= nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
