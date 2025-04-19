import java.io.*;
public class 스택 {
	public static int [] answer;
	public static int length = 0;
	public static void push(int X){
		answer[length] = X;
		length++;
	}
	public static int pop(){
		if(length == 0) {
			return -1;
		}
		int pop = answer[length - 1];
		answer[length - 1] = 0;
		length--;
		return pop;
	}
	public static int size(){
		return length;
	}
	public static int empty(){
		if(length == 0) {
			return 1;
		}
		return 0;
	}
	public static int top(){
		if(length == 0){
			return -1;
		}
		return answer[length - 1];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		answer = new int[N];
		for(int i = 0; i < N; i++){
			String order = br.readLine();
			int a = 0;
			if(order.contains("push")){
				String [] oa = order.split(" ");
				push(Integer.parseInt(oa[1]));
			} else {
				switch (order){
					case "pop" : a = pop() ; break;
					case "size" : a = size(); break;
					case "empty" : a = empty(); break;
					case "top" : a = top(); break;
				}
				sb.append(a).append("\n");
			}
		}
		System.out.println(sb);
	}
}