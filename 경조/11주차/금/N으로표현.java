import java.util.*;
public class N으로표현 {
    public int solution(int N, int number) {
        if(N == number) return 1;

        // Set 이용
        // 같은 번호 사용한 횟수에서 나올 수 있는 값 저장
        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        // 숫자 1개 사용은 자기 자신뿐
        list.get(1).add(N);

        // 숫자 사용 횟수 (2~8)
        for(int i = 2; i <= 8; i++) {
            Set<Integer> total = list.get(i);

            // 이전 값들로 경우의 수 찾기
            for(int j = 1; j < i; j++) {
                // 예) 4개 사용한 경우 (1, 3), (2, 2), (3, 1) 경우 계산하기 위함
                Set<Integer> a = list.get(j);
                Set<Integer> b = list.get(i - j);

                // '+', '-', '*', '/' 연산 결과 추가
                for(int x : a) {
                    for(int y : b) {
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if(x != 0 && y != 0) total.add(x/y);
                    }
                }

                // 예) 2를 2개 사용한 경우 22도 추가해야함
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            // 계산 값에 있으면 리턴
            if(total.contains(number)) return i;
        }

        // 8개 사용하는 동안 못 찾았다면 -1
        return -1;
    }
}
