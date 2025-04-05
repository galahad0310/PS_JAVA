import java.util.*;
class Solution {
    Stack<Integer> stack = new Stack<>();
    public int solution(int[] ingredient) {
        int answer = 0;
        for(int i = 0; i<ingredient.length; i++){
            stack.push(ingredient[i]);
            if(stack.size() >=4 && validate(stack)){
                answer++;
                remove(stack);
            }
        }
        return answer;
    }
    
    void remove(Stack<Integer> stack){
        for(int i = 0; i<4; i++){
            stack.pop();
        }
    }
    
    boolean validate(Stack<Integer> stack){
        if(
            stack.get(stack.size() - 1) == 1 &&
            stack.get(stack.size() - 2) == 3 &&
            stack.get(stack.size() - 3) == 2 &&
            stack.get(stack.size() - 4) == 1
        ){
            return true;
        }
        return false;
    }
}