class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int currAltitude=0,maxAltitude=0;
        for(int i=0;i<n;i++){
            currAltitude += gain[i];
            maxAltitude = Math.max(currAltitude, maxAltitude);
        }
        return maxAltitude;
    }
}
