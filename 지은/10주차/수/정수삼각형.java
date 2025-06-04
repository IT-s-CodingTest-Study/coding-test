class Solution {
    public int solution(int[][] triangle) {
        // 아래 줄부터 위로 올라가며 DP 진행
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0]; // 꼭대기에 최대 합이 저장
    }
}
