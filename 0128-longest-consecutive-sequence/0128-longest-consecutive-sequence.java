// O(n log n)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 1, curr=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] == nums[i]) continue;
            if(nums[i-1] + 1 == nums[i]){
                curr++;
            }else{ curr=1; }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
// O( n )
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){ set.add(num); }
        
        int longest=0;
        for(int num : set){
            if(!set.contains(num-1)){
                int length=1;
                while(set.contains(num+length)){ length++; }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
