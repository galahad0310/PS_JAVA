import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        
        for(int i = 0; i<players.length; i++){
            //만료된 서버 반납
            while(!q.isEmpty() && q.peek() <= i){
                q.poll();
            }
            
            int needed = players[i] / m; //필요한 서버수 계산
            
            //현재 서버수가 필요한 서버수보다 적다면 서버 증설
            if(q.size() < needed){
                //warning!: 다음 for문에서 q를 조작하기 때문에, 
                //q의 변수값을 for 조건문속에 넣으면 의도와 다르게 돌아감, 
                //그러므로 미리 값을 밖에서 정의해서 add라는 변수에 담음
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