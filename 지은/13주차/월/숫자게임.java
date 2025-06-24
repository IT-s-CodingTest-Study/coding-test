import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int score = 0; // Ｂ팀 점수 
        int b = 0; 

        // A팀 숫자를 확인
        for (int a = 0; a < A.length; a++) {
            // B팀 숫자 중 A 보다 큰 수 찾기
            while (b < B.length) {
                if (B[b] > A[a]) {
                    score++;
                    b++;
                    break;
                }
                b++; // 지면 다음 숫자 보기
            }
        }

        return score; 
    }
}
