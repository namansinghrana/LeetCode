class Solution {
    public int majorityElement(int[] nums) {
        int count = 0; int candidate =nums[0];
        
        for(int current : nums){
            if(count == 0){
                candidate = current;
                count=1;
            }else if(candidate == current){
                count++;
            }else{
                count--;
            }
        }

        return candidate;
    }
}