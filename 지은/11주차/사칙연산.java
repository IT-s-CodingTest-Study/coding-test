class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;

        int[][] maxDp = new int[n][n], minDp = new int[n][n];

        // 숫자 하나만 있는 구간
        for (int i = 0; i < n; i++) {
            maxDp[i][i] = minDp[i][i] = Integer.parseInt(arr[i * 2]);
        }

        // 길이 2 이상 구간 계산
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // 초기 최댓값, 최솟값 설정
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                // i~j 사이의 연산자 위치를 기준으로 구간 나누기
                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];

                    // 가능한 네 가지 조합 계산
                    int[] vals = {
                            calc(maxDp[i][k], maxDp[k + 1][j], op),
                            calc(maxDp[i][k], minDp[k + 1][j], op),
                            calc(minDp[i][k], maxDp[k + 1][j], op),
                            calc(minDp[i][k], minDp[k + 1][j], op)
                    };

                    // 최댓값, 최솟값 갱신
                    for (int v : vals) {
                        maxDp[i][j] = Math.max(maxDp[i][j], v);
                        minDp[i][j] = Math.min(minDp[i][j], v);
                    }
                }
            }
        }

        // 최댓값 반환
        return maxDp[0][n - 1];
    }

    // 연산자에 따라 계산
    int calc(int a, int b, String op) {
        return op.equals("+") ? a + b : a - b;
    }
}
