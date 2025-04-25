import java.util.*;
class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐 기본 정렬 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 우선순위
        for(int s : scoville) {
            pq.add(s);
        }
        // 큐의 사이즈가 2 이상이고 앞에 있는 값이 K보다 작을 때 수행
        while(pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int n = first + (second * 2);
            pq.add(n);
            answer++;
        }
        return pq.peek() >= K ? answer : -1;
    }
}