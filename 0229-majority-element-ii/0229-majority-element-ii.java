class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > nums.length/3){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}