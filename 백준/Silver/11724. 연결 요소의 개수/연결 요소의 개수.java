import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjoin;
    static boolean[] visited;

    static void DFS(int node){
        if(visited[node]){
            return;
        }
        visited[node] = true;

        for(int adjoinNode : adjoin[node]){
            if(!visited[adjoinNode]){
                DFS(adjoinNode);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjoin = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i<N+1; i++){
            adjoin[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjoin[v].add(u);
            adjoin[u].add(v);
        }
        int result = 0;
        for(int i = 1; i<N+1; i++){
            if(!visited[i]){
                result++;
                DFS(i);
            }
        }
        System.out.println(result);
    }
}