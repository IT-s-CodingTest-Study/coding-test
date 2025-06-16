import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        List<Node>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            list[fare[0]].add(new Node(fare[1], fare[2]));
            list[fare[1]].add(new Node(fare[0], fare[2]));
        }
        
        int[] distanceS = dijkstra(n, s, list);
        int[] distanceA = dijkstra(n, a, list);
        int[] distanceB = dijkstra(n, b, list);
        
        int answer = Integer.MAX_VALUE;
        
        for (int k = 1; k <= n; k++) {
            int total = distanceS[k] + distanceA[k] + distanceB[k];
            answer = Math.min(answer, total);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int n, int start, List<Node>[] list) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (now.cost > dist[now.to])
                continue;
            
            for (Node next : list[now.to]) {
                int nextCost = dist[now.to] + next.cost;
                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.add(new Node(next.to, nextCost));
                }
            }
        }
        
        return dist;
    }
}


class Node {
    int to, cost;
    
    Node (int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}