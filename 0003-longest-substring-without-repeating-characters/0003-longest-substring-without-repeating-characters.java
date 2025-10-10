class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] str = s.toCharArray();
        int start=0, maxLength=0;
        for(int end=0; end<str.length; end++){
            
            while(set.contains(str[end])){
                set.remove(str[start]);
                start++;
            }
            set.add(str[end]);
            maxLength = Math.max(maxLength, set.size());
        }

        return maxLength;
    }
}