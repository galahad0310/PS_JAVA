import java.util.*;
class Solution {
    public int solution(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] col = new int[land[0].length];
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        for(int i = 0; i<land.length; i++){
            for(int j = 0; j<land[0].length; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    visited[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    Set<Integer> shared = new HashSet<>();
                    int cnt = 0;
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        shared.add(curr[1]);
                        cnt++;
                        for(int t = 0; t<4; t++){
                            int ny = curr[0] + dy[t];
                            int nx = curr[1] + dx[t];
                            
                            if(ny > -1 && ny < land.length && nx > -1 && nx < land[0].length
                              && land[ny][nx] == 1 && !visited[ny][nx]){
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    for(int s : shared){
                        col[s] += cnt;
                    }
                }
            }
        }
        int r = 0;
        for(int i : col){
            r = Math.max(r, i);   
        }
        return r;
    }
}