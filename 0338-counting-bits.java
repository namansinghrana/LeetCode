// Naive Approach O(nlogn) - time | O(1) - space
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i=0;i<=n;i++){
            //temporay variable to count 1's.
            int curr=0;
            int temp = i;
            while(temp != 0){
                //And operation for single iteration.
                if((temp & 1) == 1){ curr++; }
                //incrementing by left shifting it.
                temp >>= 1;
            }
            //final value of temporary variable
            ans[i] = curr;
        }
        return ans;
    }
}

// Optimal Approach O(nlogn) - time | O(1) - space
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        if(n == 0) return ans;
        
        ans[0] = 0;

        for(int i=1;i<=n;i++){

            //By heavy observation of pattern in our inputs and their outputs
            //their mathematical nature.
            if(i % 2 != 0){
                ans[i] = ans[i/2] + 1;
            }else{
                ans[i] = ans[i/2];
            }
        }

        return ans;
    }
}
