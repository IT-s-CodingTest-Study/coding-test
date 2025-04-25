import java.util.PriorityQueue;

public class 더_맵게 {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) {
                pq.offer(s);
            }

            int answer = 0;

            while (pq.size() > 1 && pq.peek() < K) {
                int a = pq.poll();
                int b = pq.poll();
                int c = a + (b * 2);
                pq.offer(c);
                answer++;
            }

            if (pq.peek() < K) return -1;

            return answer;
        }
    }

