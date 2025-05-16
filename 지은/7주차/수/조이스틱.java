class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 기본 이동 수 (오른쪽 끝까지)

        for (int i = 0; i < len; i++) {
            // 문자 변경 최소 횟수
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 연속된 A 건너뛰기
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') next++;

            // 되돌아가기 포함 최소 이동 계산
            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }

        return answer + move;
    }
}
