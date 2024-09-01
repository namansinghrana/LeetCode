class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int n1 = original.length;

        if(n1 != m*n) return new int[0][];
        int ans[][] = new int[m][n];

        for(int idx=0; idx<n1; idx++){
            int nr = idx/n;
            int nc = idx%n;
            ans[nr][nc] = original[idx];
        }
        return ans;
    }
}