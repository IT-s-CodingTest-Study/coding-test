package 수;

public class 사칙연산 {
    int[][] maxDP, minDP;
    String[] arr;

    public int solution(String[] arr) {
        this.arr = arr;
        int n = (arr.length + 1) / 2;
        maxDP = new int[n][n];
        minDP = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxDP[i][i] = minDP[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    char op = arr[k * 2 + 1].charAt(0);
                    int[] l = {maxDP[i][k], minDP[i][k]};
                    int[] r = {maxDP[k + 1][j], minDP[k + 1][j]};
                    for (int a : l)
                        for (int b : r) {
                            int val = (op == '+') ? a + b : a - b;
                            maxDP[i][j] = Math.max(maxDP[i][j], val);
                            minDP[i][j] = Math.min(minDP[i][j], val);
                        }
                }
            }
        }

        return maxDP[0][n - 1];
    }
}
