class Solution {
    public int solution(int[][] arr) {
        int n = arr.length; // n x n 행렬

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    // 대칭이 아님
                    return 0;
                }
            }
        }
        // 모든 요소가 대칭일 때
        return 1;
    }
}