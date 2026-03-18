// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> res = new ArrayList<>();
        int n = s.length();
        int total = (1 << n);
        
        for(int currentMask = 0; currentMask < total; currentMask++ ){
            StringBuilder tempStr = new StringBuilder();
            for(int i=0; i<n; i++){
                if((currentMask & (1 << i)) != 0){
                    tempStr.append(s.charAt(i));
                }
            }
            res.add(tempStr.toString()); 
        }
        
        //----------------------------------------------------------------------
        //This line is not necessary It was just to match the output of Cases - Gfg
        Collections.sort(res); // O(n log n)
        //----------------------------------------------------------------------
        return res;
    }
}

// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        rec(s, 0,  str, res);         
        //----------------------------------------------------------------------
        //This line is not necessary It was just to match the output of Cases - Gfg
        Collections.sort(res); // O(n log n)
        //----------------------------------------------------------------------
        return res;
    }
    
    private void rec(String s, int idx, StringBuilder str, List<String> res){
        if(idx == s.length()){
            res.add(str.toString());
            return;
        }
        
        rec(s, idx+1, str, res);
        str.append(s.charAt(idx));
        rec(s, idx+1, str, res);
        str.deleteCharAt(str.length()-1);
    }
}
