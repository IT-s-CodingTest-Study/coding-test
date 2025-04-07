
import java.io.*;
import java.util.*;

public class 풍선터뜨리기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Deque<int []> q = new ArrayDeque<>();	//중간요소 지우기 쉬워서
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int [] move_arr = new int [n];
		for(int i = 0; i < n; i++){
			move_arr[i] = Integer.parseInt(st.nextToken());
		}
		sb.append("1").append(" ");
		for(int i = 1; i < n; i++){
			q.add(new int [] {(i + 1), move_arr[i]});
		}

		int move = move_arr[0];
		while (!q.isEmpty()) {
			if(move >0) {
				for(int i = 1; i < move; i++){		//q를 다시 배치 시키면서 이동한 효과를 줌
					q.add(q.poll());
				}
				int [] next_move = q.poll();
				move = next_move[1];
				sb.append(next_move[0]).append(" ");
			} else {
				for(int i = 1; i < -move; i++) {
					q.addFirst(q.pollLast());
				}
				int [] next_move = q.pollLast();
				move = next_move[1];
				sb.append(next_move[0]).append(" ");
			}
		}
		System.out.println(sb);
	}
}