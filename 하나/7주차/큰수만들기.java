class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int len = number.length() - k;
        
        for(int i = 0; i < len; i++){
            char max = '0';
            //현재 위치 idx부터 k+i까지 중에서 가장 큰 수
            for(int j = idx; j <= k+i; j++){
                if(number.charAt(j)>max){
                    max = number.charAt(j);// 더 큰 숫자 발견 시 max 갱신
                    idx = j + 1; // 다음 자리 탐색 시작
                }
            }  answer.append(max); 
        }
        return answer.toString();
    }
}
