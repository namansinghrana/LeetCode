//Naive Solution with time complexty of O(nlogn * log(n))
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] newA = new Integer[n];
        for(int i=0;i<n;i++){ newA[i] = arr[i]; }

        Arrays.sort(newA, (a, b) -> {
            int countA = countOneBits(a);
            int countB = countOneBits(b);

            if(countA == countB) return a.compareTo(b);
            return Integer.compare(countA, countB);
        });

        for(int i=0;i<n;i++){ arr[i] = newA[i]; }
        return arr;
    }

    public int countOneBits(int num){
        int count=0;
        while(num != 0){
            if((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
    }
}


//Optimal Solution with time complexity of O(nlogn) 
//Only sorting
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] newA = new Integer[n];
        for(int i=0;i<n;i++){ newA[i] = arr[i]; }

        Arrays.sort(newA, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if(countA == countB) return a.compareTo(b);
            return Integer.compare(countA, countB);
        });

        for(int i=0;i<n;i++){ arr[i] = newA[i]; }
        return arr;
    }
}
