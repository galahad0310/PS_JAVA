import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    public int solution(String dirs) {
        int[][] graph = new int[11][11];
        int[] curr = new int[]{5, 5};
        
        Map<Character, int[]> d = new HashMap<>();
        d.put('U', new int[]{-1, 0});
        d.put('D', new int[]{1, 0});
        d.put('R', new int[]{0, 1});
        d.put('L', new int[]{0, -1});
        int answer = 0;
        for(char c : dirs.toCharArray()){
            int ny = d.get(c)[0] + curr[0];
            int nx = d.get(c)[1] + curr[1];
            if(ny > -1 && ny < 11 && nx > -1 && nx < 11){
                if(validate(curr[0], curr[1], ny, nx)){
                    answer++;
                }
                curr[0] = ny;
                curr[1] = nx;
            }
        }
        return answer;
    }
    boolean validate(int y, int x, int ny, int nx){
        String convert1 = x+","+y+"->"+nx+","+ny;
        String convert2 = nx+","+ny+"->"+x+","+y;
        if(!set.contains(convert1) && !set.contains(convert2)){
            set.add(convert1);
            set.add(convert2);
            return true;
        }
        return false;
    }
}