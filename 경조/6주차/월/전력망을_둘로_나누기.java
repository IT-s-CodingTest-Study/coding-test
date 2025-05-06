import java.util.*;
class 전력망을_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;		// 정수형 최대값
        // 인접리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        // 양방향 간선 추가
        for(int[] wire : wires) {
            int a = wire[0] - 1;
            int b = wire[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 간선 제거하며 비교
        for(int[] wire : wires) {
            int a = wire[0] - 1;
            int b = wire[1] - 1;

            // Integer 붙인 이유: 인덱스를 제거하지 않고, 값으로서 제거하기 위함
            graph.get(a).remove((Integer) b);
            graph.get(b).remove((Integer) a);

            boolean[] visited = new boolean[n];
            int size = bfs(a, graph, visited);
            int diff = Math.abs((n - size) - size);
            answer = Math.min(answer, diff);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return answer;
    }

    private int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
