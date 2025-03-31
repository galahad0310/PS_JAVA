import java.util.*;
class Solution {
    static int[] selected;
    static int max = 0;
    static int[][] d;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        int n = dungeons.length;
        visited = new boolean[n];
        selected = new int[n];
    
        dfs(0, k);
        
        return max;
    }
    
    public void dfs(int d, int k){
        if(d == selected.length){
            cal(selected, k);
            return;
        }
        for(int i = 0; i<selected.length; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[d] = i;
                dfs(d+1, k);
                visited[i] = false;
            }
            
        }
    }
    
    public void cal(int[] selected, int k){
        int total = 0;
        for(int idx : selected){
            int[] dungeon = d[idx];
            if(k >= dungeon[0]){
                k-=dungeon[1];
                total++;
            }else{
                break;
            }
        }
        max = Math.max(total, max);
    }
}