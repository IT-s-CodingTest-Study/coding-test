package 금;

public class 자물쇠와_열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int expandSize = N + 2 * (M - 1);
        int[][] expandedLock = new int[expandSize][expandSize];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                expandedLock[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {
            key = rotate(key);

            for (int x = 0; x <= expandSize - M; x++) {
                for (int y = 0; y <= expandSize - M; y++) {
                    if (check(expandedLock, key, x, y, M, N)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] rotate(int[][] key) {
        int M = key.length;
        int[][] result = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                result[j][M - 1 - i] = key[i][j];
            }
        }
        return result;
    }

    private boolean check(int[][] lockBoard, int[][] key, int x, int y, int M, int N) {
        int[][] board = new int[lockBoard.length][lockBoard.length];

        for (int i = 0; i < lockBoard.length; i++) {
            board[i] = lockBoard[i].clone();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[x + i][y + j] += key[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i + M - 1][j + M - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}


