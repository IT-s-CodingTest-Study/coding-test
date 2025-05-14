public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        for(int i = 0; i < name.length(); i++) {
            int move_up = name.charAt(i) - 'A';
            int move_down = 'Z' - name.charAt(i) + 1;
            answer += Math.min(move_up, move_down);
        }
        // 좌우 최대 움직임은 글자 길이 - 1
        int min_move = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            min_move = Math.min(min_move, i * 2 + name.length() - next);
            min_move = Math.min(min_move, (name.length() - next) * 2 + i);
        }

        return answer + min_move;
    }
}