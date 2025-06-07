class Solution {
    public int solution(int[] money) {
        
        int max = Math.max(calc(money, 0, money.length - 2), calc(money, 1, money.length - 1));
        
        return max;
    }
    
    public int calc(int[] money, int start, int end) {
        if (start == end)   return money[start];
        
        int n = end - start + 1;
        int[] dp = new int[n];
        
        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start + 1]);
        
        for (int i = 2; i < n ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[start + i]);
        }
        
        return dp[n - 1];
    }
}