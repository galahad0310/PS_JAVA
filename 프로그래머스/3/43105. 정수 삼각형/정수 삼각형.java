import java.util.*;
class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][];
        for(int i = 0; i<dp.length; i++){
            dp[i] = new int[triangle[i].length];
            Arrays.fill(dp[i], -1);
        }
        return dfs(triangle, 0, 0);
    }
    
    public int dfs(int[][] triangle, int row, int col){
        if(row == triangle.length - 1){
            return triangle[row][col];
        }
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int left = dfs(triangle, row+1, col);
        int right = dfs(triangle, row+1, col+1);
        
        return dp[row][col] = triangle[row][col] + Math.max(left, right);
    }
}