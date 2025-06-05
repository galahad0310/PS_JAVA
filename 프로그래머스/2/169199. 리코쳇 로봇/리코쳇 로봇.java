import java.util.*;
class Solution {
    public int solution(String[] board) {
        
        //init: graph, start
        char[][] graph = new char[board.length][board[0].length()];
        int[] start = new int[2];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length(); j++){
                graph[i][j] = board[i].charAt(j);
                if(graph[i][j] == 'R'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        //bfs
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        
        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();            
            for(int i = 0; i<4; i++){
                int y = curr[0], x = curr[1];
                while(true){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(validate(ny, nx, graph)) break;
                    y = ny;
                    x = nx;
                }
                if(graph[y][x] == 'G'){
                    return curr[2] + 1;
                }
                if(!visited[y][x]){
                    q.offer(new int[]{y, x, curr[2] + 1});
                    visited[y][x] = true;
                }
            }
        }
        return -1;
    }
    
    private boolean validate(int ny, int nx, char[][] graph){
        return !(ny > -1 && ny < graph.length && nx > -1 && nx < graph[0].length) || graph[ny][nx] == 'D';
    }
}