import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] hole) {
        // 1. 함정 위치를 표시하는 배열
        boolean[][] trap = new boolean[n + 1][m + 1];
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        // 2. 방문 여부를 기록하는 3차원 배열
        // visited[x][y][0] = (x,y)에 신발 없이 도달한 경우
        // visited[x][y][1] = (x,y)에 신발을 사용해서 도달한 경우
        boolean[][][] visited = new boolean[n + 1][m + 1][2];

        // 3. BFS를 위한 큐 구성
        // 큐에는 {x좌표, y좌표, 신발 사용 여부, 현재 거리}를 저장
        Queue<int[]> queue = new ArrayDeque<>();
        visited[1][1][0] = true;
        queue.add(new int[] { 1, 1, 0, 0 });

        // 4. 일반 이동 (한 칸)
        int[][] dir1 = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // 5. 신발을 사용한 이동 (두 칸)
        int[][] dir2 = { { 0, 2 }, { 2, 0 }, { 0, -2 }, { -2, 0 } };

        // 6. BFS 수행
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], jumped = cur[2], dist = cur[3];

            // 7. 목적지에 도착하면 거리 반환
            if (r == n && c == m) {
                return dist;
            }

            // 8. 한 칸 이동
            for (int d = 0; d < 4; d++) {
                int nr = r + dir1[d][0];
                int nc = c + dir1[d][1];

                if (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                    if (!visited[nr][nc][jumped] && !trap[nr][nc]) {
                        visited[nr][nc][jumped] = true;
                        queue.add(new int[] { nr, nc, jumped, dist + 1 });
                    }
                }
            }

            // 9. 신발을 사용하지 않은 경우 두 칸 이동 시도
            if (jumped == 0) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + dir2[d][0];
                    int nc = c + dir2[d][1];

                    if (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                        if (!visited[nr][nc][1] && !trap[nr][nc]) {
                            visited[nr][nc][1] = true;
                            queue.add(new int[] { nr, nc, 1, dist + 1 });
                        }
                    }
                }
            }
        }

        // 10. 도달할 수 없는 경우
        return -1;
    }
}
