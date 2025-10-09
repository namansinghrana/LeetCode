class Solution {
    public int numOfSubarrays(int[] arr, int k, int limit) {
        int sum=0, count=0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        if((sum/k) >= limit) count++;

        for(int i=k; i<arr.length; i++){
            sum += arr[i] - arr[i-k];
            if((sum/k) >= limit) count++;
        }

        return count;
    }
}