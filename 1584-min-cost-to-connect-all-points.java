//Optimal Sol
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});

        int totalCost=0;
        int connected = 0;

        while(connected < n){
            int[] curr = pq.poll();
            int curIndex= curr[0];
            int curCost=curr[1];

            if(visited[curIndex]) continue;

            visited[curIndex] = true;
            totalCost += curCost;

            connected++;

            for(int nextIndex=0;nextIndex<n;nextIndex++){
                if(!visited[nextIndex]){
                    int newCost = manhattan(points[curIndex], points[nextIndex]);
                    pq.offer(new int[] {nextIndex, newCost});
                }
            }
        }
        return totalCost;
    }

    private int manhattan(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
