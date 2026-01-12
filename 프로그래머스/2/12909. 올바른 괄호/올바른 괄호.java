import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> d = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(d.isEmpty()){
                if(c ==')') return false;
                d.push(c);
                continue;
            }
            
            if(c == '('){
                d.push(c);
                continue;
            }
            
            if(c == ')' && !d.isEmpty()){
                d.pop();
            }else{
                return false;
            }
        }
        return d.isEmpty();
    }
}