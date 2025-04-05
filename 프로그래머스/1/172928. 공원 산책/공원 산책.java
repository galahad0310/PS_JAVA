import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<String, int[]> map = new HashMap<>();
        map.put("N", new int[]{-1, 0});
        map.put("S", new int[]{1, 0});
        map.put("W", new int[]{0, -1});
        map.put("E", new int[]{0, 1});
        
        char[][] graph = new char[park.length][park[0].length()];
        int[] curr = new int[2];
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                graph[i][j] = park[i].charAt(j);
                if(graph[i][j] == 'S'){
                    curr[0] = i;
                    curr[1] = j;
                }
            }
        }
        
        for(String s : routes){
            String[] cmd = s.split(" ");
            boolean move = true;
            int ny = curr[0];
            int nx = curr[1];
            
            
            for(int i = 0; i<Integer.parseInt(cmd[1]); i++){
                ny += map.get(cmd[0])[0];
                nx += map.get(cmd[0])[1];
                
                if(ny > -1 && ny < graph.length && nx > -1 && nx < graph[0].length){
                    if(graph[ny][nx] == 'X'){
                        move = false;
                        
                        break;
                    }
                }else{
                    move = false;
                    break;
                }
            }
            
            if(move){
                curr[0] = ny;
                curr[1] = nx;
            }
        }
        return curr;
    }
}