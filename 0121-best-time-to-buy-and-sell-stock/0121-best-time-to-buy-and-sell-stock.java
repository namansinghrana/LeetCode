class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=1;
        int res=0;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                int curP = prices[r] - prices[l];
                res = Math.max(res, curP);
            }else{
                l = r;
            }
            r++;
        }
        return res;
    }
}