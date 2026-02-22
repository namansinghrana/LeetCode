class Solution {
    static long[] bitCount;


    public static void getBits(long num){
        if(num == 0) return;
        if(num == 1){ bitCount[0]++; return; }
        if(num == 2){
            bitCount[0]++;
            bitCount[1]++;
            return;
        }

        long bitLen = (long) (Math.log(num) / Math.log(2));
        long nearPow2 = (1L << bitLen);
        bitCount[(int)bitLen] += (num - nearPow2 + 1);

        for(int i=0;i<bitLen;i++){ bitCount[(int)i] += nearPow2/2; }

        num -= nearPow2;
        getBits(num);
    }

    public long findMaximumNumber(long k, int x) {
        long low = 0, high = (long) 1e15;

        long result=0;
        while(low <= high){
            long mid = low + (high - low) /2;
            bitCount = new long[65];
            Arrays.fill(bitCount, 0);

            getBits(mid);
            long obtain=0;
            for(int i=0; i< (long) (Math.log(mid) / Math.log(2))+1; i++){
                if((i+1) % x == 0){ obtain += bitCount[(int)i]; }
            }

            if(obtain <= k){
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
}
