//-------------------------Optimal using even and odd counts where we check for shifts-------------------------
// here we using the cumulative xor method in order to find the odd pairs.
class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long result=0;
        long cum_xor=0;

        for(char c : word.toCharArray()){
            //-------------------------Even pairs-------------------------
            int shifts = c - 'a';
            cum_xor ^= (long)(1 << shifts);
            result += map.getOrDefault(cum_xor, 0L);
            //------------------------------------------------------------
            for(char ch = 'a'; ch <= 'j'; ch++){
                shifts = ch-'a';
                long check_xor = (cum_xor ^ (1 << shifts));
                result += map.getOrDefault(check_xor, 0L);
            }
            //------------------------------------------------------------
            //including in map
            map.put(cum_xor, map.getOrDefault(cum_xor, 0L)+1);
        }
        return result;
    }
}
