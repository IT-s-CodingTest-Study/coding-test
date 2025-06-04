public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        // 2번째 줄부터 내려간다
        // 내 위에 왼쪽 or 오른쪽에 큰 값을 나한테 더해주면 최대값
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) triangle[i][j] += triangle[i - 1][j];    // 왼쪽 끝
                else if(j == triangle[i].length - 1) triangle[i][j] += triangle[i - 1][j - 1]; // 오른쪽 끝
                else triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i -1][j]);

                answer = Math.max(answer, triangle[i][j]);
            }
        }

        return answer;
    }
}
