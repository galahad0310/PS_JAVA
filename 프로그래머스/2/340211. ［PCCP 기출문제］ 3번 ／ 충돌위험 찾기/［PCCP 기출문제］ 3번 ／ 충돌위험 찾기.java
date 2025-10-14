import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<int[]>[] list = new ArrayList[routes.length];
        int maxTime = 0;
        for(int i = 0; i<routes.length; i++){
            List<int[]> path = new ArrayList<>();
            path.add(points[routes[i][0] - 1]);
            
            for(int j = 0; j<routes[i].length - 1; j++){
                int[] curr = points[routes[i][j] - 1];
                int[] next = points[routes[i][j + 1] - 1];
                
                int r = curr[0], c = curr[1];
                
                while(r != next[0]){
                    r += (r < next[0]) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
                
                while(c != next[1]){
                    c += (c < next[1]) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
            }
            list[i] = path;
            maxTime = Math.max(maxTime, path.size());
        }
        
        int result = 0;
        for(int t = 0; t<maxTime; t++){
            Map<String, Integer> map = new HashMap<>();
            for(List<int[]> path : list){
                if(t < path.size()){
                    int[] pos = path.get(t);
                    String key = pos[0]+","+pos[1];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            for(int i : map.values()){
                if(i > 1) result++;
            }
        }
        
        return result;
    }
}