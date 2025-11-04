//Complexity O(n log k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){ map.put(num, map.getOrDefault(num, 0)+1); }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            heap.offer(new int[] {entry.getValue(), entry.getKey()});
            if(heap.size() > k){
                heap.poll();
            }
        } 

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = heap.poll()[1];
        }
        return res;
    }
}
//Complexity O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){ freq.put(num, freq.getOrDefault(num, 0)+1); }

        List<Integer>[] bucket = new List[n+1];

        for(int key : freq.keySet()){
            int counting = freq.get(key);
            if(bucket[counting] == null){ bucket[counting] = new ArrayList<>(); }
            bucket[counting].add(key);
        }

        List<Integer> resList = new ArrayList<>();
        for(int i = bucket.length-1; i>=0 && resList.size() < k; i--){
            if(bucket[i] != null){ resList.addAll(bucket[i]); }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){res[i] = resList.get(i);}
        return res;
    }
}
