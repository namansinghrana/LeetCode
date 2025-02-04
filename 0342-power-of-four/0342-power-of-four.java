class Solution {
        public boolean isPowerOfFour(int n) {
        boolean x = helper(n) == 1 ? true : false;
        return x;
    }

    public static int helper(int n){
        if(n == 1){ return 1; }
        if(n ==0 || n%4 != 0){ return 0; }
        return helper(n/4);
    }
}