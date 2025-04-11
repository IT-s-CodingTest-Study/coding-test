import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        char[][] arr = new char[5][15]; // 입력 5줄 각 줄에는 최대 15개 글자
        for(int i = 0; i < 5; i++) {
            String line =  br.readLine();
            for(int j=0; j < line.length(); j++) {
                // 글자 하나씩 나누기
                arr[i][j] = line.charAt(j);
            }
        }
        // 세로로 출력해야 하므로 [행][열] 순서가 아닌 [열][행] 순서로 반복
        for(int j = 0; j < 15; j++) {
            for(int i = 0; i < 5; i++) {
                if(arr[i][j] != '\0') {
                    sb.append(arr[i][j]);
                }
            }
        }
        System.out.println(sb);
    }
}
