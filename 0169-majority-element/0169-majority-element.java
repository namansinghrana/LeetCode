class Solution {
    public int majorityElement(int[] nums) {
        int firstcounter=0;
        int first=nums[0];

        for(int num : nums){
            if(num == first){
                firstcounter++;
            }else if(firstcounter == 0){
                first = num;
                firstcounter=1;
            }else{
                firstcounter--;
            }
        }

        return first;
    }
}