import java.awt.desktop.AboutEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int answer = 0;
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
        dfs(adj, new boolean[n+1], 1);
        System.out.println(--answer); // 1제외
    }

    private static void dfs(List<Integer>[] adj, boolean[] visited, int start){
        visited[start] = true;
        answer++;
        for(int i : adj[start]) {
            if (!visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }
}