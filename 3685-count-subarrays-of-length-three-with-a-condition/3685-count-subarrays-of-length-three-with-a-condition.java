class Solution {
    public int countSubarrays(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int first = nums[i - 1];
            int second = nums[i];
            int third = nums[i + 1];

            if (first + third == second / 2.0) {
                count++;
            }
        }

        return count;       
    }
}