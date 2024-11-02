class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] str = sentence.split(" ");
        char temp = str[0].charAt(str[0].length()-1);

        for(int i=1;i<str.length; i++){
            
            if(temp != str[i].charAt(0)){
                return false;
            }
            temp = str[i].charAt(str[i].length()-1);
        }
        return temp == str[0].charAt(0);
    }
}