class Solution {
    public int solution(int[] money) {
        // 1. 첫 집을 터는 경우 → 마지막 집은 못 털음
        int[] dp1 = new int[money.length];
        dp1[0] = money[0];
        dp1[1] = money[0];
        for (int i = 2; i < money.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        // 2. 첫 집을 안 터는 경우 → 마지막 집까지 가능
        int[] dp2 = new int[money.length];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}
