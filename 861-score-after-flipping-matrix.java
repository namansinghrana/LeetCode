//My without watched solution
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i=0;i<m;i++){
            //check the msb
            if(grid[i][0] == 0){
                //flip the row.
                for(int j=0;j<n;j++){ grid[i][j] = 1 - grid[i][j]; }
            }
        }


        for(int j=0;j<n;j++){
            int zero=0;
            //loop to count zero
            for(int i=0;i<m;i++){ if(grid[i][j] == 0) zero++; }
            int ones = m - zero;
            //check if zero is greater than ones
            if(zero > ones){
                for(int i=0;i<m;i++){ grid[i][j] = 1 - grid[i][j]; }
            }
        }

        int total=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j] * (int) Math.pow(2, n-j-1); 
                total += val;    
            }
        }
        return total;
    }
}

//In this we jsut didn't modified the input
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int score = (int) Math.pow(2, n-1) * m;

        for(int j=1;j<n;j++){
            
            int countSameBits = 0;
            for(int i=0;i<m;i++){
                if(grid[i][j] == grid[i][0]) countSameBits++;
            }
            int countOnes = countSameBits;
            int countZeros = m - countOnes;
            int ones = Math.max(countOnes, countZeros);
            score += Math.pow(2, n-j-1) * ones;
        }
        
        return score;
    }
}
