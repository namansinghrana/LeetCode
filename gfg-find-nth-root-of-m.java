class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int left=1, right = m;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            long ans = 1;
            for(int i=1;i<=n;i++){
                ans *= mid;
                if(ans > m) break;
            }
            if(ans == m) return mid;
            if(ans < m) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
