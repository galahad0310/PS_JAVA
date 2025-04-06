import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int pointer = 0;
        int answer = 0;
        for(int i = 1; i<=order.length; i++){
            if(order[pointer] == i){
                answer++;
                pointer++;
            }else if(!stack.isEmpty() && stack.peek().equals(order[pointer])){
                answer++;
                pointer++;
                stack.pop();
                i--;
            }else{
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek().equals(order[pointer])){
                pointer++;
                stack.pop();
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}