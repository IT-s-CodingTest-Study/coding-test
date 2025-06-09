public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        // 문제가 열, 행 순이므로 n, m으로 변경
        int[][] dp = new int[n][m];
        int mod = 1000000007;
        // 물
        for(int[] p : puddles) {
            dp[p[1] - 1][p[0] - 1] = -1;
        }
        
        // 시작점
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) continue;
                
                // 위쪽 확인
                if (i > 0 && dp[i - 1][j] != -1)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                // 왼쪽 확인
                if (j > 0 && dp[i][j - 1] != -1)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}