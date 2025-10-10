class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans=0, start=0;
        for(int end=0; end<fruits.length; end++){
            int current = fruits[end];
            count.put(current, count.getOrDefault(current, 0)+1);
            ans++;

            if(count.size() > 2){
                int delete = fruits[start];
                count.put(delete, count.get(delete)-1);
                if(count.get(delete) == 0){ count.remove(delete); }
                ans--;
                start++;
            }
        }
        return ans;
    }
}