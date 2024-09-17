class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
     Map<String, Integer> map = new HashMap<>();
     List<String> result = new ArrayList<>();

     String[] word1 = s1.split(" ");
     String[] word2 = s2.split(" ");

     for(String s : word1){
        map.put(s , map.getOrDefault(s, 0)+1);
     }    

     for(String s : word2){
        map.put(s, map.getOrDefault(s, 0) +1);
     }

     for(Map.Entry<String ,Integer> entry : map.entrySet()){
        if(entry.getValue() == 1){
            result.add(entry.getKey());
        }
     }


     return result.toArray(new String[0]);      
    }
}