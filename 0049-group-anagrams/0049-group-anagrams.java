class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        String[] substitute = Arrays.stream(strs)
                .map(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })
                .toArray(String[]::new);

        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<substitute.length;i++){
            if(map.containsKey(substitute[i])){
                map.get(substitute[i]).add(i);
            }else{
                map.put(substitute[i], new ArrayList<>(List.of(i)));
            }
        }

        
        List<List<String>> groups = new ArrayList<>(map.size());
        
        for(List<Integer> indexes : map.values()){
            List<String> group = new ArrayList<>();
            for(int idx: indexes){
                group.add(strs[idx]);
            }
            groups.add(group);
        }
        return groups;
    }
}