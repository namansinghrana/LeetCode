class Solution {


    public void dfs(char[][] board, int r, int c){

        if(r < 0 || c <0 || r >= board.length || c >= board[0].length ||board[r][c] == '.'){
            return;
        }

        board[r][c] = '.';
        dfs(board, r-1 ,c);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }
    
    public int countBattleships(char[][] board) {
    int battleships=0;

    for(int i=0; i < board.length; i++){
        for(int j = 0; j< board[0].length; j++){
            if(board[i][j] == 'X'){
                battleships++;
                dfs(board, i, j);
            }
        }
    }

    return battleships;
    }
}