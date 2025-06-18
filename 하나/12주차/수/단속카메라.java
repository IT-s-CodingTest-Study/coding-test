import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 진출 지점 기준 정렬
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            if (route[0] > camera) { // 카메라가 커버 못 하면 새로 설치
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}
