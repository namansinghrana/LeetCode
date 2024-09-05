class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        visit[source] = true;
        q.add(source);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp == destination){
                return true;
            }
 
            for(int connect : graph.get(temp)){
                if(visit[connect] == false){
                    visit[connect] = true;
                    q.add(connect);
                }
            }
        }
        return false;
    }
}