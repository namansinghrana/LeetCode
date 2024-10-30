class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(int s = 1; s< strs.length; s++){
            String str = strs[s];
            int i=0;

            if(common == ""){
                return "";
            }

            while( i < common.length() && i < str.length() && common.charAt(i) == str.charAt(i)){
                i++;
            }
                common = common.substring(0,i);
        }
        return common;
    }
}