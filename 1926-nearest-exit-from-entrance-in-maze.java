// With Help of BFS
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < rows 
                && nc >= 0 && nc < cols
                && maze[nr][nc] == '.' ){
                    // Final Answer WHen we found way out
                    //at corners
                    if(nr == 0 || nr == rows-1 || nc == 0 || nc == cols-1) return steps+1;

                    maze[nr][nc] = '+';
                    queue.add(new int[] {nr, nc, steps+1});
                }
            }
            
        }
        return -1;
    }
}
