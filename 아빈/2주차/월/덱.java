import java.io.*;
import java.util.*;

public class 덱 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.contains("push")){
				switch (order.split("_")[1]){
					case "front" : deque.offerFirst(Integer.parseInt(st.nextToken())); break;
					case "back"  : deque.offerLast(Integer.parseInt(st.nextToken())); break;
				}
			} else if(order.contains("pop")){
				switch (order.split("_")[1]) {
					case "front":
						sb.append(!deque.isEmpty() ? deque.pollFirst() : "-1").append("\n");
						break;
					case "back":
						sb.append(!deque.isEmpty() ? deque.pollLast() : "-1").append("\n");
						break;
				}
			} else {
				switch (order){
					case "size" : sb.append(deque.size()).append("\n"); break;
					case "empty" :
						sb.append(deque.isEmpty() ? "1" : "0").append("\n");
						break;
					case "front" :
						sb.append(deque.peekFirst() != null ? deque.peekFirst() : "-1").append("\n");
						break;
					case "back" :
						sb.append(deque.peekLast() != null ? deque.peekLast() : "-1").append("\n");
						break;
				}
			}
		}
		System.out.println(sb);
	}
}