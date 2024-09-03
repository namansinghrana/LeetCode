class Solution {
    public int getLucky(String s, int k) {
        StringBuilder number = new StringBuilder();
        for(char c : s.toCharArray()){
            number.append( c - 'a' + 1);
        }

        while(k > 0){
            int sum = 0;
            for(char x : number.toString().toCharArray()){
                 sum += x - '0';
            }
            number = new StringBuilder(String.valueOf(sum));
            k--;
        }

        return Integer.parseInt(number.toString());
    }
}