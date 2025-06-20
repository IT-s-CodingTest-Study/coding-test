import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        int count = 0;
        int cam = Integer.MIN_VALUE;

        // 끝나는 곳 기준 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        // 차 한대씩 보기
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            // 현재 차가 안찍힌 경우
            if (start > cam) {
                count++; // 카메라 설치
                cam = end; // 이 차의 끝에 설치
            }
        }

        return count;
    }
}
