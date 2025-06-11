class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2; // 숫자 개수
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];


        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(arr[i * 2]);
            maxDp[i][i] = val;
            minDp[i][i] = val;
        }

    
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];
                    int[] candidates = calc(
                        maxDp[i][k], minDp[i][k],
                        maxDp[k + 1][j], minDp[k + 1][j],
                        op
                    );
                    maxDp[i][j] = Math.max(maxDp[i][j], candidates[0]);
                    minDp[i][j] = Math.min(minDp[i][j], candidates[1]);
                }
            }
        }

        return maxDp[0][n - 1];
    }

    // 연산자를 기준으로 네 가지 조합 중 최대/최소를 계산
    private int[] calc(int aMax, int aMin, int bMax, int bMin, String op) {
        int[] res = new int[2];
        if (op.equals("+")) {
            res[0] = Math.max(aMax + bMax, aMin + bMin); // 최대값
            res[1] = Math.min(aMax + bMax, aMin + bMin); // 최소값
        } else { 
            res[0] = Math.max(aMax - bMin, aMin - bMax);
            res[1] = Math.min(aMax - bMin, aMin - bMax);
        }
        return res;
    }
}
