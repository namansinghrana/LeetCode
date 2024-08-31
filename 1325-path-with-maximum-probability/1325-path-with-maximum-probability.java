class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
       double prob[]= new double[n];
       prob[start_node] = 1;

       for(int i=0; i<n-1; i++){
        int j=0;
        for(int edge[] : edges){     
        int u = edge[0];
        int v = edge[1];
        double w = succProb[j];
        if(prob[u] * w > prob[v]){
            prob[v] = prob[u] * w;
        }
        if(prob[v] * w > prob[u]){
            prob[u] = prob[v] * w;
        }
        j++;
        }
        }
        return prob[end_node];
    }
}