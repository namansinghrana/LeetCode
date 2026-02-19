//Solution
class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        int MOD = 1000000007;
        
        long xora = 0;
        long xorb = 0;

        for(int i=49;i>=n;i--){
            int aset = ((a>>i) & 1) > 0 ? 1 : 0;
            int bset = ((b>>i) & 1) > 0 ? 1 : 0;

            if(aset == 1){ xora = (xora ^ (1L << i)); }
            if(bset == 1){ xorb = (xorb ^ (1L << i)); }
        }

        for(int i=n-1;i >= 0; i--){
            int aset = ((a>>i) & 1) > 0 ? 1 : 0;
            int bset = ((b>>i) & 1) > 0 ? 1 : 0;

            if(aset == bset){
                xora = (xora ^ (1L << i));
                xorb = (xorb ^ (1L << i));
                continue;
            }


            if(xora > xorb){
                xorb = (xorb ^ (1L << i));
            }else{
                xora = (xora ^ (1L << i));
            }
        }
        

        xora %= MOD;
        xorb %= MOD;
        return (int)((xora * xorb) % MOD);   
    }
}
