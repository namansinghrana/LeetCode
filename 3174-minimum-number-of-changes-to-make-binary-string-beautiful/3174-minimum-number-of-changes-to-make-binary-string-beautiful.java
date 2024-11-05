class Solution {
    public int minChanges(String s) {
        int n = s.length();
        char ch =s.charAt(0);
        int count=0;
        int changes=0;

        for(int i=0; i<n; i++){

            if(s.charAt(i) == ch){
                count++;
                continue;
            }

            //if code comes here it means its not equal to the previous character so...
            if(count%2 == 0){
                count = 1;
            }else{
                changes++;
                count = 0;
            }            
            ch = s.charAt(i);
        }
        return changes;
    }
}