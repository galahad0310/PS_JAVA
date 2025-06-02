import java.util.*;
class Solution {
    
    class Node implements Comparable<Node>{
        int to;
        int cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i<=N; i++) graph.add(new ArrayList<>());
        
        for(int[] r : road){
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            for(Node next : graph.get(curr.to)){
                int newDist = dist[curr.to] + next.cost;
                if(dist[next.to] > newDist){
                    dist[next.to] = newDist;
                    pq.offer(new Node(next.to, newDist));
                }
            }
        }
        
        int cnt = 0;
        for(int i = 1; i<=N; i++){
            if(dist[i] <= K) cnt++;
        }
        return cnt;
    }
}