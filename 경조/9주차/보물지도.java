import java.util.*;
public class 보물지도 {
    // 클래스 정의 좌표, 거리, 점프 여부
    public class User {
        int r;
        int c;
        int dist;
        int jump;

        User(int r, int c, int dist, int jump) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.jump = jump;
        }
    }

    public int solution(int n, int m, int[][] hole) {
        // n, m으로 지도 정보 구성
        int[][] map = new int[n][m];
        // 지도에 함정 표시
        for(int[] h : hole) {
            map[h[0] - 1][h[1] - 1] = 1;
        }
        // 상하좌우 1칸
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        // 상하좌우 2칸
        int[] dr2 = {2, -2, 0, 0};
        int[] dc2 = {0, 0, 2, -2};

        // bfs
        // visited 3차원 배열로 점프가 있는지 없는지에 따라 방문 다르게
        Deque<User> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][2];

        // 1: 점프 미사용, 0: 점프 사용
        queue.offer(new User(0, 0, 0, 1));
        visited[0][0][1] = true;

        while(!queue.isEmpty()) {
            User u = queue.poll();
            if(u.r == n - 1 && u.c == m - 1) return u.dist;

            // 1칸 이동
            for(int i = 0; i < 4; i++) {
                int nr = u.r + dr[i];
                int nc = u.c + dc[i];
                if(check(nr, nc, n, m)) {
                    if(map[nr][nc] == 0 && !visited[nr][nc][u.jump]) {
                        queue.offer(new User(nr, nc, u.dist + 1, u.jump));
                        visited[nr][nc][u.jump] = true;
                    }
                }
            }
            // 점프가 있는 경우
            if(u.jump == 1) {
                for(int i = 0; i < 4; i++) {
                    int nr = u.r + dr2[i];
                    int nc = u.c + dc2[i];
                    if(check(nr, nc, n, m)) {
                        if(map[nr][nc] == 0 && !visited[nr][nc][0]) {
                            queue.offer(new User(nr, nc, u.dist + 1, 0));
                            visited[nr][nc][0] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    public boolean check(int r, int c, int n, int m) {
        return (r >= 0) && (r < n) && (c >= 0) && (c < m);
    }
}