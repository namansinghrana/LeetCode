class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0, s, memo);
    }

    private static int dfs(int i, String s, int[] memo){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(memo[i] != -1) return memo[i];


        int ways = dfs(i+1, s, memo);
        
        if(i+1 < s.length()){
            int val = Integer.parseInt(s.substring(i, i+2));
            if(val >= 10 && val <= 26) ways += dfs(i+2, s, memo);
        }

        return memo[i] = ways;
    }
}
