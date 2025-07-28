import java.util.*;
class Solution {
    public String solution(String p) {
        if(p.isEmpty()) return "";
        
        int left = 0;
        int right = 0;
        
        for(char c : p.toCharArray()){
            if(c == '(') left++;
            else right ++;
            if(left == right) break;
        }
        
        String u = p.substring(0, left+right);
        String v = p.substring(left+right);
        
        if(check(u)){
            return u + solution(v);
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            for(int i = 1; i<u.length() - 1; i++){
                if(u.charAt(i) == '('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }
            return sb.toString();
        }
    }
    
    public boolean check(String s){
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                deque.push(c);
            }else{
                if(deque.isEmpty()) return false;
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}