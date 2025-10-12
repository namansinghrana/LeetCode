class Solution {
    public int maxDistance(int[] position, int m) {
        //Sorted position to create my range
        Arrays.sort(position);

        int left=0, right= position[position.length-1] - position[0];
        //Answer variable - 
        // Required Force / Number of Max windows 
        int result= 0;
        //Binary Search Over Range - Positions.
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

    //function for counting the number of windows we found
    //while simultaneously increasing the distance every iteration
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