class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> map = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-1;i++){

            int j =i+1;
            int k = nums.length-1;
            while(j < k){                
            if(nums[i] + nums[j] + nums[k] == 0){
                map.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
            }else if(nums[i] + nums[j] + nums[k] > 0){
                k--;
            }else{
                j++;
            }

            }

        }

        result.addAll(map);
        return result;
    }
}