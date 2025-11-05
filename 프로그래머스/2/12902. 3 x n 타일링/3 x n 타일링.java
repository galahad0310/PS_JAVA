class Solution {
    public int solution(int n) {
        // n이 홀수이면 타일링이 불가능합니다.
        if (n % 2 != 0) {
            return 0;
        }

        final int MOD = 1_000_000_007;

        // dp 배열은 long 타입으로 선언하여 중간 계산 과정에서의 오버플로우를 방지합니다.
        long[] dp = new long[n + 1];

        // 초기값 설정
        dp[0] = 1;
        if (n >= 2) {
            dp[2] = 3;
        }

        // 점화식을 이용하여 dp 배열을 채웁니다.
        for (int i = 4; i <= n; i += 2) {
            // dp[i] = 4 * dp[i-2] - dp[i-4]
            // 모듈러 연산 시 음수가 나오는 것을 방지하기 위해 MOD를 더해줍니다.
            long term1 = (4 * dp[i - 2]) % MOD;
            long term2 = dp[i - 4] % MOD;
            dp[i] = (term1 - term2 + MOD) % MOD;
        }

        return (int) dp[n];
    }
}