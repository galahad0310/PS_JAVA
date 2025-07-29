class Solution{
    public int solution(int[][] board){
        int[][] dp = new int[board.length][board[0].length];
        int maxSide = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(i == 0 || j == 0) dp[i][j] = board[i][j];
                else{
                    if(board[i][j] == 1){
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    }
                }
                if(maxSide < dp[i][j]) maxSide = dp[i][j];
            }
        }
        return maxSide * maxSide;
    }
}