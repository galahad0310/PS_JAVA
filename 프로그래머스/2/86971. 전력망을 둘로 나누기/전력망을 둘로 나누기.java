import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] wire : wires){
            int s = wire[0] - 1;
            int e = wire[1] - 1;
            
            graph[s].add(e);
            graph[e].add(s);
        }
        int answer = 111;
        for(int[] wire : wires){
            int s = wire[0] - 1;
            int e = wire[1] - 1;
            graph[s].remove(Integer.valueOf(e));
            graph[e].remove(Integer.valueOf(s));
            
            int cnt = dfs(graph, s, new boolean[n]);
            answer = Math.min(answer, Math.abs((n - cnt) - cnt));
            
            graph[s].add(e);
            graph[e].add(s);
        }
        return answer;
    }
    
    public int dfs(List<Integer>[] graph, int start, boolean[] visited){
        int cnt = 1;
        visited[start] = true;
        for(int i : graph[start]){
            if(!visited[i]){
                visited[i] = true;
                cnt += dfs(graph, i, visited);
            }
        }
        
        return cnt;
    }
    
}