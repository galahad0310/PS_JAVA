import java.util.*;
class Solution {
    boolean[] visited = new boolean[3000001];
    class Node{
        int x, cnt;
        Node(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
    public int solution(int x, int y, int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, 0));
        visited[x] = true;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.x == y){
                return curr.cnt;
            }
            for(int next : new int[]{curr.x * 2, curr.x*3, curr.x+n}){
                if(next<=y && !visited[next]){
                    q.add(new Node(next, curr.cnt+1));
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}