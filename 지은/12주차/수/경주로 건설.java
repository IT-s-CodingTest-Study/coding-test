import java.util.*;

class Solution {
    // 이동 방향
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    // [x][y][방향] 최소 비용
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];

        Queue<int[]> queue = new ArrayDeque<>();

        // 초기화
        for (int[][] c1 : cost)
            for (int[] c2 : c1)
                Arrays.fill(c2, Integer.MAX_VALUE);

        // 네 방향으로 이동해보기
        for (int d = 0; d < 4; d++) {
            cost[0][0][d] = 0; // 초기 위치
            queue.offer(new int[] { 0, 0, d, 0 }); // {x, y, 방향, 비용}
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dir = cur[2], curCost = cur[3];

            // 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 벗어나거나 벽이면 패스
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1)
                    continue;

                // 직진이면 100원, 코너면 600원
                int newCost = curCost + (dir == d ? 100 : 600);

                // 기존 비용보다 작으면 갱신하고 큐에 추가
                if (cost[nx][ny][d] > newCost) {
                    cost[nx][ny][d] = newCost;
                    queue.offer(new int[] { nx, ny, d, newCost });
                }
            }
        }

        // 도착지점까지의 최소 비용
        return Arrays.stream(cost[n - 1][n - 1]).min().getAsInt();
    }
}
