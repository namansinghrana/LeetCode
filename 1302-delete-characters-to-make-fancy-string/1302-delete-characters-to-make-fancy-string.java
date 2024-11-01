class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count=0;
        char prev= '\0';

        for(char c: s.toCharArray()){
            if(c == prev){
                count++;
            }else{
                prev = c;
                count = 1;
            }

            if(count < 3){
                result.append(c);
            }
        }
        return result.toString();    
    }
}