import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited; // 방문 여부
    int count; // 방문 노드 수

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 그래프 초기화 (1번 노드부터 시작, n+1)
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 저장
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 간선 하나씩 끊어서 두 전력망으로 나눠보기
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 간선 끊기 (양방향이므로 양쪽 제거)
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));

            // 끊어진 상태에서 한 쪽에 DFS 수행
            visited = new boolean[n + 1];
            count = 0;
            DFS(a); // 한 쪽 송전탑 개수가 count에 누적

            // 두 전력망의 송전탑 개수 차이 계산
            int diff = (count > n - count) ? count - (n - count) : (n - count) - count;
            answer = Math.min(answer, diff);

            // 끊은 간선 복원
            graph[a].add(b);
            graph[b].add(a);
        }

        return answer;
    }

    // DFS로 연결된 송전탑 개수 누적
    void DFS(int node) {
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
