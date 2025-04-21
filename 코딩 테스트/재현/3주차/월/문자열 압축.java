import java.util.*;

class Solution {
    public int solution(String s) {
        
        int len = s.length();
        int answer = len;
        
        for (int token = 1; token <= len / 2; token++) {
            Queue<String> q = new LinkedList<>();
            
            for (int i = 0; i < len; i+= token) {
                q.add(s.substring(i, Math.min(i + token, len)));
            }
            
            StringBuilder sb = new StringBuilder();
            String word = q.poll();
            int count = 1;
            
            while(!q.isEmpty()) {
                String now = q.poll();
                if (word.equals(now)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(word);
                    word = now;
                    count = 1;
                }
            }
            if (count > 1) sb.append(count);
            sb.append(word);
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}