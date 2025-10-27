//Dijkstra Algo
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] node : times){
            int u = node[0];
            int v = node[1];
            int w = node[2];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[] {v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1] );
        pq.offer(new int[] {k, 0});

        Map<Integer, Integer> dist = new HashMap<>();
        
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if(!dist.containsKey(node)) continue;
            dist.put(node, time);


            if(graph.containsKey(node)){
                for(int[] neighbour : graph.get(node)){
                    int next = neighbour[0];
                    int w = neighbour[1];

                    if(!dist.containsKey(next)) pq.offer(new int[]{next, time + w});
                }
            }
        }

        if(dist.size() != n) return -1;

        int maxTime=0;
        for(int val : dist.values()) maxTime = Math.max(val, maxTime);
        return maxTime;
    }
}
