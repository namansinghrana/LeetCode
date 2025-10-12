class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
         for(int pile : piles) right = Math.max(right, pile);

         int result = right;

         while(left <= right){
            int mid = left + (right - left)/ 2;

            if(canFinish(piles, h, mid)){
                result = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
         }
         return result;
    }

    private static boolean canFinish(int[] piles, int h, int k){
        long hours = 0;
        for(int  pile : piles){
            hours += (pile + k -1 )/ k;
        }
        return hours <= h;
    }
}