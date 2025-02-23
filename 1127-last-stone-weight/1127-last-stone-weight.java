class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stone : stones){
            pq.offer(-stone);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            if(first < second){
                pq.offer(first - second);
            }
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}