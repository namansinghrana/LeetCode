class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }


        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0];
            int y= cell[1];

            for(int[] d : dir){
                int newX = x + d[0];
                int newY = y + d[0];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && dist[newX][newY] == -1){
                    dist[newX][newY] = dist[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return dist;
    }
}
