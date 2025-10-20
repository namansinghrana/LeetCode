class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight=0, sumWeight=0;
        for(int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            sumWeight += weight;
        }
        
        while(maxWeight < sumWeight){
            int mid = maxWeight + (sumWeight - maxWeight)/2;
            if(canShip(weights, days, mid)){
                sumWeight = mid;
            }else{
                maxWeight = mid+1;
            }
        }
        return maxWeight;
    }

    private boolean canShip(int[] weights, int days, int capacity){
        int day=1;
        int currentLoad=0;
        for(int weight : weights){
            if(currentLoad + weight <= capacity){
                currentLoad += weight;
            }else{
                day++;
                currentLoad = weight;
            }
        }
        return day <= days;
    }
}
