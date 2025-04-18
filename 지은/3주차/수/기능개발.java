import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>(); // 기능 완료까지 며칠 걸리는지 저장
        List<Integer> result = new ArrayList<>(); // 결과 담을 리스트

         // 각 기능 별 완료까지 남은 일수 계산 후 큐에 저장 
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i]; // 남은 퍼센트
            int days; // 완료까지 필요한 days

      
            // 딱 나뉘면 그대로, 아니면 하루 더 필요
            if (remain % speeds[i] == 0) {
                days = remain / speeds[i]; 
            } else {
                days = (remain / speeds[i]) + 1;
            }

            queue.offer(days); // 계산 날짜 큐에 저장
        }

        // 큐에서 poll하며 묶음 계산
        while (!queue.isEmpty()) {
            int current = queue.poll();  // 기준이 되는 첫 기능 날짜
            int count = 1; 

            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                count++;
            }

            result.add(count); 
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
