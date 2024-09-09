class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] indices = new int[2];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<=n-1;j++){
                if(target - nums[j] == nums[i]){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }
}