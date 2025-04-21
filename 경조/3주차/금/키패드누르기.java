import java.util.*;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // <키패드 번호, 위치 정보>
        HashMap<Integer, int[]> position = new HashMap<Integer, int[]>();
        position.put(1, new int[]{0, 0});
        position.put(2, new int[]{0, 1});
        position.put(3, new int[]{0, 2});
        position.put(4, new int[]{1, 0});
        position.put(5, new int[]{1, 1});
        position.put(6, new int[]{1, 2});
        position.put(7, new int[]{2, 0});
        position.put(8, new int[]{2, 1});
        position.put(9, new int[]{2, 2});
        position.put(11, new int[]{3, 0}); // * 대신 11
        position.put(0, new int[]{3, 1});
        position.put(12, new int[]{3, 2}); // # 대신 12

        //왼손, 오른손 위치
        int[] leftPosition = position.get(11);
        int[] rightPosition  = position.get(12);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < numbers.length; i++) {
            // 1, 4, 7의 경우 왼손
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                leftPosition = position.get(numbers[i]);
            }
            // 3, 6, 9의 경우 오른손
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                rightPosition = position.get(numbers[i]);
            }
            // 2, 4, 8, 0의 경우
            else {
                int[] target = position.get(numbers[i]);    // 대상 위치
                // 절댓값으로 계산
                int leftDistance = Math.abs(target[0] - leftPosition[0]) + Math.abs(target[1] - leftPosition[1]);
                int rightDistance = Math.abs(target[0] - rightPosition[0]) + Math.abs(target[1] - rightPosition[1]);
                if(leftDistance < rightDistance) {
                    sb.append("L");
                    leftPosition = target;
                }
                else if(rightDistance < leftDistance) {
                    sb.append("R");
                    rightPosition = target;
                }
                else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        leftPosition = target;
                    }
                    else if(hand.equals("right")) {
                        sb.append("R");
                        rightPosition = target;
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}
