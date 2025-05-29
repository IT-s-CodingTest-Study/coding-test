import java.util.*;
public class 전력망_둘로_나누기 {
    int answer = 0;
    public int solution(int n, int[][] wires) {
        answer = n;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n);
        return answer;
    }

    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int cur, int n) {
        int count = 1;
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count += dfs(graph, visited, next, n);
            }
        }
        answer = Math.min(answer, Math.abs(n - count * 2));
        return count;
    }
}
