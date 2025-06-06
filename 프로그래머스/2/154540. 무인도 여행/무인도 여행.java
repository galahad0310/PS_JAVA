import java.util.*;
class Solution {
    boolean[][] visited;
    int[] dy = new int[]{-1, 1, 0, 0};
    int[] dx = new int[]{0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        char[][] graph = new char[maps.length][maps[0].length()];
        visited = new boolean[graph.length][graph[0].length];
        int idx = 0;
        for(String s : maps){
            graph[idx++] = s.toCharArray();
        }
        
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                if(graph[i][j] != 'X' && !visited[i][j]){
                    int element = bfs(graph, new int[]{i, j});
                    list.add(element);
                }
            }
        }
        Collections.sort(list);
        if(list.size() == 0) return new int[]{-1};
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public int bfs(char[][] graph, int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        int sum = graph[start[0]][start[1]] - '0';
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i = 0; i<4; i++){
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                if(ny > -1 && ny < graph.length && nx > -1 &&  nx < graph[0].length){
                    if(graph[ny][nx] != 'X' && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        sum += graph[ny][nx] - '0';
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
        
        return sum;
    }
}