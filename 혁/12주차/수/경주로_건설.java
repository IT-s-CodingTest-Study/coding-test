package 수;

import java.util.*;

public class 경주로_건설 {
    static final int STRAIGHT_COST = 100;
    static final int CORNER_COST = 500;

    static class Node {
        int x, y, cost, dir;

        Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] costBoard = new int[n][n][4];  // [x][y][dir] 최소비용 저장 (dir: 0-동, 1-서, 2-남, 3-북)

        for (int[][] layer : costBoard) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new LinkedList<>();

        // 초기 방향은 오른쪽(0), 아래(2)만 가능 (코너가 아님)
        queue.offer(new Node(0, 0, 0, -1));  // -1은 초기 방향 없음
        for (int i = 0; i < 4; i++) {
            costBoard[0][0][i] = 0;
        }

        int[] dx = {1, -1, 0, 0};  // 동서남북
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[ny][nx] == 1) continue;

                int newCost = curr.cost + STRAIGHT_COST;
                if (curr.dir != -1 && curr.dir != i) {
                    newCost += CORNER_COST;
                }

                if (costBoard[ny][nx][i] > newCost) {
                    costBoard[ny][nx][i] = newCost;
                    queue.offer(new Node(nx, ny, newCost, i));
                }
            }
        }

        // 도착지점 (n-1,n-1) 중에서 방향별 최소 비용 찾기
        return Arrays.stream(costBoard[n - 1][n - 1]).min().getAsInt();
    }
}
