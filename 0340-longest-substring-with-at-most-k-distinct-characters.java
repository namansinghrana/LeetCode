//Most optimal using the HashMap Technique
class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        if(s == null || s.length() == 0 || k == 0 | k > s.length()) return 0;
        
        
        Set<Character> checkUnique = new HashSet<>();
        for(char c : s.toCharArray()) checkUnique.add(c);
        
        if(checkUnique.size() < k) return -1;
        
        Map<Character, Integer> map = new HashMap<>();
        int start=0, maxLen=0;
        for(int end=0; end < s.length(); end++){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
        
            while(map.size() > k){
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    
    }
}
