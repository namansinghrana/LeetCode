//by function left shifting and finding the common part in our binary representation.
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shifted=0;
        while(left != right){
            left >>=1; right >>=1;
            shifted++;
        }
        return (left << shifted);
    }
}
//by function [ n & (n-1) ]
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left){ right = (right & (right-1)); }
        return right;
    }
}
