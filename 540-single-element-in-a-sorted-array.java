class Solution {
    public int singleNonDuplicate(int[] nums) {
        // we fixated our indices
        int left=0,right=nums.length-1;
        //we started iterating
        while(left < right){
            //got our mid
            int mid = left + (right-left)/2;
            //according to the question there is only one duplicate of every element
            //It means the single element and its next element are not equal
            //and the single can only be placed at an even location. 
            //so we check every element at even location.
            if(mid % 2 == 1) mid--;

            //every element was supposed to be at even index but
            //due to the single element afterwards every pair start at odd index
            //thats what we use for advantage and check for even indices and shrink
            //upto the first corrupted index.
            if(nums[mid] == nums[mid+1]){
                left = mid+2;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
