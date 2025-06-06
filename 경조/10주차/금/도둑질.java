public class 도둑질 {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length];  // 첫번째 집부터 털기, 마지막 집은 못 터는 경우
        int[] dp2 = new int[money.length];  // 첫번째 집부터 털지 않기
        
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i = 2; i < money.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], money[i] + dp1[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], money[i] + dp2[i - 2]);
        }
        
        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}
