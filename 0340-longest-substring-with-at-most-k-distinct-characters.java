//Most optimal using the HashMap Technique
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Your code here
        Map<Character, Integer> map = new HashMap<>();
        int start=0, maxLen=0;
        for(int end=0; end < s.length(); end++){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
        
            if(map.size() > k){
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                start++;
            }
            if(map.size() == k) maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}
