class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int i=0;
        int j=1;
        while(j < nums.length){ 
            if(nums[j] == nums[i]){
                j++;
                
            }else if(nums[j] != nums[i]){
                nums[i+1] = nums[j];
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}