class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        int n= chalk.length;
        for(int i=0;i<n;i++){
            sum += chalk[i];
        }
        int remainingChalks = (int)(k % sum);
        for(int i=0; i<n ;i++){
            if(remainingChalks < chalk[i]){
                return i;
            }
        remainingChalks -= chalk[i];
        }
        return -1;
    }
}