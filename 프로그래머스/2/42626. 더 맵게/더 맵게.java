import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1-o2);
        for(int i : scoville){
            pq.add(i);
        }
        int answer = 0;
        while(pq.peek() < K && pq.size() >= 2){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + (b * 2));
            answer++;
        }
        if(pq.size() <= 1){
            if(pq.peek() >= K){
                return answer;
            }else{
                return -1;
            }
        }else{
            return answer;
        }
    }
}