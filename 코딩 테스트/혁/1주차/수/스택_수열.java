import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> targetSequence = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> operations = new ArrayList<>();

        int num = Integer.parseInt(br.readLine());
        // 목표 수열 입력 받기
        for (int i = 0; i < num; i++) {
            targetSequence.add(Integer.parseInt(br.readLine()));
        }
        int currentNumber = 1; // 현재 푸시할 숫자
        for (int i = 0; i < num; i++) {
            int target = targetSequence.get(i);
            // 현재 숫자가 목표 숫자보다 작거나 같으면 계속 푸시
            while (currentNumber <= target) {
                stack.push(currentNumber++);
                operations.add('+'); // 푸시 연산 기록
            }
            // 스택의 최상위 숫자와 목표 숫자가 같으면 팝
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                operations.add('-'); // 팝 연산 기록
            } else {
                System.out.println("NO");
                return; 
            }
        }
        // 연산 결과 출력
        for (char op : operations) {
            System.out.println(op);
        }
    }
}
