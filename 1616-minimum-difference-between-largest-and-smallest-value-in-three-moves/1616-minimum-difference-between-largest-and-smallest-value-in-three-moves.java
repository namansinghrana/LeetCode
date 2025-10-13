class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;
        Arrays.sort(nums);
        int left=0, right=n-1;
        return Math.min(Math.min(nums[right - 3] - nums[left], nums[right - 2] - nums[left + 1]), Math.min(nums[right - 1] - nums[left + 2], nums[right] - nums[left + 3]) );
    }
}