package 수;

import java.io.*;

public class 세로읽기 {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] lines = new String[5];
        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
        }
        int maxLength = 0;
        for (String line : lines) {
            maxLength = Math.max(maxLength, line.length());
        }
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if(i<lines[j].length()){
                    sb.append(lines[j].charAt(i));
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
