import java.util.*;
public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        // 금액 오름차순 정렬
        Arrays.sort(d);

        // 금액 적은 순으로 예산 차감
        for(int price : d) {
            budget -= price;
            if(budget >= 0) answer++;
            else break;
        }

        return answer;
    }
}
