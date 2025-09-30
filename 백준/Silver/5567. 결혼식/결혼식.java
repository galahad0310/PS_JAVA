import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[n+1];
        for(int i = 1; i<adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n+1];
        dfs(adj, visited, 1, 0);
        int answer = 0;
        for(int i = 2; i<= n; i++){
            if(visited[i]){
                answer++;
            }
        }
        System.out.println(answer);
    }
    private static void dfs(List<Integer>[] adj, boolean[] visited, int start, int depth){
        if(depth == 2){
            return;
        }
        for(int i : adj[start]){
            visited[i] = true;
            dfs(adj, visited, i, depth + 1);
        }
    }
}