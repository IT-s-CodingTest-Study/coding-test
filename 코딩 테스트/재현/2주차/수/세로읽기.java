import java.io.BufferedReader;
import java.io.InputStreamReader;

class 세로읽기 {
    static BufferedReader br;
    static StringBuilder sb;
    static String[] words;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        words = new String[5];

        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            if(words[i].length() > max) max = words[i].length();
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (words[j].length() > i) {
                    sb.append(words[j].charAt(i));
                }
            }
        }

        System.out.println(sb);
        

    }
}