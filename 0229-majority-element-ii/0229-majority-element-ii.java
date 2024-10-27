class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int first=nums[0],second=nums[0];
        int firstcounter=0,secondcounter=0;

        for(int num:nums){
            if(num == first){
                firstcounter++;
            }else if(num == second){
                secondcounter++;
            }else if(firstcounter == 0){
                first=num;
                firstcounter = 1;
            }else if(secondcounter == 0){
                second=num;
                secondcounter = 1;
            }else{
                firstcounter--;
                secondcounter--;
            }
        }

        firstcounter=0;
        secondcounter=0;

        for(int num : nums){
            if(num == first) firstcounter++;
            if(num == second) secondcounter++;
        }

        List<Integer> list = new ArrayList<>();
        if(first == second){ list.add(first); }else{
        if(firstcounter > (nums.length/3)) list.add(first);
        if(secondcounter > (nums.length/3)) list.add(second);
        }
        
        return list;
    }
}