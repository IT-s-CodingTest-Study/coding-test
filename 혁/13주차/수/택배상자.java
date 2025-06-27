package 수;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        Stack<Integer> subBelt = new Stack<>();
        int box = 1;
        int index = 0;

        while (box <= order.length) {
            if (order[index] == box) {
                index++;
                box++;
            } else if (!subBelt.isEmpty() && subBelt.peek() == order[index]) {
                subBelt.pop();
                index++;
            } else {
                subBelt.push(box++);
            }
        }

        while (!subBelt.isEmpty() && subBelt.peek() == order[index]) {
            subBelt.pop();
            index++;
        }

        return index;
    }
}


