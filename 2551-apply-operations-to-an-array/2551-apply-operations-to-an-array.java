class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length-1;
        int ptr=0;
        for(int i=0;i<n;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        for(int j=0;j<n+1;j++){
            
            if(nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        return nums;
    }
}