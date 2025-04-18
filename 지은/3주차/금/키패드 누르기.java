class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int left = 10; // 왼손 위치 : *
        int right = 12; // 오른손 위치 : #

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            // 1, 4, 7 -> 왼손
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                left = num;
            }
            // 3, 6, 9 -> 오른손
            else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                right = num;
            }
            // 2, 5, 8, 0은 거리 비교
            else {
                if (num == 0)
                    num = 11;

                int leftDistance = Math.abs(num - left) / 3 + Math.abs(num - left) % 3;
                int rightDistance = Math.abs(num - right) / 3 + Math.abs(num - right) % 3;

                // 왼손이 가까울 경우
                if (leftDistance < rightDistance) {
                    answer += "L";
                    left = num;
                }
                // 오른손이 가까울 경우
                else if (leftDistance > rightDistance) {
                    answer += "R";
                    right = num;
                }
                // 거리가 같은 경우
                else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = num;
                    } else {
                        answer += "R";
                        right = num;
                    }
                }
            }
        }
        return answer;
    }
}