import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int A_Idx = 0;
        int B_Idx = 0;
        int count = 0;

        while (A_Idx < A.length && B_Idx < B.length) {
            if (A[A_Idx] < B[B_Idx]) {
                count++;
                A_Idx++;
                B_Idx++;
            } else {
                B_Idx++;
            }
        }

        return count;
    }
}