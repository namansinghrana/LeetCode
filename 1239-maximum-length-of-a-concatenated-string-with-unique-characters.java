// Optimal Solution Time Complexit : O(2^n)
class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();

        for(String s : arr){
            Set<Character> set = new HashSet<>();
            for(char ch : s.toCharArray()){ set.add(ch); }
            if(s.length() != set.size()) continue;

            int currbit = 0;
            for(char c : s.toCharArray()){ currbit |= (1 << (c-'a')); }
            list.add(currbit);
        }

        int[] result = {0};
        dfs(0,0,result,list);
        return result[0];
    }


    private void dfs(int idx,int temp,int[] result, List<Integer> list){
        result[0] = Math.max(result[0], Integer.bitCount(temp));


        for(int i = idx; i < list.size(); i++){
            if((temp & list.get(i)) == 0){
                dfs(i+1, temp | list.get(i), result, list);
            }
        }
    }
}
