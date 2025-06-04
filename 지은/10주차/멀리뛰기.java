class Solution {
    public long solution(int n) {

        // dp[2] 접근위해 넉넉히 배열 생성
        long[] dp = new long[n + 2];

        // 초기 값
        dp[1] = 1; // 1 칸일 때 경우의 수 : 1개
        dp[2] = 2; // 2 칸일 때 경우의 수 : 2개 (1,1), (2)

        // 점화식
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
