public class 자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int totalSize = N + 2 * (M - 1);    // 필요한 최소 크기
        int offset = M - 1;     // 자물쇠 시작 위치

        // 0, 90, 180, 270 회전시킨 키
        int[][][] rotatedKeys = new int[4][M][M];
        rotatedKeys[0] = key;
        for(int i = 1; i < 4; i++) {
            rotatedKeys[i] = rotated90(rotatedKeys[i - 1]);
        }

        // 자물쇠와 키가 맞는지 테스트할 배열
        int[][] board = new int[totalSize][totalSize];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[offset + i][offset + j] = lock[i][j];
            }
        }

        // 이동 및 회전하면서 확인
        for(int r = 0; r < offset + N; r++) {
            for(int c = 0; c < offset + N; c++) {
                for(int rot = 0; rot < 4; rot++) {
                    // key 더하기
                    applyKey(board, rotatedKeys[rot], r, c, 1);

                    // 자물쇠와 키가 맞는지 확인
                    if(check(board, offset, N)) return true;

                    // 원상복구
                    applyKey(board, rotatedKeys[rot], r, c, -1);
                }
            }
        }

        return false;
    }

    private int[][] rotated90(int[][] key) {
        int M = key.length;
        int[][] rotatedKey = new int[M][M];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                rotatedKey[i][j] = key[M - 1 - j][i];
            }
        }

        return rotatedKey;
    }

    // board에 key를 +1 또는 -1
    private void applyKey(int[][] board, int[][] key, int r, int c, int delta) {
        int M = key.length;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                board[r + i][c + j] += key[i][j] * delta;
            }
        }
    }

    // 중앙 자물쇠 부분이 모두 1인지 확인
    private boolean check(int[][] board, int offset, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[offset + i][offset + j] != 1) return false;
            }
        }

        return true;
    }
}