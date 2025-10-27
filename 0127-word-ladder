class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0; //word not in dictionary.
        int wordLen = beginWord.length();
        Map<String, List<String>> patternMap = new HashMap<>();

        for(String word : wordSet){
            for(int i=0;i<wordLen;i++){
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                patternMap.computeIfAbsent(pattern, x -> new ArrayList<>());
                patternMap.get(pattern).add(word);
            }
        }


        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        visited.add(beginWord);


        while(!queue.isEmpty()){
            Pair currentP = queue.poll();
            String currWord = currentP.word;
            int currLevel = currentP.level;

            for(int i=0;i<wordLen;i++){
                String pattern = currWord.substring(0, i) + "*" + currWord.substring(i+1);
                for(String nextWord : patternMap.getOrDefault(pattern, new ArrayList<>())){

                    if(nextWord.equals(endWord)) return currLevel+1;
                    if(!visited.contains(nextWord)){
                        visited.add(nextWord);
                        queue.add(new Pair(nextWord, currLevel+1));
                    }
                }
            }
        }
        return 0;
    }

    static class Pair{
        int level;
        String word;

        Pair(String  w, int l){
            this.word = w;
            this.level = l;
        }
    }
}
