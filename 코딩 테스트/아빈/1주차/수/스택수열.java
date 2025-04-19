import java.io.*;

public class 스택수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		int length = 0;
		int num = 1;
		for(int i = 0; i < N; i++){
			int input = Integer.parseInt(br.readLine());
			if(num <= input){
				while(num <= input) {
					arr[length] = num++;
					length++;
					sb.append("+\n");
				}
				arr[length - 1] = 0;
				length--;
				sb.append("-\n");
			} else {
				if (arr[length - 1] > input) {
					System.out.println("NO");
					System.exit(0);
				}
				arr[length - 1] = 0;
				length--;
				sb.append("-\n");
			}
		}
		System.out.println(sb);
	}
}