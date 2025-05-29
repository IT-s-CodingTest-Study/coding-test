import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0, -2, 2, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0, -2, 2};
    public int solution(int n, int m, int[][] hole) {
        boolean[][] map = new boolean[m][n];
        int[][][] visited = new int[m][n][2];

        Point start = new Point(m - 1, 0, 0);

        for (int[] h : hole) {
            map[m - h[1]][h[0] - 1] = true;
        }

        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        visited[start.r][start.c][0] = 1;

        while(!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == 0 && now.c == n - 1) {
                return visited[now.r][now.c][now.jump] - 1;
            }

            for (int d = 0; d < 4 ; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !map[nr][nc] && visited[nr][nc][now.jump] == 0) {
                    visited[nr][nc][now.jump] = visited[now.r][now.c][now.jump] + 1;
                    q.add(new Point(nr, nc, now.jump));
                }
            }

            if (now.jump == 0) {
                for (int d = 4; d < 8; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !map[nr][nc] && visited[nr][nc][1] == 0) {
                        visited[nr][nc][1] = visited[now.r][now.c][0] + 1;
                        q.add(new Point(nr, nc, 1));
                    }
                }
            }

        }

        return -1;
    }
}

class Point {
    int r, c, jump;
    Point (int r, int c, int jump) {
        this.r = r;
        this.c = c;
        this.jump = jump;
    }
}