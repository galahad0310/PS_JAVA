import java.util.*;
class Solution {
    class Node{
        int p, idx;
        Node(int p, int idx){
            this.p = p;
            this.idx = idx;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Node> stack = new ArrayDeque<>();
        
        for(int i = 0; i<prices.length; i++){
            if(stack.isEmpty()){
                stack.addFirst(new Node(prices[i], i));
            }
            while(!stack.isEmpty() && stack.peekFirst().p > prices[i]){
                Node curr = stack.removeFirst();
                answer[curr.idx] = i - curr.idx;
            }
            stack.addFirst(new Node(prices[i], i));
        }
        
        while(!stack.isEmpty()){
            Node curr = stack.removeFirst();
            answer[curr.idx] = prices.length - 1 - curr.idx;
        }
        return answer;
    }
}