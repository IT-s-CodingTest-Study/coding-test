import java.util.*;
public class 전력망_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 간선 정보로 인접그래프 구성
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] w : wires) {
            graph.get(w[0] - 1).add(w[1] - 1);
            graph.get(w[1] - 1).add(w[0] - 1);
        }

        // 간선을 하나씩 제거하면서 bfs 수행
        for(int[] w : wires) {
            graph.get(w[0] - 1).remove(Integer.valueOf(w[1] - 1));
            graph.get(w[1] - 1).remove(Integer.valueOf(w[0] - 1));

            int count = bfs(graph, n);
            // 네트워크 간 노드 개수 차이
            int diff = Math.abs((n - count) - count);

            answer = Math.min(answer, diff);

            graph.get(w[0] - 1).add(w[1] - 1);
            graph.get(w[1] - 1).add(w[0] - 1);
        }

        return answer;
    }

    // 리턴 값 노드 개수
    public int bfs(List<List<Integer>> graph, int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int count = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
