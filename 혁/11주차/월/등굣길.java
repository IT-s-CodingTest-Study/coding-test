package 월;

public class 등굣길 {

    private static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        // 침수 지역 표시
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1;
        }

        dp[1][1] = 1; // 시작 지점

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (dp[y][x] == -1) {
                    dp[y][x] = 0; // 침수 지역은 경로 없음
                    continue;
                }
                if (x > 1) dp[y][x] = (dp[y][x] + dp[y][x - 1]) % MOD;
                if (y > 1) dp[y][x] = (dp[y][x] + dp[y - 1][x]) % MOD;
            }
        }

        return dp[n][m];
    }

}
