package 금;

public class 자물쇠와_열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int expandSize = N + 2 * (M - 1);
        int[][] expandedLock = new int[expandSize][expandSize];

        // lock을 가운데에 배치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                expandedLock[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        // 열쇠를 4번 회전하며 확인
        for (int r = 0; r < 4; r++) {
            key = rotate(key); // 열쇠 회전

            for (int x = 0; x <= expandSize - M; x++) {
                for (int y = 0; y <= expandSize - M; y++) {
                    // 열쇠를 (x, y)에 놓아보기
                    if (check(expandedLock, key, x, y, M, N)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // 90도 회전
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

    // 현재 위치에서 열쇠를 배치하고 자물쇠가 맞는지 확인
    private boolean check(int[][] lockBoard, int[][] key, int x, int y, int M, int N) {
        int[][] board = new int[lockBoard.length][lockBoard.length];

        // lockBoard 복사
        for (int i = 0; i < lockBoard.length; i++) {
            board[i] = lockBoard[i].clone();
        }

        // key 값을 더하기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[x + i][y + j] += key[i][j];
            }
        }

        // 자물쇠 부분이 모두 1이어야 함
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


