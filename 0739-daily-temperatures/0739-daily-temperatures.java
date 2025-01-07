class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){ 
                int[] currPair = stack.pop();
                res[currPair[1]] =  i - currPair[1];
            }
            stack.push(new int[] {t, i});
        }
        return res;
    }
}