public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        for(int n=1;n<=s.length()/2;n++) {
            int count = 1;
            StringBuffer sb = new StringBuffer();
            String str1 = s.substring(0, n);
            for(int i = n; i <= s.length()-n; i+=n) {
                String str2 = s.substring(i, i+n);
                if(str1.equals(str2)) {
                    count++;
                }
                else{
                    if(count > 1) {
                        sb.append(count);
                    }
                    sb.append(str1);
                    str1 = str2;
                    count = 1;
                }
            }
            if(count > 1) {
                sb.append(count);
            }
            sb.append(str1);
            if(s.length() % n != 0) {
                sb.append(s.substring(s.length()- s.length() % n));
            }
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
