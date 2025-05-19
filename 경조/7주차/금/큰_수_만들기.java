public class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int start = 0;
        for(int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for(int j = start; j <= k + i; j++) {
                int num = number.charAt(j) - '0';
                if(max < num) {
                    max = num;
                    start = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
