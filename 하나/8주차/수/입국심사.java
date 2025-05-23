import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) getMax(times) * n;  //최대시간
        long answer = right;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            
            //mid 시간 동안 각 심사관이 처리할 수 잇는 사람 수
            for(int time : times){
                sum += mid / time;
            }
            if(sum >= n){
                // n명 이상 처리 가능하면
                // 더 짧은 시간 시도
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
    // 최대값 구하기
    private int getMax(int[] arr) {
        int max = 0;
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
}
