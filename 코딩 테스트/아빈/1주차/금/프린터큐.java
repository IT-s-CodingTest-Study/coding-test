import java.io.*;
import java.util.*;

public class 프린터큐 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test = Integer.parseInt(br.readLine());
		for(int i = 0; i < test; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int count = 0;
			st = new StringTokenizer(br.readLine());

			LinkedList<int []> queue = new LinkedList<>();
			for(int j = 0; j < n; j++){
				queue.add(new int [] {j, Integer.parseInt(st.nextToken())});
			}

			while (!queue.isEmpty()){
				int [] im = queue.pollFirst();
				boolean max = true;

				for(int k = 0; k < queue.size(); k++){
					if(im[1] < queue.get(k)[1]) {    //중요도 비교
						//중요도가 작으면 맨뒤로
						queue.add(im);

						max = false;
						break;
					}
				}
				if(!max){
					continue;
				}
				count++;
				if(im[0] == m){	//출력한 문서가 궁금한 문서일때
					break;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}