import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 두 배열 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 참가자와 완주자 배열 앞에서부터 비교
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i]; // 인덱스 비교 결과 다르면 －＞ 완주 못한 사람
            }
        }

        // 다 같았다면 마지막 사람이 완주 못함
        return participant[participant.length - 1];
    }
}
