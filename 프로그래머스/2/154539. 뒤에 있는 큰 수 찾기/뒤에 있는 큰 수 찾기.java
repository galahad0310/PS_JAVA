import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = numbers.length - 1; i>-1; i--){
            while(!stack.isEmpty() && stack.peekFirst() <= numbers[i]){
                stack.removeFirst();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.addFirst(numbers[i]);
        }
        return answer;
    }
}