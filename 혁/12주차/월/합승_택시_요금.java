package 월;

import java.util.*;

public class 합승_택시_요금 {
    static class Node implements Comparable<Node> {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost)); // 양방향
        }

        int[] distFromS = dijkstra(n, s, graph);
        int[] distFromA = dijkstra(n, a, graph);
        int[] distFromB = dijkstra(n, b, graph);

        int minFare = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (distFromS[i] == Integer.MAX_VALUE || distFromA[i] == Integer.MAX_VALUE || distFromB[i] == Integer.MAX_VALUE)
                continue;
            minFare = Math.min(minFare, distFromS[i] + distFromA[i] + distFromB[i]);
        }

        return minFare;
    }

    private int[] dijkstra(int n, int start, List<List<Node>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.dest]) continue;

            for (Node next : graph.get(cur.dest)) {
                if (dist[next.dest] > cur.cost + next.cost) {
                    dist[next.dest] = cur.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        return dist;
    }
}
