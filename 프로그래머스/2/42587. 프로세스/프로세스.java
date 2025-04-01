import java.util.*;
class Solution {
    class Node{
        int idx;
        int value;
        Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i<priorities.length; i++){
            q.add(new Node(i, priorities[i]));
        }
        
        Arrays.sort(priorities);
        int pointer = priorities.length - 1;
        int cnt = 0;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.value == priorities[pointer]){
                cnt++;
                if(curr.idx == location){
                    return cnt;
                }
                pointer--;
            }else{
                q.add(curr);    
            }
        }
        return -1;
    }
}