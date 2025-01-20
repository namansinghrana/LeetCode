class Solution {
    public String minWindow(String s, String t) {
        int n =s.length();
        if(t.length() > n){ return ""; }
        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int requiredCount=t.length();
        int minWindowSize=Integer.MAX_VALUE, start_i=0;
        int i=0,j=0;

        while(j < n){
            char c = s.charAt(j);
            if(map.containsKey(c) && map.get(c) > 0){
                requiredCount--;
            }
            map.put(c, map.getOrDefault(c, 0)-1);

            while(requiredCount == 0){
                int currWindowSize = j-i+1;
                if(minWindowSize > currWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = i;
                }
                char currIndex = s.charAt(i);
                map.put(currIndex, map.getOrDefault(currIndex, 0)+1);
                if(map.containsKey(currIndex) && map.get(currIndex) > 0){
                    requiredCount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);   
    }
}