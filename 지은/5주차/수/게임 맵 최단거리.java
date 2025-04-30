import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;       // 세로 길이
        int m = maps[0].length;    // 가로 길이

        // 상하좌우 방향 이동
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        boolean[][] visited = new boolean[n][m]; 
        Queue<int[]> queue = new LinkedList<>(); 

        queue.add(new int[]{0, 0}); // 시작 위치 추가
        visited[0][0] = true;       // 시작 위치 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 안이고, 갈 수 있는 길(1)이고, 아직 방문하지 않은 칸
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1; // 지금까지의 거리 + 1
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
       // 도착점이 여전히 1이면 도달 불가
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}
