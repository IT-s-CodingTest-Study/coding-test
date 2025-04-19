import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> balloon = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        //풍선 값을 입력받아 deque에 저장
        for(int i =0; i<n;i++){
            int index = Integer.parseInt(st.nextToken());
            balloon.offer(new int[]{i, index});
        }
        for(int i =0; i<n; i++){
            int[] current = balloon.pollFirst();
            sb.append(current[0]+1).append(" ");

            if (balloon.isEmpty())break;

            //이동할 값
            int move = current[1];

            if(move > 0){
                for(int j = 1; j<move; j++){
                    balloon.addLast(balloon.pollFirst());
                }
            }else{
                for(int j =0; j < -move; j++){
                    balloon.addLast(balloon.pollFirst());
                }
            }
        }
        System.out.println(sb);
    }
}
