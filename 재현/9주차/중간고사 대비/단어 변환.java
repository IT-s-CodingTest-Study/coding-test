import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Queue<String> q = new ArrayDeque<>();
        int[] visited = new int[words.length];
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (isDiffOne(begin, words[i])) {
                q.add(words[i]);
                visited[i] = 1;
            }
        }
        
        while(!q.isEmpty()) {
            String now = q.poll();
            
            int now_idx = -1;
            for (int i = 0; i < words.length; i++) {
                if (now == words[i])
                    now_idx = i;
            }
            
            if (now.equals(target)) {
                return visited[now_idx];
            }
            
            for (int i = 0; i < words.length; i++) {
                if (isDiffOne(now, words[i]) && visited[i] == 0) {
                    q.add(words[i]);
                    visited[i] = visited[now_idx] + 1;
                }
            }
        }
        
        return 0;
    }
    
    public boolean isDiffOne(String begin, String target) {
        int count = 0;
        
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i))
                count++;
        }
        
        return count == 1;
    } 
}