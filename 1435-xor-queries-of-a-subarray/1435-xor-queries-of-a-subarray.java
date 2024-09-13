class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int k=0;
        for(int[] query : queries){
            int i=query[0];
            int j=query[1];
            int xor=0;
            for(int idx = i ; idx <= j ; idx++){
                xor = xor ^ arr[idx];
            }
            answer[k]=xor;
            k++;
        }
        return answer;
    }
}