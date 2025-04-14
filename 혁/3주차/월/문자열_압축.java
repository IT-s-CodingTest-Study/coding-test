package 월;

public class 문자열_압축 {
    public int solution(String s) {
        int minLength = s.length();
        for (int a = 1; a <= s.length() / 2; a++) {
            StringBuilder sb = new StringBuilder();
            String prev = "";
            int count = 1;
            for (int i = 0; i < s.length(); i += a) {
                String current;
                if (i + a <= s.length()) {
                    current = s.substring(i, i + a);
                } else {
                    current = s.substring(i);
                }
                if (current.equals(prev)) {
                    count++;
                } else {
                    if (!prev.isEmpty()) {
                        sb.append(count > 1 ? count : "").append(prev);
                    }
                    prev = current;
                    count = 1;
                }
            }
            if (!prev.isEmpty()) {
                sb.append(count > 1 ? count : "").append(prev);
            }
            minLength = Math.min(minLength, sb.length());
        }
        return minLength;
    }
}