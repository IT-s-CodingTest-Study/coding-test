import java.io.*;

public class 세로읽기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char [][] char_arr = new char[5][15];
		int max_length = 0;

		for(int i = 0; i < char_arr.length; i++){
			String str = br.readLine();
			if(max_length < str.length()) {
				max_length = str.length();
			}
			for(int j = 0; j < str.length(); j++){
				char_arr[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i < max_length; i++){
			for(int j = 0; j < char_arr.length; j++) {
				if(char_arr[j][i] == '\u0000'){
					continue;
				}
				sb.append(char_arr[j][i]);
			}
		}
		System.out.println(sb);
	}
}