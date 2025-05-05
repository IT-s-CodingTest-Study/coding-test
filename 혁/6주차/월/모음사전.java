public class 모음사전 {
    public int solution(String word) {
        char[] chars = {'A', 'E', 'I', 'O', 'U'};
        int[] weight = {781, 156, 31, 6, 1};
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            int index = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == word.charAt(i)) {
                    index = j;
                    break;
                }
            }
            answer += index * weight[i] + 1;
        }

        return answer;
    }
}
