class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        perMute(nums ,0 ,result);
        return result;
    }


    public void perMute(int[] nums ,int currIndex ,List<List<Integer>>result){
        
        if(currIndex == nums.length-1){
            List<Integer> currPer = new ArrayList<>();
                for(int num : nums){
                    currPer.add(num);
                }
            result.add(currPer);
            return;
        }

        for(int index =currIndex; index < nums.length; index++){
            swap(nums,currIndex,index);
            perMute(nums,currIndex+1,result);
            swap(nums,currIndex,index);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}