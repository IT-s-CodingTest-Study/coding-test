import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        String[] words = new String[5];

        for(int j =0; j<5; j++){
            words[j] = br.readLine();
        }

        for(int i =0; i< 15; i++){
            for(int j =0; j<5; j++){
                if (i < words[j].length() && words[j].charAt(i) != ' ') {
                    result += words[j].charAt(i);
                }
            }
        }
            System.out.print(result);
    }
}
