class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        int newi=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[newi] = nums[i];
                newi++;
                count++;
            }
        }
        return count;
    }
}