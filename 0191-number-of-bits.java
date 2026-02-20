// T.C - O(log2(n))
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n > 0){
            count+= (n % 2);
            n /= 2;
        }
        return count;
    }   
}

//the craizest solution O(k) = k = number of bits
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n > 0){
            n = (n & (n-1));
            count++;
        }
        return count;
    }   
}

//Self written function O(32) = number of bits;
class Solution {
    public int hammingWeight(int n) {
      int count=0;
      while(n != 0){
        if((n & 1) == 1) count++;
        n >>=1;
      }
      return count;
    }   
}


//In build function T.C = O(n);
class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }   
}

