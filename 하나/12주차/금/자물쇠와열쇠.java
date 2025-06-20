class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        
        int nn = n + 2 * (m - 1);
        int[][] newLock = new int[nn][nn];

        // lock 배열을 newLock 중앙에 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);

            for (int x = 0; x <= nn - m; x++) {
                for (int y = 0; y <= nn - m; y++) {
                    // newLock에 key를 더함
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }

                    if (check(newLock, m, n)) {
                        return true;
                    }

                    // 더한 부분 원상복구
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    // key 회전 함수 
    public int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] rotated = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][m - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    // lock 부분이 모두 1인지 확인
    public boolean check(int[][] newLock, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newLock[i + m - 1][j + m - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
