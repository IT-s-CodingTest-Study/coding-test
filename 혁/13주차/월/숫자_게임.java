package 월;

import java.util.Arrays;

public class 숫자_게임 {

    public int solution(int[] A, int[] B) {
        Arrays.sort(B);
        int win = 0;
        boolean[] used = new boolean[B.length];
        for (int i = 0; i < A.length; i++) {
            int target = A[i];
            for (int j = 0; j < B.length; j++) {
                if (!used[j] && B[j] > target) {
                    used[j] = true;
                    win++;
                    break;
                }
            }
        }
        return win;
    }
}


