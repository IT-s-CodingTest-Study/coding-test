import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 그래프 초기화
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // 양방향 간선
        for (int[] fare : fares) {
            int u = fare[0], v = fare[1], w = fare[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        // s, a, b부터 각 노드까지 최단 거리
        int[] distS = dijkstra(s, n, graph);
        int[] distA = dijkstra(a, n, graph);
        int[] distB = dijkstra(b, n, graph);

        int minFare = Integer.MAX_VALUE;

        // 모든 경유지 k에 대해 s→k + k→a + k→b 합 계산
        for (int k = 1; k <= n; k++) {
            if (distS[k] == Integer.MAX_VALUE || distA[k] == Integer.MAX_VALUE || distB[k] == Integer.MAX_VALUE)
                continue;
            int total = distS[k] + distA[k] + distB[k];
            minFare = Math.min(minFare, total);
        }

        return minFare;
    }

    // 다익스트라 (start에서 모든 노드까지 최소 거리)
    int[] dijkstra(int start, int n, List<int[]>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // [노드, 비용]
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            // 이미 더 짧은 거리로 방문한 경우
            if (cost > dist[now]) continue;

            // 연결된 노드 검사
            for (int[] next : graph[now]) {
                int to = next[0];
                int weight = next[1];
                int newCost = cost + weight;

                // 더 짧은 거리 발견 시 갱신
                if (newCost < dist[to]) {
                    dist[to] = newCost;
                    pq.offer(new int[]{to, newCost});
                }
            }
        }

        return dist;
    }
}
