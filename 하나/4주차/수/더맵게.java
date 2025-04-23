import java.util.*;
class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int s : scoville){
            minHeap.offer(s);
        }
        
        while(minHeap.peek()< K){
             if(minHeap.size()<2 )return -1;
            
        int first = minHeap.poll();
        int second = minHeap.poll();
        int mixed = first + second *2;
            
        minHeap.offer(mixed);
        answer++;
        }
        return answer;
    }
}
