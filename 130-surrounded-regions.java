class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0;i<n;i++){
            if(board[i][0] == 'O') queue.add(new int[]{i,0});
            if(board[i][m-1] == 'O') queue.add(new int[]{i, m-1});
        }

        for(int j=0;j<m;j++){
            if(board[0][j] == 'O') queue.add(new int[] {0, j});
            if(board[n-1][j] == 'O') queue.add(new int[] {n-1, j});
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x=cell[0], y=cell[1];

            if(board[x][y] == 'X') continue;
            
            board[x][y] = 'S';

            for(int[] d : dir){
                int newX = x + d[0], newY = y + d[1];
                if(newX >= 0 && newX < n 
                && newY >= 0 && newY < m
                && board[newX][newY] == 'O'){
                    queue.add(new int[] {newX, newY});
                }
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
}
