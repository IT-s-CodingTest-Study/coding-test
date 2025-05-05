class 모음사전 {
    public int solution(String word) {
        int answer = 0;
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] weights = {781, 156, 31, 6, 1}; // 자리별 가중치

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // 현재 글자가 vowels 배열에서 몇 번째인지 찾기
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == c) {
                    answer += j * weights[i]; // 앞선 조합 수 모두 더함
                    break;
                }
            }
        }

        // 자기 자신도 포함해야 하므로 +
        return answer + word.length();
    }
}
