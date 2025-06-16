import java.util.*;
public class 합승택시요금 {
    // 간선 정보를 담는 클래스 (노드 번호, 비용 포함)
    public class Edge implements Comparable<Edge> {
        int index;  // 연결된 노드 번호
        int cost;   // 연결 비용

        Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost; // 비용 기준 오름차순 정렬
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        // 인접 리스트 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 그래프 구성
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            graph.get(u).add(new Edge(v, cost));
            graph.get(v).add(new Edge(u, cost));
        }

        // 각각 s, a, b에서 출발하는 다익스트라 결과
        int[] startS = dijkstra(s, n, graph);
        int[] startA = dijkstra(a, n, graph);
        int[] startB = dijkstra(b, n, graph);

        // 모든 노드 i에 대해 s->i, i->a, i->b의 최소 비용 합 계산
        for (int i = 0; i <= n; i++) {
            answer = Math.min(answer, startS[i] + startA[i] + startB[i]);
        }

        return answer;
    }

    // 다익스트라
    public int[] dijkstra(int start, int n, List<List<Edge>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            for (Edge next : graph.get(cur.index)) {
                int newCost = cur.cost + next.cost;
                if (dist[next.index] > newCost) {
                    dist[next.index] = newCost;
                    queue.add(new Edge(next.index, newCost));
                }
            }
        }

        return dist;
    }
}
