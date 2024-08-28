class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return dest(grid, new int[m][n], 0 ,0, m , n);
    }

    public int dest(int[][] grid,int[][] dp, int i, int j, int m , int n){
        if(i == m-1 && j == n-1) return grid[i][j];

        if(dp[i][j] > 0) return dp[i][j];

        if(i == m-1) {
            dp[i][j] = grid[i][j] + dest(grid,dp,i,j+1,m,n);
        }else if(j == n-1){
            dp[i][j] = grid[i][j] + dest(grid,dp,i+1,j,m,n);
        }else{
            dp[i][j] = grid[i][j] + Math.min(dest(grid,dp,i+1,j,m,n),
            dest(grid,dp,i,j+1,m,n));
        }

        return dp[i][j];
    }
}