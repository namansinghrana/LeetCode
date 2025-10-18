class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int w = words.length;
        int[] mirrorArray = new int[w];
        int idx=0;
        for(String s : words){
            char start = s.charAt(0);
            char end = s.charAt(s.length()-1);
            if(isVowel(start) && isVowel(end)){ mirrorArray[idx++] = 1; }
            else{ mirrorArray[idx++] = 0; }
        }
        List<Integer> result = new ArrayList<>();
        for(int[] query : queries){
            int start = query[0], end=query[1];
            int sum=0;
            while(start <= end){ sum += mirrorArray[start++]; }
            result.add(sum);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    private boolean isVowel(char c){
        return (c == 'a' ||c == 'e' ||c == 'i' || c == 'o' ||c == 'u');
    }
}
