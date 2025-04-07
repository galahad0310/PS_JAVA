class Solution {
    public int solution(int n) {
        //방법의 수라... 이거 dfs아냐?
        //그러기엔 n이 너무 큰거 같은데,
        //경우의수를 나눈 나머지를 return이라.. 이거 dp에서 많이본 패턴인데
        //일단 dp느낌 나니까 점화식 한번 찾아보자
        //점화식 찾았다!! 개꿀, DP[n] = DP[n-1] + DP[n-2]
        int[] dp = new int[n+1];
        for(int i = 1; i<=n; i++){
            if(i == 1 || i == 2){
                dp[i] = i;
            }else{
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }
        }
        return dp[n];
    }
    
}