class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left=Integer.MAX_VALUE, right=Integer.MIN_VALUE;
        if((long)m*k > bloomDay.length) return -1;
        for(int day : bloomDay){
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int ans=0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canMakeB(bloomDay, mid, m, k)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    private boolean canMakeB(int[] bloomDay, int day, int m, int k){
        int bouquets=0, flowers=0;
        for(int bloom : bloomDay){
            if(bloom <= day){
                flowers++;
                if(flowers == k){ bouquets++; flowers=0; }
            }else{
                flowers=0;
            }
        }
        return (bouquets >= m);
    }
}
