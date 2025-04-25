import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String op : operations) {
            String[] ops = op.split(" ");
            String cmd = ops[0];
            int num = Integer.parseInt(ops[1]);

            switch(cmd) {
                case "I":
                    minHeap.add(num);
                    maxHeap.add(num);
                    break;
                case "D":
                    if (minHeap.isEmpty()) break;
                    if (num == 1)   minHeap.remove(maxHeap.poll());
                    if (num == -1)  maxHeap.remove(minHeap.poll());
            }
        }
        
        return minHeap.isEmpty() ? new int[]{0, 0} : new int[]{maxHeap.poll(), minHeap.poll()};
    }
}