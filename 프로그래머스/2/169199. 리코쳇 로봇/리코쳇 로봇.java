import java.util.*;
class Solution {
    public int solution(String[] board) {
        char[][] g = new char[board.length][board[0].length()];
        int[] s = new int[2];
        for(int i = 0; i<g.length; i++){
            for(int j = 0; j<g[0].length; j++){
                g[i][j] = board[i].charAt(j);
                if(g[i][j] == 'R'){
                    s[0] = i;
                    s[1] = j;
                }
            }
        }
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[g.length][g[0].length];
        q.add(new int[]{s[0], s[1], 0});
        v[s[0]][s[1]] = true;
        
        while(!q.isEmpty()){
            int[] c = q.poll();
            for(int i = 0; i<4; i++){
                int y = c[0];
                int x = c[1];
                while(true){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    
                    if(!(ny > -1 && ny < g.length && nx > -1 && nx < g[0].length) || g[ny][nx] == 'D'){
                        break;
                    }
                    
                    y = ny;
                    x = nx;
                }
                if(g[y][x] == 'G'){
                    return c[2] + 1;
                }
                if(!v[y][x]){
                    v[y][x] = true;
                    q.add(new int[]{y, x, c[2] + 1});
                }
            }
        }
        return -1;
    }
}