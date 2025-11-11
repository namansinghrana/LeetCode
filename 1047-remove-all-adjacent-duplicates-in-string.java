//Not Optimized but O(n) with proper stack data structure and an extra StringBuilder
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

//Now this is the optimized approach
//Remember the extra data structures may not be a problem here but make the program slower when huge inputs will be inserted. 
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){ 
            int len = sb.length();
            if(len > 0 && sb.charAt(len-1) == c){
                sb.deleteCharAt(len-1);
            }else{ sb.append(c); }
        }
        
        return sb.toString();
    }
}
