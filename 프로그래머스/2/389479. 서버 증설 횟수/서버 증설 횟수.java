import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<players.length; i++){
            while(!q.isEmpty() && q.peek() <= i){
                q.poll();
            }
            
            int needed = players[i] / m;
            if(q.size() < needed){
                int add = needed - q.size();
                for(int j = 0; j<add; j++){
                    q.add(i+k);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}