import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static class Node{
        int y, x, distance, broken;
        Node(int y, int x, int distance, int broken){
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.broken = broken;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] graph = new int[n][m];

        for(int i = 0; i<n; i++){
            String row = br.readLine();
            for(int j = 0; j<m; j++){
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(bfs(graph, n, m));
    }
    static int bfs(int[][] graph, int n, int m){
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.y == n-1 && curr.x == m-1){
                return curr.distance;
            }
            for(int k = 0; k<4; k++){
                int ny = curr.y + dy[k];
                int nx = curr.x + dx[k];
                if(ny > -1 && ny < n && nx > -1 && nx < m && !visited[ny][nx][curr.broken]){
                    if(graph[ny][nx] == 0){
                        q.add(new Node(ny, nx, curr.distance+1, curr.broken));
                        visited[ny][nx][curr.broken] = true;
                    }
                    if(graph[ny][nx] == 1 && curr.broken == 0){
                        q.add(new Node(ny, nx, curr.distance + 1, 1));
                        visited[ny][nx][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}