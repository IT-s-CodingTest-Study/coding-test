import java.util.*;

public class 디스크_컨트롤러 {
    class Solution {
        class Job {
            public int id;
            public int rqTime;
            public int duration;

            public Job(int id, int rqTime, int duration) {
                this.id = id;
                this.rqTime = rqTime;
                this.duration = duration;
            }
        }

        public int solution(int[][] jobs) {
            int n = jobs.length;
            List<Job> jobList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                jobList.add(new Job(i, jobs[i][0], jobs[i][1]));
            }

            //람다식 써도 되는데 모름
            //우선 순위 비교연산 후 정렬 요청시간이 높은거를 뒤로
            Collections.sort(jobList, new Comparator<Job>() {
                @Override
                public int compare(Job a, Job b) {
                    return a.rqTime - b.rqTime;
                }
            });

            //람다식 써도 되는데 모름
            // 작업시간이 짧은 순, 요청 시간이 빠른순, 작업 번호가 작은순으로 우선순위 정함
            PriorityQueue<Job> waitingQueue = new PriorityQueue<>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    if (o1.duration != o2.duration) {
                        return o1.duration - o2.duration;
                    }
                    if (o1.rqTime != o2.rqTime) {
                        return o1.rqTime - o2.rqTime;
                    }
                    return o1.id - o2.id;
                }
            });
            //현재 시점
            int time = 0;
            //아직 대기큐에 안넣은 job인덱스
            int idx = 0;
            //모든 작업 대기시간 총합
            int totalWait = 0;
            //처리한 작업수
            int count = 0;

            //모든 작업을 처리할때까지
            while (count < jobList.size()) {
                //현재 시각까지 도착한 작업 큐에 추가
                while (idx < jobList.size() && jobList.get(idx).rqTime <= time) {
                    waitingQueue.offer(jobList.get(idx));
                    idx++;
                }
                //대기 큐가 비었으면 -> 작업 요청한데까지 시간 이동
                if (waitingQueue.isEmpty()) {
                    time = jobList.get(idx).rqTime;
                    continue;
                }
                // 우선 순위 높은거 작업
                Job job = waitingQueue.poll();
                //작업한거 만큼 시간 현재시각 추가
                time += job.duration;
                // 총시간에도 추가
                totalWait += time - job.rqTime;
                //처리한 작업 수 추가
                count++;
            }
            return totalWait / n;
        }
    }
}
