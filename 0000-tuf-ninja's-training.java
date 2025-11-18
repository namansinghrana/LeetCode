//Non optimized firsst 2d grid dp question.
class Solution {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 3, matrix, n, dp);
        }

        private int solve(int day, int last, int[][] matrix, int n, int[][] dp){
            if(day == n) return 0;
            if(dp[day][last] != -1) return dp[day][last];

            int maxPoints=0;

            for(int activity=0; activity<3; activity++){
                if(activity != last){
                    int points = matrix[day][activity] + solve(day, activity, matrix, n, dp);
                    maxPoints = Math.max(maxPoints, points);
                }
            }

            dp[day][last] = maxPoitns;
            return dp[day][last];
        }
}
