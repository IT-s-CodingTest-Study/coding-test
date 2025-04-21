import java.io.*;
import java.util.*;

public class 큐2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue queue = new Queue();

		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()){
				case "push" : queue.push(Integer.parseInt(st.nextToken())); break;
				case "pop" : sb.append(queue.pop()).append("\n"); break;
				case "size" : sb.append(queue.size()).append("\n"); break;
				case "empty" : sb.append(queue.empty()).append("\n"); break;
				case "front" : sb.append(queue.front()).append("\n"); break;
				case "back" : sb.append(queue.back()).append("\n"); break;
			}
		}
		System.out.println(sb);
	}
}
class Queue {
	private final LinkedList<Integer> q = new LinkedList<>();
	public void push(int x) {
		this.q.addLast(x);
	}
	public int pop(){
		return this.q.isEmpty() ? -1 : q.pollFirst();
	}
	public int size(){
		return this.q.size();
	}
	public int empty(){
		return this.q.isEmpty() ? 1 : 0;
	}
	public int front(){
		return this.q.isEmpty() ? -1 : q.getFirst();
	}
	public int back(){
		return this.q.isEmpty() ? -1 : q.getLast();
	}
}