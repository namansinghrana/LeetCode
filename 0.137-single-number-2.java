// Using Sorting Space - O(1)  |  Time - O(nlogn)
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];

        Arrays.sort(nums);
        int result=nums[0];
        int count=1;


        for(int i=1;i<nums.length;i++){
          
          if(nums[i] != nums[i-1]){
            if(count == 1){
              result = nums[i-1]; 
            }
            count = 1;
          }else{ 
            count++;
          }
        }
        if(count == 1) result = nums[nums.length-1];

        return result;
    }
  }
}

// Using HashMap Space - O(n)  |  Time - O(n)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) { map.put(num, map.getOrDefault(num, 0)+1); }

        int result=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){ 
            if(entry.getValue() == 1)  result = entry.getKey();
        }
        return result;
    }
}


//Most Optimized Solution  Space - O(1)  |  Time - O(n)
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;

        for(int k=0;k<=31;k++){
            int temp = (1 << k);
            int countz=0, counto=0;

            for(int num : nums){ if((num & temp) == 0){ countz++; }else{ counto++; } }
            if(counto % 3 == 1){ result = (result | temp); }
        }
        return result;
    }
}
