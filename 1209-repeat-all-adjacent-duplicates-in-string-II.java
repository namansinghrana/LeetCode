//Optimized yet not fully optimized solution
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().getKey() == c){
                int count = stack.peek().getValue()+1;
                stack.pop();
                if(count < k){ stack.push(new Pair<>(c, count)); }
            }else{ stack.push(new Pair<>(c, 1)); }
        }

        StringBuilder sb = new StringBuilder();
        for(Pair<Character, Integer> c : stack){
            sb.append(String.valueOf(c.getKey()).repeat(c.getValue()));
        }
        return sb.toString();
    }
}

//Fully Optimized - 

