public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;

        int[][] street = new int[n][m];

        // 웅덩이는 -1로 표시
        for (int[] puddle : puddles) {
            int y = puddle[1] - 1;
            int x = puddle[0] - 1;
            street[y][x] = -1;
        }

        // 시작 지점 초기화
        street[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 웅덩이면 0으로 초기화하고 건너뛰기
                if (street[i][j] == -1) {
                    street[i][j] = 0;
                    continue;
                }

                // 위에서 오는 경로
                if (i > 0)
                    street[i][j] = (street[i][j] + street[i - 1][j]) % MOD;

                // 왼쪽에서 오는 경로
                if (j > 0)
                    street[i][j] = (street[i][j] + street[i][j - 1]) % MOD;
            }
        }

        return street[n - 1][m - 1];
    }
}
