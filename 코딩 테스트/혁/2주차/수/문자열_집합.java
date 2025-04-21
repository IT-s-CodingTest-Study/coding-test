package 수;

import java.io.*;
import java.util.ArrayList;

public class 문자열_집합{

    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<String>strArr = new ArrayList<>();
    public static ArrayList<String>strArr2 = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        String []part = br.readLine().split(" ");
        int num1 = Integer.parseInt(part[0]);
        int num2 = Integer.parseInt(part[1]);
        int a =0;
        for(int i =0; i<num1; i++){
            strArr.add(br.readLine());
        }
        for(int i =0; i<num2; i++){
            strArr2.add(br.readLine());
        }
        for(int i =0; i<num2; i++){
            if(strArr.contains(strArr2.get(i))){
                a++;
            }
        }
        sb.append(a);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
