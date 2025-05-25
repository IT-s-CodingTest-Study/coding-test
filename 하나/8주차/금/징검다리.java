import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int removed = 0; //제거한 바위 개수
            int prev = 0;
            
            //모든 바위를 순회하며 거리가 mid 이상인지
            for(int rock : rocks){
                int gap = rock - prev;
                
                if(gap < mid){
                    //거리가 짧으면 바위 제거
                    removed++;
                }else{
                    //아니면 바위는 유지하고 기존 위치를 갱신
                    prev = rock;
                }
            }
            
            if(distance - prev < mid){
                removed++;
            }
            
            if(removed <= n){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return answer;
    }
}
