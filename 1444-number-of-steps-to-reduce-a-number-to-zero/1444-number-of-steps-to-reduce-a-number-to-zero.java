class Solution {
    public int numberOfSteps(int num) {
        int count=0;
        int result=noS(num, count);
        return result;
    }

    public static int noS(int n,int count){
        if(n == 0){return count;}
        if(n % 2 == 0){ n/=2; }else{ n-=1; }
        return noS(n, count+1);
    }
}