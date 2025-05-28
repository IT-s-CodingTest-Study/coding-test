import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int src = wire[0];
            int dst = wire[1];
            
            list[src].add(dst);
            list[dst].add(src);
        }
        
        for (int[] wire : wires) {
            int src = wire[0];
            int dst = wire[1];
            
            list[dst].remove(Integer.valueOf(src));
            list[src].remove(Integer.valueOf(dst));
            
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            
            q.add(1);
            visited[1] = true;
            
            int count = 1;
            
            while(!q.isEmpty()) {
                int now = q.poll();
                
                for (int next : list[now]) {
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                        count++;
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs(n - count - count));
            
            list[src].add(dst);
            list[dst].add(src);
        }
        
        return answer;
    }
}