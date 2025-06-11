import java.util.*;
class Solution {
    boolean solution(String s) {
        Deque<Character> d = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(!d.isEmpty()){
                    if(d.getLast() == '('){
                        d.removeLast();                        
                    }else{
                        d.addLast(c);
                    }
                }else{
                    return false;
                }
            }else{
                d.addLast(c);
            }
        }
        return d.isEmpty();
    }
}