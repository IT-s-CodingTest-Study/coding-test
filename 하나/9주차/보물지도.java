import java.util.*;

class Solution {
    static class Node {
        int x, y, time, used;

        Node(int x, int y, int time, int used) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.used = used; // 0: 신발 안씀, 1: 신발 씀
        }
    }

    public int solution(int n, int m, int[][] hole) {
        boolean[][][] visited = new boolean[n + 1][m + 1][2]; // [x][y][0 or 1]
        boolean[][] trap = new boolean[n + 1][m + 1];

        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1, 0, 0));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == n && curr.y == m) {
                return curr.time;
            }

            // 1칸 이동 (걷기)
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if (trap[nx][ny] || visited[nx][ny][curr.used]) continue;

                visited[nx][ny][curr.used] = true;
                queue.offer(new Node(nx, ny, curr.time + 1, curr.used));
            }

            // 2칸 점프 (신발 한 번만 사용 가능)
            if (curr.used == 0) {
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i] * 2;
                    int ny = curr.y + dy[i] * 2;

                    if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                    if (visited[nx][ny][1]) continue;

                    // 중간 칸이 함정이어도 괜찮음, 도착 칸이지만 함정이면 안 됨
                    if (trap[nx][ny]) continue;

                    visited[nx][ny][1] = true;
                    queue.offer(new Node(nx, ny, curr.time + 1, 1));
                }
            }
        }

        return -1; // 도착 못함
    }
}
