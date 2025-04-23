class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count=0, maxSize=0;

        for(int i=1;i<=n;i++){ 
            int digitSum = findDigitsSum(i);
            map.put(digitSum, map.getOrDefault(digitSum, 0)+1);  
            if(map.get(digitSum) == maxSize){
                count++;
            }else if(map.get(digitSum) > maxSize){
                maxSize = map.get(digitSum);
                count =1;
            }
        }
        return count;
    }

    public int findDigitsSum(int num){
        int sum=0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}