import java.util.*;

class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시간 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 작업시간 기준

        int time = 0, jobIndex = 0, count = 0;

        while (count < jobs.length) {
            // 현재 시간 이하인 모든 작업 큐에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }

            if (!pq.isEmpty()) {
                int[] current = pq.poll();
                time += current[1]; // 작업 끝나는 시간
                answer += time - current[0]; // 요청부터 종료까지 시간
                count++;
            } else {
                time = jobs[jobIndex][0]; // 다음 요청까지 점프
            }
        }

        return answer / jobs.length; // 평균 반환 시간
    }
}
