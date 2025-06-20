class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length; // key 크기
        int n = lock.length; // lock 크기
        int size = n * 3; // 배열 확장

        int[][] bigLock = new int[size][size]; // 확장된 lock 배열

        // lock을 가운데에 복사
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                bigLock[i + n][j + n] = lock[i][j];

        // 90도 회전 4번
        for (int turn = 0; turn < 4; turn++) {
            key = rotateKey90(key);

            // key를 x,y 에 놓아보기
            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {

                    // key 값을 bigLock에 더함
                    for (int i = 0; i < m; i++)
                        for (int j = 0; j < m; j++)
                            bigLock[x + i][y + j] += key[i][j];

                    // 가운데 lock 원래 위치가 전부 1이면 성공
                    if (isUnlocked(bigLock, n))
                        return true;

                    // key 제거
                    for (int i = 0; i < m; i++)
                        for (int j = 0; j < m; j++)
                            bigLock[x + i][y + j] -= key[i][j];
                }
            }
        }

        // 열리지 않을 때
        return false;
    }

    // key 90도 회전
    private int[][] rotateKey90(int[][] key) {
        int n = key.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[j][n - 1 - i] = key[i][j];
        return result;
    }

    // 가운데 Lock이 모두 1인지 검사
    private boolean isUnlocked(int[][] map, int n) {
        for (int i = n; i < 2 * n; i++)
            for (int j = n; j < 2 * n; j++)
                if (map[i][j] != 1)
                    return false;
        return true;
    }
}
