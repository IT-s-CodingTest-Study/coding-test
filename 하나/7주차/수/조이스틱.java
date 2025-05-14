class Solution {
    public int solution(String name) {
        int answer = 0;
        
        //위 아래 조작 횟수
        for(int i = 0; i < name.length(); i++){
           char c = name.charAt(i);
            answer += Math.min(c-'A', 26 - (c - 'A'));
        }
        //좌우 이동 최소 횟수 계산
        int move = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++){
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            // i까지 갔다가 뒤로 돌아가기
            move = Math.min(move, i + i + (name.length() - next));
            //i까지 갔다가 끝에서 돌아오기
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        return answer + move;
    }
}
