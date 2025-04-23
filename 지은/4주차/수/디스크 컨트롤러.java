import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int totalTime = 0;

        // 요청 시간 기준 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 소요 시간 기준 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int currentTime = 0; // 현재 시간
        int jobIndex = 0; // jobs 배열 탐색 인덱스
        int completedJobs = 0; // 완료된 작업 수

        while (completedJobs < jobs.length) {
            // 현재 시간까지 들어온 작업을 큐에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                pq.add(jobs[jobIndex++]);
            }

            if (pq.isEmpty()) {
                // 처리할 작업이 없으면, 다음 작업의 요청 시간으로 이동
                currentTime = jobs[jobIndex][0];
            } else {
                int[] currentJob = pq.poll();
                currentTime += currentJob[1]; // 작업 수행
                totalTime += currentTime - currentJob[0]; // 대기 시간 포함 총 시간 누적
                completedJobs++;
            }
        }

        return totalTime / jobs.length; // 평균 대기 시간 리턴
    }
}
