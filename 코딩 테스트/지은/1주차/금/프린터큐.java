import java.io.*;
import java.util.*;

public class 프린터큐 {

    // 작업 정보 클래스
    static class Job {
        int index; // 작업 번호
        int priority; // 우선순위

        Job(int index, int priority) {
            this.index = index; // 작업 인덱스 (0부터 시작)
            this.priority = priority; // 중요도 (1~9)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 테스트 케이스 수 입력 (예: 3)
        int testCaseCount = Integer.parseInt(br.readLine());

        // 2. 각 테스트 케이스에 대해 반복
        for (int testIndex = 0; testIndex < testCaseCount; testIndex++) {

            // 첫 줄 입력받기: 작업 수, 궁금한 작업의 인덱스 (예: "4 2")
            String[] input = br.readLine().split(" ");
            int jobCount = Integer.parseInt(input[0]); // 작업 수
            int targetIndex = Integer.parseInt(input[1]); // 타겟 인덱스

            // 우선순위 입력받기 (예: "1 2 3 4")
            String[] priorities = br.readLine().split(" ");
            // 작업정보 담을 큐
            Queue<Job> queue = new LinkedList<>();

            // 각 작업을 큐에 넣기 (인덱스 + 중요도 형태)
            for (int i = 0; i < jobCount; i++) {
                int priority = Integer.parseInt(priorities[i]); // i번째 작업의 중요도
                queue.offer(new Job(i, priority)); // 큐에 [index, priority] 저장
            }

            int printCount = 0; // 인쇄 순서 세는 변수

            while (!queue.isEmpty()) {
                Job current = queue.poll(); // 가장 앞에 있는 작업 꺼내기
                boolean hasMoreImportant = false;

                // 현재 작업보다 더 높은 중요도의 작업이 뒤에 있는지 확인
                Iterator<Job> iter = queue.iterator();
                while (iter.hasNext()) {
                    Job j = iter.next();
                    if (j.priority > current.priority) {
                        hasMoreImportant = true;
                        break;
                    }
                }

                // 더 중요한 작업이 있으면 뒤로 보냄
                if (hasMoreImportant) {
                    queue.offer(current);
                } else {
                    printCount++; // 없으면 현재 작업 인쇄
                    // 궁금했던 작업이면 결과 저장
                    if (current.index == targetIndex) {
                        sb.append(printCount).append("\n"); // 출력 순서 저장
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
