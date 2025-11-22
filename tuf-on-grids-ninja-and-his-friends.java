class Solution {
    public int maxChocolates(int[][] g) {
        // Your code goes here
        int m = g.length;
        int n = g[0].length;
        Integer[][][] dp  = new Integer[m][n][n];
        return dfs(0,0,n-1,m,n,g,dp);
    }
    private int dfs(int i,int j1,int j2,int m,int n,int[][] g,Integer[][][] dp){
        
        if(j1 >= n || j2 >= n || j1 < 0 || j2 < 0 ) return Integer.MIN_VALUE/2;

        if(i == m-1){
            if(j1 == j2) return  g[i][j1];
            return g[i][j1] + g[i][j2];
        }

        if(dp[i][j1][j2] != null) return dp[i][j1][j2];

        int max = 0;
        for(int a = -1; a <= 1; a++){
            for(int b = -1; b <= 1; b++){
                max = Math.max(max, dfs(i+1,j1+a,j2+b,m,n,g,dp));
            }
        }
        int curr = (j1 == j2) ? g[i][j1] : g[i][j1] + g[i][j2];
        return dp[i][j1][j2] = curr + max; 
    }
}
