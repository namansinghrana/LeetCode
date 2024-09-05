class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int m = rolls.length;
        
        int sum = mean * (m+n);
        for(int i=0; i<m;i++){
            sum -= rolls[i];
        }
        int i=0;
        if(sum >= n && sum < n*6+1){
            while(sum >0){
                result[i] = result[i] +1;
                sum--;
                i++;
                if(i == n){
                    i=0;
                }
            }
        }else{
           return new int[]{};
        }
        return result;
	}
}