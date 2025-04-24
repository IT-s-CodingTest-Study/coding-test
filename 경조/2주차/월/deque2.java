import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class deque2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Balloon> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        // 움직일 값 arr 배열에 저장
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 무조건 첫 풍선부터 조회하기
        sb.append("1 ");
        int move = arr[0];

        for(int i = 1; i < n; i++) {
            deque.offer(new Balloon(i+1, arr[i]));
        }

        while(!deque.isEmpty()) {
            if(move > 0) { // 양수인 경우
                // move-1 만큼 반복
                for(int i = 1; i < move; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                Balloon next = deque.pollFirst();
                move = next.move;
                sb.append(next.index+" ");
            }
            else { // 음수인 경우
                // move-1 만큼 반복
                for(int i = 1; i < -move; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                Balloon next = deque.pollLast();
                move = next.move;
                sb.append(next.index+" ");
            }
        }
        System.out.println(sb);
    }
}

// 인덱스, 움직일 값 가지고 있는 풍선 클래스
class Balloon {
    int index;
    int move;

    public Balloon(int index, int move) {
        this.index = index;
        this.move = move;
    }
}
