class Solution {
    public int solution(int[] money) {
        //첫 번째 집과 마지막 집이 인접해 있음
        // 1. 첫 번째 집을 털고, 마지막 집은 안 턴다
        // 2. 첫 번째 집을 안 털고, 마지막 집을 턴다
        
        int[] dp1 = new int[money.length];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for(int i = 2; i < money.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i - 2] + money[i]);
        }
        
        int[] dp2 = new int[money.length];
        dp2[1] = money[1];
        for(int i = 2; i < money.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
        }
       return Math.max(dp1[money.length - 2], dp2[money.length- 1]);
    }
}
