import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 방문 여부
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;

        int[] dr = { -1, 1, 0, 0 }; // 상하좌우
        int[] dc = { 0, 0, -1, 1 }; // 상하좌우

        int dist = 1; // 시작위치 포함한 거리

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                // 도착 지점 도달했을 때 현재 거리 반환
                if (r == n - 1 && c == m - 1) {
                    return dist;
                }

                // 네 방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 범위 내, 이동 가능하고 미방문인 곳
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m
                            && maps[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
            dist++;
        }
        // 도달 불가능한 경우
        return -1;
    }
}