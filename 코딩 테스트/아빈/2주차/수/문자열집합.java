import java.io.*;
import java.util.*;

public class 문자열집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> s = new HashMap<>();
		for(int i = 0; i < n; i++){
			s.put(br.readLine(), i);
		}
		int count = 0;
		for(int i = 0; i < m; i++){
			if(s.containsKey(br.readLine())){
				count++;
			}
		}
		System.out.println(count);
	}
}