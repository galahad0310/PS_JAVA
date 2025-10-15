class Solution {
    int n, m;
    int[][] info;
    int[][][] dp; // [depth][a][b] -> 해당 상태에서 가능한 최소 A 흔적
    int minA = Integer.MAX_VALUE;

    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        this.info = info;
        
        // dp 초기화 (a와 b는 각 한계치까지)
        dp = new int[info.length + 1][n][m];
        for (int i = 0; i <= info.length; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = -1; // 아직 방문 안 함 표시
                }
            }
        }

        dfs(0, 0, 0);
        return minA == Integer.MAX_VALUE ? -1 : minA;
    }

    void dfs(int depth, int a, int b) {
        // 이미 이 상태를 방문한 적 있다면 return
        if (dp[depth][a][b] != -1) return;

        dp[depth][a][b] = 1; // 방문 표시

        if (depth == info.length) {
            minA = Math.min(minA, a);
            return;
        }

        // A가 훔칠 경우
        int nextA = a + info[depth][0];
        if (nextA < n) {
            dfs(depth + 1, nextA, b);
        }

        // B가 훔칠 경우
        int nextB = b + info[depth][1];
        if (nextB < m) {
            dfs(depth + 1, a, nextB);
        }
    }
}
