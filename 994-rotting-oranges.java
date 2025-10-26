class Solution {
    public int orangesRotting(int[][] grid){
        int row = grid.length;
        int cols = grid[0].length;
        int freshCounts=0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    freshCounts++;
                }else if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int minutes=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean check = false;
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                
                for(int[] d: dir){
                    int newX = x + d[0];
                    int newY = y + d[1];

                    if(newX >= 0 && newX < row && newY >= 0 && newY < cols && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        freshCounts--;
                        check = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            if(check) minutes++;
        }
        return freshCounts == 0 ? minutes : -1;
    }
}
