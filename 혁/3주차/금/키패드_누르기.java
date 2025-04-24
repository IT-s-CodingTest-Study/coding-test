package 금;

public class 키패드_누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keypad = {
                {3, 1},
                {0, 0},
                {0, 1},
                {0, 2},
                {1, 0},
                {1, 1},
                {1, 2},
                {2, 0},
                {2, 1},
                {2, 2}
        };

        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPos = keypad[num];
            }
            else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPos = keypad[num];
            }
            else {
                int leftDist = distance(leftPos, keypad[num]);
                int rightDist = distance(rightPos, keypad[num]);

                if (leftDist < rightDist) {
                    answer.append("L");
                    leftPos = keypad[num];
                } else if (rightDist < leftDist) {
                    answer.append("R");
                    rightPos = keypad[num];
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        rightPos = keypad[num];
                    } else {
                        answer.append("L");
                        leftPos = keypad[num];
                    }
                }
            }
        }
        return answer.toString();
    }

    private int distance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }

}
