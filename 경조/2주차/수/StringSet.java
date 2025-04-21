import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        String[] arr = new String[size];
        for(int i = 0; i < size; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0; i < num; i++){
            String str = br.readLine();
            for(String s : arr){
                if(s.equals(str)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
