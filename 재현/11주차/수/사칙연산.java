class Solution {
    public int solution(String arr[]) {
        int n = (arr.length + 1) / 2;
        int[] nums = new int[n];
        char[] ops = new char[n - 1];
        
        // arr에서 num, op를 추출하여 nums, ops 초기화
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[2 * i]);
            if (i < n - 1) {
                ops[i] = arr[2 * i + 1].charAt(0);
            }
        }
        
        // dp 배열 초기화
        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i]; 
        }
        
        
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
                
                // i ~ j 구간을 k를 기준으로 나누어 계산
                for (int k = i; k < j; k++) {
                    char op = ops[k];
                    int max1 = dpMax[i][k];
                    int max2 = dpMin[i][k];
                    int min1 = dpMax[k + 1][j];
                    int min2 = dpMin[k + 1][j];
                    
                    
                    if (op == '+') { // 덧셈 : 최대 + 최대, 최소 + 최소
                        dpMax[i][j] = Math.max(dpMax[i][j], max1 + min1);
                        dpMin[i][j] = Math.min(dpMin[i][j], max2 + min2);
                    } else {         // 뺄셈 : 최대 - 최소, 최소 - 최대
                        dpMax[i][j] = Math.max(dpMax[i][j], max1 - min2);
                        dpMin[i][j] = Math.min(dpMin[i][j], max2 - min1);
                    }
                }
            }
        }
                
        return dpMax[0][n - 1];
    }
}