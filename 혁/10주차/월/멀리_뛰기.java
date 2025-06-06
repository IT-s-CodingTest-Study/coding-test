package 월;

public class 멀리_뛰기 {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
