import java.util.*;
class Solution {
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};
    public int solution(String[] maps) {
        char[][] graph = new char[maps.length][maps[0].length()];
        int idx = 0;
        int[] start = null;
        int[] lever = null;
        int[] end = null;
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new int[]{i, j};
                }
                if(maps[i].charAt(j) == 'L'){
                    lever = new int[]{i, j};
                }
                if(maps[i].charAt(j) == 'E'){
                    end = new int[]{i, j};
                }
                graph[i][j] = maps[i].charAt(j);
            }
        }
        int a = bfs(graph, start, lever);
        if(a==-1) return -1;
        int b = bfs(graph, lever, end);
        if(b==-1) return -1;
        return a+b;
    }
    
    private int bfs(char[][] graph, int[] start, int[] end){
        if (start[0] == end[0] && start[1] == end[1]) return 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] time = new int[graph.length][graph[0].length];
        q.add(start);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i = 0; i<4; i++){
                int nx = curr[1] + dx[i];
                int ny = curr[0] + dy[i];
                if(ny > -1 && ny < graph.length && nx > -1 && nx < graph[0].length){
                    if(graph[ny][nx] != 'X' && time[ny][nx] == 0){
                        q.add(new int[]{ny, nx});
                        time[ny][nx] = time[curr[0]][curr[1]] + 1;
                        if(ny == end[0] && nx == end[1]){
                            return time[ny][nx];
                        }
                    }
                }
            }
        }
        return -1;
    }
}