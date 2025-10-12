class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=0;
        int right= position[position.length-1] - position[0];
        int result= 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canPlaceBalls(position, m, mid)){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }

    private static boolean canPlaceBalls(int[] position, int m, int distance){
        int count=1;
        int lastPlaced=position[0];

        for(int end=1; end<position.length; end++){
            if(position[end] - lastPlaced >= distance){
                count++;
                lastPlaced = position[end];
            }
        }

        return count >= m;
    }
}