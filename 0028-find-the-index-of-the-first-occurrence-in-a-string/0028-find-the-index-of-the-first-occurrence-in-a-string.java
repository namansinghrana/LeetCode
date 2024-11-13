class Solution {
    public int strStr(String haystack, String needle) {


        int len1 = haystack.length();
        int len2 = needle.length();

        if(len1 < len2){
            return -1;
        }

        for(int i=0;i<= len1-len2;i++){
            String substr = haystack.substring(i, i+len2);
            if(substr.equals(needle)){
                return i;
            }
        }
        
        return -1;
    }
}