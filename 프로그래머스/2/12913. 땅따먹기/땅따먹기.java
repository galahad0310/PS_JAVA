import java.util.*;
class Solution {
    int solution(int[][] land) {
        //문제에서 dp냄새가 난다
        //dp[n] = Math.max(dp[n] 제외 나머지 3개)
        //dp[마지막행][0 ~ 3] 중 최댓값 리턴하면 될 거 같음
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{1, 2, 3});
        map.put(1, new int[]{0, 2, 3});
        map.put(2, new int[]{0, 1, 3});
        map.put(3, new int[]{0, 1, 2});
        int[][] dp = new int[land.length][land[0].length];
        for(int i = 1; i<land.length; i++){
            for(int j = 0; j<4; j++){
                int[] arr = map.get(j);
                int max = Math.max(land[i-1][arr[2]], Math.max(land[i-1][arr[0]], land[i-1][arr[1]]));
                land[i][j] += max;
            }
        }
        int[] arr = land[land.length - 1];
        Arrays.sort(arr);
        return arr[3];
    }
}