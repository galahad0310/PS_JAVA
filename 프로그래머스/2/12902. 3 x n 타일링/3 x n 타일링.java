class Solution {
    public int solution(int n) {
        if(n % 2 != 0) return 0;
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        if(n >= 2) dp[2] = 3;
        int mod = 1_000_000_007;
        
        for(int i = 4; i<=n; i+=2){
            long term1 = 4 * dp[i-2];
            long term2 = dp[i-4];
            dp[i] = (term1 - term2 + mod) % mod;
        }
        
        return (int)dp[n];
    }
}