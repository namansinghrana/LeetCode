class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        

        int[][] dir = 
        {   
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1} 
        };


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1});
        grid[0][0] = 1;

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y =cell[1];
            int pathD = cell[2];

            if(x == n-1 && y == n-1) return pathD;

            for(int[] d : dir){
                int nr = x + d[0];
                int nc = y + d[1];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0){


                    grid[nr][nc] = 1;
                    queue.add(new int[] {nr, nc, pathD+1});
                }
            }
        }
        return -1;
    }
}
