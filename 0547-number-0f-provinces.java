//Connected Components in Graph using DFS
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){ graph.add(new ArrayList<>()); }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j] == 1 && i != j){ graph.get(i).add(j); }
            }
        }

        boolean[] vis = new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(graph,i,vis);
                count++;
            }
        }

        return count;
    }


    private void dfs(List<List<Integer>> graph,int i,boolean[] vis){
        vis[i] = true;

        for(int next : graph.get(i)){
            if(!vis[next]){
                dfs(graph,next,vis);
            }
        }
    }
}
