public class 모음사전 {
    int answer = 0;       // 몇 번째 단어인지 세는 전역 카운터
    int index = 0;        // 실제로 사전에서 몇 번째 단어인지 추적
    char[] gather = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        dfs("", word);    // 초기 current는 빈 문자열
        return answer;
    }

    void dfs(String current, String target) {
        // 단어가 목표와 같으면 현재 인덱스를 답으로 저장
        if (current.equals(target)) {
            answer = index;
            return;
        }

        // 깊이가 5 이상이면 종료
        if (current.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            index++;
            dfs(current + gather[i], target);
        }
    }
}
