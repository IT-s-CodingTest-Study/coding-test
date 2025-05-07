import java.util.*;

class Solution {
    static List<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int src = wire[0];
            int dst = wire[1];

            list[src].remove(Integer.valueOf(dst));
            list[dst].remove(Integer.valueOf(src));

            int rs = Math.abs(n - 2 * bfs(src, n));
            answer = Math.min(answer, rs);

            list[src].add(dst);
            list[dst].add(src);
        }
        
        return answer;
    }
    
    static int bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        return count;
    }
}