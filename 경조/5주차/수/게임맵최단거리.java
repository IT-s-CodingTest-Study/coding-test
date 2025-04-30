import java.util.*;
public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        // 2차원 배열 visited, distance
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        // 상하좌우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            // 현재 위치
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            // x, y의 좌표가 목표 지점일 때 거리 리턴
            if(x == n - 1  && y == m - 1) {
                return distance[x][y];
            }
            // mx, my는 상하좌우로 움직인 위치
            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if(mx >= 0 && my >= 0 && mx < n && my < m) {
                    // 갈 수 있는 길이면서 방문하지 않은 경우
                    if(maps[mx][my] == 1 && !visited[mx][my]) {
                        queue.offer(new int[] {mx, my});
                        visited[mx][my] = true;
                        // 방문할 거리는 현재 거리에서 + 1
                        distance[mx][my] = distance[x][y] + 1;
                    }
                }
            }
        }
        // 목표 지점을 못 갔으므로 -1 리턴
        return -1;
    }
}
