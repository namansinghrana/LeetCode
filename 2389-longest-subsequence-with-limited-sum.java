//Brute Force Solution
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length-1;i++) prefix[i] = prefix[i-1] + nums[i];

        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int q = queries[i];
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(prefix[j] > q) break;
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}


//Optimized Solution
//Binary Search
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;

        //Step1 : Calculate Prefix Sums
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++) prefix[i] = prefix[i-1] + nums[i];

        //Step2 : Answer each query using binary search
        int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            answer[i] = upperBound(prefix, queries[i]);
        }
        return answer;
    }

    private int upperBound(int[] arr, int target){
        int low=0, high=arr.length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= target) low = mid+1;
            else high = mid;
        }
        return low;
    }
}
