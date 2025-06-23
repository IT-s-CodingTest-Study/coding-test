import java.util.*;

class 숫자게임 {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int answer = 0;
		int a = 0;
		int b = 0;
		while (a < A.length && b < B.length) {
			if (B[b] > A[a]) {
				answer++;
				a++;
				b++;
			} else {
				b++;
			}
		}

		return answer;
	}
}