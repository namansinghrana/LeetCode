class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        int newI=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[newI] = nums[i];
                count++;
                newI++;
            }
        }
        return count;
    }
}