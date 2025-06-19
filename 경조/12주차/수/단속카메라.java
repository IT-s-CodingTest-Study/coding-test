import java.util.*;
public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        // 도착 지점 순으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int camera = Integer.MIN_VALUE;

        for(int[] route : routes) {
            // 진입 시점보다 카메라가 작으면 단속 x
            if(camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
