package 수;

public class 스킬트리 {
    public int solution(String s, String[] t) {
        int c = 0;
        for (String x : t) {
            String f = "";
            for (int i = 0; i < x.length(); i++) {
                char ch = x.charAt(i);
                if (s.indexOf(ch) != -1) f += ch;
            }
            if (s.startsWith(f)) c++;
        }
        return c;
    }
}
