class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i=2; i<=n; i++){
            result = countAndAdd(result);
        }
        return result;
    }

    public static String countAndAdd(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count=1;
        for(int i=1;i<s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }else{
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count=1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}