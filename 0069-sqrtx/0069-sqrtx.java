class Solution {
    public int mySqrt(int x) {
        int start =0;
        int end=x;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid * mid == x){
                return mid;
            }

            if((long)mid*mid > x){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return Math.round(end);
    }
}

//New one
class Solution {
    public int mySqrt(int x) {
        int left=0, right = x/2;

        if(x < 2) return x;

        while(left <= right){
            int mid = left + (right-left)/2;
            long square = (long)mid * mid;
            if(square == x){
                return mid;
            }else if(square < x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left-1;
    }
}
