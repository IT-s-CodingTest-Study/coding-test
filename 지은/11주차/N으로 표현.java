import java.util.*;

public class Solution {
    public static int solution(int N, int number) {
        // N 하나만 써서 만들 수 있으면 1 리턴
        if (N == number)
            return 1;

        // dp[i]: N을 i번 써서 만들 수 있는 숫자들
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++)
            dp.add(new HashSet<>());

        // N을 i번 이어붙인 숫자 먼저 추가 (ex: 5, 55, 555 ...)
        for (int i = 1; i <= 8; i++) {
            int repeated = makeRepeatedNumber(N, i);
            dp.get(i).add(repeated);

            // i를 j랑 i-j로 나눠서 가능한 연산 조합들
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        dp.get(i).add(a * b);
                        if (b != 0)
                            dp.get(i).add(a / b);
                        if (a != 0)
                            dp.get(i).add(b / a);
                    }
                }
            }

            // 수 만들어졌으면 사용한 횟수 리턴
            if (dp.get(i).contains(number))
                return i;
        }

        // 8번까지 사용해도 못 만들면 -1 리턴
        return -1;
    }

    // 숫자 이어붙이기 메서드. (N을 i번)
    static int makeRepeatedNumber(int N, int i) {
        int result = 0;
        for (int j = 0; j < i; j++)
            result = result * 10 + N;
        return result;
    }
}
