import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static List<Integer> dfs_result = new ArrayList<>();
    static List<Integer> bfs_result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new ArrayList[N + 1];
        for(int i = 1; i<adj.length; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i = 1; i<=N; i++){
            Collections.sort(adj[i]);
        }

        dfs(V, adj, new boolean[N + 1]);
        bfs(V, adj, new boolean[N + 1]);

        StringBuilder sb = new StringBuilder();
        for(int i : dfs_result){
            sb.append(i).append(" ");
        }

        sb.append("\n");

        for(int i : bfs_result){
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int start, List<Integer>[] adj, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        bfs_result.add(start);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : adj[curr]){
                if(!visited[i]){
                    q.add(i);
                    bfs_result.add(i);
                    visited[i] = true;
                }
            }


        }
    }

    private static void dfs(int start, List<Integer>[] adj, boolean[] visited){
        visited[start] = true;
        dfs_result.add(start);
        for(int i : adj[start]){
            if(!visited[i]){
                dfs(i, adj, visited);
            }
        }
    }
}