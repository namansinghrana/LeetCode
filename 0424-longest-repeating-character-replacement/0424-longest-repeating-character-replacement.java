//Hashing and Collision Overhead
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res=0;
        int l=0,maxf=0;
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) +1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));
            while((r-l+1) - maxf > k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

//O(1) indexing
//No hashing, No colllsion
class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen=0, maxOccurence=0;
        int[] count = new int[26];
        int start=0;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'A']++;
            if(count[s.charAt(i) - 'A'] > maxOccurence){ maxOccurence = count[s.charAt(i) - 'A']; }
            while(i-start+1 - maxOccurence > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
}
