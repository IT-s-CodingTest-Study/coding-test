import java.util.*;

class Solution {
    // 간선 정보를 담는 클래스 
    static class Edge implements Comparable<Edge> {
        int node, cost;
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost; 
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 인접 리스트 생성 
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            int u = fare[0], v = fare[1], cost = fare[2];
            graph.get(u).add(new Edge(v, cost));
            graph.get(v).add(new Edge(u, cost));
        }

        // s, a, b 각각에서 다익스트라 수행
        int[] distFromS = dijkstra(s, n, graph);
        int[] distFromA = dijkstra(a, n, graph);
        int[] distFromB = dijkstra(b, n, graph);

        int answer = Integer.MAX_VALUE;
        // 모든 지점 k를 경유지로 설정하여 최소 비용 계산
        for (int k = 1; k <= n; k++) {
            int totalCost = distFromS[k] + distFromA[k] + distFromB[k];
            answer = Math.min(answer, totalCost);
        }

        return answer;
    }

    // 다익스트라 알고리즘 
    private int[] dijkstra(int start, int n, List<List<Edge>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int now = curr.node;
            int nowCost = curr.cost;

            if (nowCost > dist[now]) continue;

            for (Edge next : graph.get(now)) {
                int nextNode = next.node;
                int newCost = nowCost + next.cost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new Edge(nextNode, newCost));
                }
            }
        }

        return dist;
    }
}
