//Own written java edition Fractional KnapSack

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        
        List<Pair> arr = new ArrayList<>();
        
        for(int i=0;i<n;i++){ arr.add(new Pair(val[i], wt[i]));    }
        
        arr.sort( (a,b) -> Double.compare(
            (double) b.val / b.wt,
            (double) a.val / a.wt
        ));
        
        
        double result=0;
        for(int i=0;i<n;i++){
            Pair p = arr.get(i);
            if(p.wt <= capacity){
                result += p.val;
                capacity -= p.wt;
            }else{
                result += ((double) p.val/ p.wt) * capacity;
                break;
            }
        }
        return result;
    }
    
    private class Pair{
        int val;
        int wt;
        
        Pair(int val, int wt){
            this.val = val;
            this.wt = wt;
        }
    }
}
