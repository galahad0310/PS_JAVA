import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[] col = new int[m];
        boolean[][] visited = new boolean[n][m];
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        //250000 * 250000
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    int cnt = 0;
                    Queue<int[]> q = new LinkedList<>();
                    Set<Integer> shared = new HashSet<>(); //이게 핵심
                    
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        cnt++;
                        shared.add(curr[1]);
                        
                        for(int d = 0; d<4; d++){
                            int ny = curr[0] + dy[d];
                            int nx = curr[1] + dx[d];
                            if(ny > -1 && ny < n && nx > -1 && nx < m
                              && land[ny][nx] == 1 && !visited[ny][nx]){
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    for(int c : shared){
                        col[c] += cnt;
                    }
                }
            }
        }
        return Arrays.stream(col).max().getAsInt();   
    }
}