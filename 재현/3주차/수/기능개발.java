import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < len; i++) {
            int x = (100 - progresses[i]) / speeds[i];
            q.add(((100 - progresses[i]) % speeds[i]) > 0 ? x + 1: x); 
        }
        
        
        int now = q.poll();
        int count = 1;
        List<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int compare = q.peek();
            if(now >= compare) {
                q.poll();
                count++;
            } else {
                result.add(count);
                now = q.poll();
                count = 1;
            }
        }
        
        result.add(count);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}