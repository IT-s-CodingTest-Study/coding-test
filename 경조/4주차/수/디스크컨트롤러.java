import java.util.*;
public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 작업이 요청되는 시점 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // [작업이 요청되는 시점, 작업 소요 시간] 형태로 저장, 작업 소요 시간 순으로 정렬
        PriorityQueue<int[]> waiting = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int time = 0;           // 현재 시간
        int jobIdx = 0;         // jobs 배열 조회할 행 index
        int count = 0;          // 작업 갯수
        while(count < jobs.length) {
            // jobIdx가 jobs 배열의 행의 길이보다 작고 작업의 요청되는 시점의 값이 현재 시간보다 작거나 같을 때
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= time) {
                waiting.offer(jobs[jobIdx++]);      // 대기 큐에 추가
            }
            if(!waiting.isEmpty()) {
                int[] job = waiting.poll();
                time += job[1];             // 소요 시간만큼 현재 시간에 추가
                answer += time - job[0];    // answer에 작업 시간 추가
                count++;
            } else {
                time++;
            }
        }

        return answer / jobs.length;        // 평균을 리턴해야하므로 작업 갯수만큼 나눠서 리턴
    }
}
