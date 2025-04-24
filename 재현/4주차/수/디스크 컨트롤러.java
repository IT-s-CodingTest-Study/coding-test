import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // Job 객체 배열로 변환
        Job[] jobList = new Job[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jobList[i] = new Job(jobs[i][0], jobs[i][1]);
        }
        
        // 요청시간 순으로 jobList 정렬
        Arrays.sort(jobList, (a, b) -> a.요청시간 - b.요청시간);
        
        // 소요시간 순으로 우선순위 큐 설정
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> j1.소요시간 - j2.소요시간);
        
        int time = 0;           // 현재 시간
        int idx = 0;            // 처리할 작업의 인덱스
        int completionJob = 0;  // 완료된 작업 수
        int totalTime = 0;      // 총 처리 시간
        
        while (completionJob < jobs.length) {
            
            // 현재시간보다 요청시간이 빠른 작업들을 pq에 삽입
            while (idx < jobs.length && jobList[idx].요청시간 <= time) {
                pq.add(jobList[idx]);
                idx++;
            }

            // 가장 우선순위가 높은 job 실행
            if (!pq.isEmpty()) {
                Job now = pq.poll();
                time += now.소요시간;
                totalTime += time - now.요청시간;
                completionJob++;
            } else {
                time = jobList[idx].요청시간;
            }
        }
        
        
        // 평균 대기 시간 계산
        return totalTime / jobList.length;
    }
}

class Job {
    int 요청시간;
    int 소요시간;

    Job(int 요청시간, int 소요시간) {
        this.요청시간 = 요청시간;
        this.소요시간 = 소요시간;
    }
}
