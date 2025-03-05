class Solution {
    public long coloredCells(int n) {
        long cells=1;
        for(int i=2;i<=n;i++){
            cells += (i - 1)* 4;
        }
        return cells;
    }
}