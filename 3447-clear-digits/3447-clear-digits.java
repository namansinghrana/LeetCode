import java.util.*;

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack();

        for(int i=0;i<s.length();i++){
            if( Character.isAlphabetic(s.charAt(i))){ stack.push(s.charAt(i)); }
            if( Character.isDigit(s.charAt(i))){ stack.pop(); }
        }
        StringBuilder sb = new StringBuilder();
        
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
            sb.append(stack.pop());
            }
        }
        return (!stack.isEmpty()) ? sb.toString() : sb.reverse().toString() ;
    }
}