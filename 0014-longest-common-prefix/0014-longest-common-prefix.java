class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(String str : strs){
            int i=0;
            while(i < common.length() && i < str.length() && common.charAt(i) == str.charAt(i)){
                i++;
            }
            common = common.substring(0,i);
        }
        return common;
    }
}