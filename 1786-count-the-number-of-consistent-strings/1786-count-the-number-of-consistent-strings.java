class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        Set<Character> allowedSet = new HashSet<>();

        for(char c : allowed.toCharArray()){
            allowedSet.add(c);
        }

        for(String word : words){
            boolean isConsistent= true;

            for(char c : word.toCharArray()){
                if(!allowedSet.contains(c)){
                    isConsistent= false;
                    break;
                }
            }

            if(isConsistent){
                count++;
            }
        }
        return count;
    }
}