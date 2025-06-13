import java.util.*;
public class 사칙연산 {
    public int solution(String arr[]) {
        List<Integer> numList = new ArrayList<>();
        List<String> operList = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(i % 2 != 0) operList.add(arr[i]);
            else numList.add(Integer.parseInt(arr[i]));
        }

        int[] nums = numList.stream().mapToInt(i -> i).toArray();   // 숫자
        String[] oper = operList.toArray(new String[0]);            // 연산자

        int N = nums.length;
        // dpMax[i][j] : nums[i] ~ nums[j] 구간에서 만들 수 있는 최대값
        // dpMin[i][j] : nums[i] ~ nums[j] 구간에서 만들 수 있는 최소값
        int[][] dpMax = new int[nums.length][nums.length];
        int[][] dpMin = new int[nums.length][nums.length];

        // 초기값: 길이 1인 부분 수식은 자기 자신이 그대로 최대/최솟값
        for(int i = 0; i < N; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }

        // 부분 수식의 길이를 2부터 N까지 증가
        for(int len = 2; len <= N; len++) {
            for(int i = 0; i <= N - len; i++) {
                int j = i + len - 1;    // 부분 수식의 오른쪽 끝 인덱스
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;

                // 가능한 모든 k 지점(연산자 위치)에 대해 분할하여 최대값, 최소값 갱신
                for(int k = i; k < j; k++) {
                    char op = oper[k].charAt(0);

                    int a = calc(dpMax[i][k], dpMax[k+1][j], op);
                    int b = calc(dpMax[i][k], dpMin[k+1][j], op);
                    int c = calc(dpMin[i][k], dpMax[k+1][j], op);
                    int d = calc(dpMin[i][k], dpMin[k+1][j], op);

                    dpMax[i][j] = Math.max(dpMax[i][j], Math.max(Math.max(a, b), Math.max(c, d)));
                    dpMin[i][j] = Math.min(dpMin[i][j], Math.min(Math.min(a, b), Math.min(c, d)));
                }
            }
        }


        return dpMax[0][N - 1];
    }

    public int calc(int a, int b, char op) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            default: return 0;
        }
    }
}