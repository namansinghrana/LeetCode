class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] memo = new Integer[n][n];
        int ans = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            ans = Math.min(ans, dfs(0,j,n,matrix,memo));
        }
        return ans;
    }

    private int dfs(int i,int j,int n,int[][] m, Integer[][] memo){

        if(j < 0 || j >= n){ return Integer.MAX_VALUE;}
        if(i == n-1) return m[i][j];
        if(memo[i][j] != null) return memo[i][j];

        int down = dfs(i+1,j,n,m,memo);
        int downRight =  dfs(i+1,j+1,n,m,memo);
        int downLeft =  dfs(i+1,j-1,n,m,memo);

        return memo[i][j] = m[i][j] + Math.min(Math.min(downRight,downLeft ), down);
    }
}
