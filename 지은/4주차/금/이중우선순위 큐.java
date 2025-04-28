import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

        for (int i = 0; i < operations.length; i++) {
            String[] tokens = operations[i].split(" ");
            String cmd = tokens[0];
            int num = Integer.parseInt(tokens[1]);

            if (cmd.equals("I")) {
                // 두 힙에 모두 삽입
                minHeap.offer(num);
                maxHeap.offer(num);
            } else if (cmd.equals("D")) {
                if (minHeap.isEmpty()) continue;

                if (num == -1) {
                    // 두 힙의 최솟값 삭제
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                } else {
                    //두 힙의 최댓값 삭제
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }
            }
        }
        // 큐가 빔 -> [0,0] 반환
        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}
