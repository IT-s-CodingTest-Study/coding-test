class Solution {
    public int[] solution(int brown, int yellow) {
        // [가로, 세로] 정답 배열 선언
        int[] answer = new int[2];

        // 전체 격자 수
        int total = brown + yellow;

        // 세로의 최소 길이 = 3
        for (int height = 3; height <= total / 3; height++) {
            if (total % height != 0)
                continue;

            int width = total / height;

            // yellow가 조건에 맞으면 정답
            if ((width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }
}
