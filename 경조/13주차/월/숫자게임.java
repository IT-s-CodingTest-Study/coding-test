import java.util.*;
public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int idxA = 0;
        int idxB = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[idxA] < B[idxB]) {
                idxA++;
                idxB++;
                answer++;
            } else idxB++;
        }

        return answer;
    }
}