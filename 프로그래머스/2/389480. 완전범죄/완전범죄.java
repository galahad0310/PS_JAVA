//greedy x bruteforce o -> 입력값도 작고 greedy로 하기엔 논리적 허점이 많음
class Solution {
    int n, m;
    int[][] info;
    int minA = Integer.MAX_VALUE;
    int[][][] dp;
    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        this.info = info;
        this.dp = new int[info.length + 1][n][m];
        for(int i = 0; i<=info.length; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        
        dfs(0, 0, 0);
        return minA == Integer.MAX_VALUE ? -1 : minA;
    }
    
    void dfs(int depth, int a, int b){
        if(dp[depth][a][b] == 1) return;
        dp[depth][a][b] = 1;
        if(depth == info.length){
            minA = Math.min(minA, a);
            return;
        }
        
        if(a + info[depth][0] < n){
            dfs(depth + 1, a + info[depth][0], b);
        }
        
        if(b + info[depth][1] < m){
            dfs(depth + 1, a, b + info[depth][1]);
        }
    }
}