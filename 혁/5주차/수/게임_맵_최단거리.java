import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == n - 1 && current.y == m - 1) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, current.distance + 1));
                    }
                }
            }
        }
        return -1;
    }
    static class Node {
        int x, y, distance;
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}


