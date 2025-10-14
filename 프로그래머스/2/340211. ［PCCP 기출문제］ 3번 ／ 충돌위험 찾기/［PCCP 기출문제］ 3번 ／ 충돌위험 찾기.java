import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<Integer, int[]> pointsMap = new HashMap<>();
        for(int i = 0; i<points.length; i++){
            pointsMap.put(i+1, points[i]);    
        }
        
        List<List<int[]>> list = new ArrayList<>();
        int maxTime = 0;
        
        for(int[] route : routes){
            List<int[]> path = new ArrayList<>();
            path.add(pointsMap.get(route[0]));
            for(int i = 0; i<route.length-1; i++){
                int[] curr = pointsMap.get(route[i]);
                int[] next = pointsMap.get(route[i+1]);
                
                int r = curr[0];
                int c = curr[1];
                
                while(r != next[0]){
                    r += (r < next[0]) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
                
                while(c != next[1]){
                    c += (c < next[1]) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
            }
            list.add(path);
            maxTime = Math.max(maxTime, path.size());
        }
        int answer = 0;
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
                if(i > 1){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}