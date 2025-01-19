class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);
        
        for(int i=0; i<=m-n; i++){
            char[] sortedTemp = s2.substring(i, i+n).toCharArray();
            Arrays.sort(sortedTemp);
            if(Arrays.equals(sortedTemp, sortedS1)){ return true; }
        }
        return false;
    }
}