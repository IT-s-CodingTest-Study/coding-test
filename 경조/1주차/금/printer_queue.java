import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class printer_queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int testCase = Integer.parseInt(br.readLine()); // 테스트케이스 횟수

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()); // 문서의 개수
            int index = Integer.parseInt(st.nextToken()); // 인쇄 순서 확인하고 싶은 문서

            Deque<int[]> queue = new LinkedList<>(); // 각 테스트 케이스마다 큐가 만들어짐

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{ j, priority }); // [ 문서 번호, 중요도 ] 로 저장됨
            }

            int count = 0; // 출력 횟수 카운팅

            while (!queue.isEmpty()) {
                int[] front = queue.remove();
                boolean isMax = true;
                // queue의 모든 요소(int[] 배열)를 하나씩 조회하여 비교
                for (int[] q : queue) {
                    // 현재 문서보다 중요도가 높은 문서가 있다면 종료
                    if(front[1] < q[1]) {
                        isMax = false;
                        break;
                    }
                }

                if(isMax) {
                    count++;
                    // 중요도가 가장 높은데 알고자 하는 문서였다면 종료
                    if(front[0] == index){
                        sb.append(count).append("\n");
                        break;
                    }
                }
                else {
                    queue.add(front);
                }
            }
        }
        System.out.println(sb);
    }
}
