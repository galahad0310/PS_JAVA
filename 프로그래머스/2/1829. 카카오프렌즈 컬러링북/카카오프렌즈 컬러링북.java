import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int area = 0;
                    
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        area++;
                        for(int k = 0; k<4; k++){
                            int ny = curr[0] + dy[k];
                            int nx = curr[1] + dx[k];
                            if(ny > -1 && ny < m && nx > -1 && nx < n && !visited[ny][nx] && picture[ny][nx] == picture[i][j]){     
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}