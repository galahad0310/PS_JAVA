import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int currentSoldiers = n;
        int tickets = k;
        int round = 0;
        for(int i = 0; i<enemy.length; i++){
            int currentEnemy = enemy[i];
            pq.add(currentEnemy);
            currentSoldiers -= currentEnemy;
            if(currentSoldiers < 0){
                if(tickets > 0 && !pq.isEmpty()){
                    currentSoldiers += pq.poll();
                    tickets--;
                }else{
                    break;
                }
            }
            round++;
        }
        return round;
    }
}