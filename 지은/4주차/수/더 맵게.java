import java.util.*;

class Solution {
    public int solution(int[] scoville, int targetScoville) {
        int mixCount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐에 삽입
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        // 가장 맵지 않은 음식이 목표 스코빌 이상이 될 때까지 반복
        while (!pq.isEmpty() && pq.peek() < targetScoville) {
            if (pq.size() >= 2) {
                int leastSpicy = pq.poll();
                int secondLeastSpicy = pq.poll();
                int mixedScoville = leastSpicy + (secondLeastSpicy * 2);
                pq.add(mixedScoville);
                mixCount++;
            } else {
                return -1; // 섞을 수 있는 음식이 2개 미만이면 -1
            }
        }

        return mixCount;
    }
}
