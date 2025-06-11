class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        int MOD = 1_000_000_007;
        
        //물 웅덩이는 -1로
        for(int[] puddle : puddles)
            dp[puddle[1]-1][puddle[0]-1] = -1;
        
        dp[0][0] =1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0; //물 웅덩이는 경로 없음
                    continue;
                }
                //위에서 내려오는 경로
                if(i != 0)
                    dp[i][j] += dp[i-1][j] % MOD;
                //왼쪽에서 오는 경로
                if(j != 0)
                    dp[i][j] += dp[i][j-1] % MOD;
            }
        }
        return dp[n - 1][m - 1] % MOD;
    }
}
