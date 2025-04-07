import java.util.*;
class Solution {
    boolean[] visited = new boolean[3000001];
    class Node{
        int x, time;
        Node(int x, int time){
            this.x=x;
            this.time=time;
        }
    }
    public int solution(int x, int y, int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, 0));
        visited[x] = true;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.x == y){
                return curr.time;
            }
            int next = curr.x*2;
            if(!visited[next] && next <= y){
                q.add(new Node(next, curr.time+1));
                visited[next] = true;
            }
            next = curr.x*3;
            if(!visited[next] && next <= y){
                q.add(new Node(next, curr.time+1));
                visited[next] = true;
            }
            next = curr.x+n;
            if(!visited[next] && next <= y){
                q.add(new Node(next, curr.time+1));
                visited[next] = true;
            }
        }
        return -1;
    }
}