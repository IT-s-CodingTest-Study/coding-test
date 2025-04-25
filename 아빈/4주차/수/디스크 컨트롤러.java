import java.util.*;
class Work {
    int wt; //소요 시간
    int wa; //요청 시간

    Work(int wt, int wa){
        this.wt = wt;
        this.wa = wa;
    }
}
class Solution {

    public int solution(int[][] jobs) {
        int time = 0;
        int total = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        Queue<Work> workQ = new LinkedList<>();
        PriorityQueue<Work> waitQ = new PriorityQueue<>(Comparator.comparingInt(w -> w.wt));

        for (int[] job : jobs) {
            workQ.add(new Work(job[1], job[0]));
        }


        while(!workQ.isEmpty() || !waitQ.isEmpty()){
            while(!workQ.isEmpty() && workQ.peek().wa <= time){
                waitQ.add(workQ.poll());
            }
            if(!waitQ.isEmpty()){
                Work current = waitQ.poll();
                time += current.wt;
                total += (time - current.wa);
            } else {
                time ++;
            }
        }
        return total / jobs.length;
    }
}