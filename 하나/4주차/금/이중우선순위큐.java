import java.util.*;
class 이중우선순위큐 {
    public int[] solution(String[] operations) {
    
        int[] answer = new int[2];
        //최소/최대 힙
        PriorityQueue<Integer> minQueue  = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue  = new PriorityQueue<Integer>(Collections.reverseOrder());
     
        for(String operation : operations){
            String[] io = operation.split(" ");
            int num = Integer.parseInt(io[1]);
            if(io[0].equals("I")){
                maxQueue.offer(num); minQueue.offer(num);
            }else{
                //삭제 연산 전 큐가 비었는지 확인
                if (minQueue.isEmpty() || maxQueue.isEmpty()) continue;
                
                if(num == -1)
                    //최솟값 삭제(minQueue에서 제거한 값을 maxQueue에서도 제거)
                    maxQueue.remove(minQueue.poll());
                else
                    //최댓값 삭제
                    minQueue.remove(maxQueue.poll());
            }
        }
        //큐가 비어있다면 0
        answer[0] = maxQueue.isEmpty() ? 0:maxQueue.peek();
        answer[1] = minQueue.isEmpty() ? 0:minQueue.peek();
        return answer;
    }
}
