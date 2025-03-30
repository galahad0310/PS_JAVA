import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.length() % 2 == 1) return answer;
        
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<s.length(); i++){
            if(isCorrect(sb.toString())) answer++;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return answer;
    }
    
    boolean isCorrect(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || c == '(' || c == '[' || c =='{'){
                stack.addFirst(c);
                continue;
            }
            
            if(check(stack.peekFirst(), c)){
                stack.removeFirst();
            }
        }
        
        return stack.isEmpty();
    }
    
    boolean check(char left, char right){
       return (left == '(' && right == ')') || (left == '[' && right ==']') || (left == '{' && right =='}');
    }
    
}