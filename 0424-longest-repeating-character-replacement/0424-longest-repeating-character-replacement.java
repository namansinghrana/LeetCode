class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res=0;
        int i=0,maxf=0;
        for(int j=0;j<s.length();j++){
            count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0)+1);
            maxf = Math.max(maxf, count.get(s.charAt(j)));

            while(j-i+1 - maxf > k){
                count.put(s.charAt(i), count.get(s.charAt(i))-1);
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}