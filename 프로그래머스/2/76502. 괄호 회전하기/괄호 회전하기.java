import java.util.*;
class Solution {
    public int solution(String s) {
        int cnt = 0;
        char[] arr = s.toCharArray();
        
        for(int i = 0; i<s.length(); i++){
            
            if(i > 0){
                char first = arr[0];
                for(int j = 0; j<arr.length - 1; j++){
                    arr[j] = arr[j+1];
                }
                arr[arr.length - 1] = first;
            }
            
            

            Deque<Character> stack = new ArrayDeque<>();
            for(int j = 0; j<arr.length; j++){
                if(stack.isEmpty()){
                    stack.addLast(arr[j]);
                }else{
                    if(arr[j] == ']'){
                        if(stack.peekLast() == '['){
                            stack.removeLast();
                        }else{
                            break;
                        }
                    }else if(arr[j] == ')'){
                        if(stack.peekLast() == '('){
                            stack.removeLast();
                        }else{
                            break;
                        }
                    }else if(arr[j] == '}'){
                        if(stack.peekLast() == '{'){
                            stack.removeLast();
                        }else{
                            break;
                        }
                    }else{
                        stack.addLast(arr[j]);
                    }
                }
            }
            if(stack.isEmpty()){
               cnt++; 
            }
        }
        return cnt;
    }
}