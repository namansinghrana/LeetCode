class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return dfs(0, 0, triangle, memo);
    }

    private int dfs(int i, int j, List<List<Integer>> t, Integer[][] memo){
        if(memo[i][j] != null) return memo[i][j];

        if(i == t.size()-1) return t.get(i).get(j);

        int down = dfs(i+1,j,t,memo);
        int diag = dfs(i+1,j+1,t,memo);

        return memo[i][j] = t.get(i).get(j) + Math.min(down, diag);
    }
}
