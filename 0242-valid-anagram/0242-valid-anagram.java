class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c-'a']++;
        }

        for(char c : t.toCharArray()){
            count[c-'a']--;
        }


        boolean allZeroes = Arrays.stream(count).allMatch(element -> element == 0);
        return allZeroes;
    }
}